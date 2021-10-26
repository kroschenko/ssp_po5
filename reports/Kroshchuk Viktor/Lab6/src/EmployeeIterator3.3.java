package com.company;
import java.util.Iterator;
import java.util.List;

public class EmployeeIterator implements Iterator<Employee> {
    private List<Employee> files;
    private int position;

    public EmployeeIterator(List<Employee> files) {
        this.files = files;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < files.size();
    }

    @Override
    public Employee next() {
        return files.get(position++);
    }

}
