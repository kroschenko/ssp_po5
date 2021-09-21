package main1;

import java.util.*;


public class App1 {

    public static void main(String[] args) {
        System.out.println(findMode(List.of(1, 2, 3, 4, 5, 1, 2, 3, 3)));
        System.out.println(findMode(List.of()));
        System.out.println(findMode(List.of(1, 2, 3, 4, 5)));
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
