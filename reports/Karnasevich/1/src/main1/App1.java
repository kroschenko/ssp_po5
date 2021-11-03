package main1;

import java.util.*;
import java.util.stream.Collectors;


public class App1 {

    public static void main(String[] args) {
        var values = Arrays.stream(args)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(findMode(values));
    }

    public static List<Integer> findMode(Collection<Integer> collection) {
        var counts = new HashMap<Integer, Integer>();
        collection.forEach(x -> counts.merge(x, 1, Integer::sum));
        var modes = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        for (var entry : counts.entrySet()) {
            if (entry.getValue() > max) {
                modes.clear();
                modes.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }
        return modes;
    }
}
