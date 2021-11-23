package FirstTask;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

   public static void main(String[] args) {
        int[] array = new int[args.length];

        for (int i = 0; i < args.length; ++i) {
            array[i] = Integer.parseInt(args[i]);
        }
        sort( array );
        //new Solution().printSelect1(array);
        System.out.println();
        printSelect2(array);

    }

    public void printSelect1(int[] args) {
        double[] d = new double[args.length];
        for (int i = 0; i < args.length; ++i) {
            int tmp_d = 0;

            for (int j = 0; j < args.length; ++j) {
                if (i != j) {
                    tmp_d = (int) ((double) tmp_d + Math.pow((double) (args[i] - args[j]), 2.0D));
                }
            }

            d[i] = Math.sqrt((double) tmp_d);
        }

        int indexMax = 0;
        double max = d[indexMax];

        for (int i = 1; i < d.length; ++i) {
            if (max < d[i]) {
                max = d[i];
                indexMax = i;
            }
        }

        System.out.println(args[indexMax]);
    }

    public static void printSelect2(int[] args) {

        int length = args.length;
        int percent25 = (int)(length * 0.25);
        int percent75 = (int)(length * 0.75);
        double x_percent25 = (args[percent25] + args[percent25+1]) / 2 ;
        double x_percent75 = (args[percent75] + args[percent75+1]) / 2 ;
        double left_board = x_percent25 - 1.5 * (x_percent75 - x_percent25);
        double right_board = x_percent75 + 1.5 * (x_percent75 - x_percent25);
        for(int i =0; i < length; i++)
        {
            if(!((args[i]>=left_board) && (args[i]<=right_board)))
                System.out.println(args[i]);
        }
    }

    public static void sort(int[] args){
       int length = args.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < length; i++)
            list.add(args[i]);
        Collections.sort(list);
        for(int i = 0 ; i < length; i++)
            args[i] = list.get(i);
    }
}


