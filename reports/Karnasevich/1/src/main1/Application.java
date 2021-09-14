package main1;

import java.util.*;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {
        System.out.println(findMode(List.of(1, 2, 3, 4, 5, 1, 2, 3, 3)));
        var array = new double[]{1, 2, 3, 4, 5};
        shiftRight(array, 2);
        System.out.println(Arrays.toString(array));
        System.out.println(pangramEng("defghijklmnopqrstuvwxyzsd"));
    }

    public static List<Integer> findMode(Collection<Integer> collection){
        var counts = new HashMap<Integer, Integer>();
        collection.forEach(x -> counts.merge(x, 1, Integer::sum));
        var theMostFrequent = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        for (var entry : counts.entrySet()){
            if (entry.getValue() > max){
                theMostFrequent.clear();
                theMostFrequent.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max){
                theMostFrequent.add(entry.getKey());
            }
        }
        return theMostFrequent;
    }

    public static void shiftRight(double[] array, int shift){
//        for (int i = 0; i < array.length - shift; i++){
//            array[i + shift] = array[i];
//        }
//        for (int i = 0; i < shift; i++){
//            array[i] = 0;
//        }
        System.arraycopy(array, 0, array, shift, array.length - shift);
        Arrays.fill(array, 0, shift, 0);
    }

    public static boolean pangramEng(String str){
        var alphabet = "abcdefghijklmnopqrstuvwxyz".chars().boxed().collect(Collectors.toSet());
        str = str.toLowerCase();
        str.chars().forEach(ch -> alphabet.removeIf(x -> x == ch));
        return alphabet.size() < 3;
    }
}
