package main6.task2;

import java.util.*;
import java.util.stream.Collectors;


public class HierarchicalEmployeeIterator implements Iterator<Iterator<Employee>> {

    private final Iterator<Map.Entry<Department, List<Employee>>> iterator;

    private Department department;

    private List<Employee> leaders;

    private Set<Employee> rest;

    public HierarchicalEmployeeIterator(List<Employee> employees) {
        var group = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        iterator = group.entrySet().iterator();
        if (iterator.hasNext()) {
            nextDepartment();
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || !rest.isEmpty();
    }

    private void nextDepartment() {
        var next = iterator.next();
        department = next.getKey();
        var nextEmployees = next.getValue();
        leaders = nextEmployees.stream()
                .filter(x -> !x.hasManager() || x.getManager().isPresent() && !x.getManager().get().getDepartment().equals(department))
                .collect(Collectors.toList());
        rest = new HashSet<>(nextEmployees);
    }

    @Override
    public Iterator<Employee> next() {
        if (rest.isEmpty()) {
            nextDepartment();
        }
        leaders.forEach(rest::remove);
        var it = leaders.iterator();
        leaders = leaders.stream()
                .flatMap(x -> x.getSubordinates().stream())
                .filter(x -> x.getDepartment().equals(department))
                .collect(Collectors.toList());
        return it;
    }
}
