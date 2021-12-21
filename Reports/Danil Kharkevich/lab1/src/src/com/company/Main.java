package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++){

            nums[i] = Integer.parseInt(args[i]);

        }
        for (String c : args) {
            System.out.print(c);
        }
        System.out.println();

        //task 1

        float AvarageValue = CountingAverageValue(nums);
        System.out.println("Average value = " + AvarageValue);
        double SampleVariance = CountingSampleVariance(AvarageValue, nums);
        System.out.println("Sample variance = " + SampleVariance);

/*
        //task 2
        int ReverseNums[] = new int[length];
        ReverseNums = ReverseArray(nums);
        System.out.print("Reverse array: ");
        for (int c : ReverseNums) {
            System.out.print(c);
        }
        System.out.println();

        //task 3
        String Str = "А лис, он умен - крыса сыр к нему носила";
        if(Palindrome(Str)) System.out.println(Str + " is palindrome");
            else System.out.print(Str + " isn't palindrome");
*/
        return;
    }


    public static float CountingAverageValue(int ...nums) {
        int sum = 0;
        for (int c : nums) {
            sum+=c;
        }
        return (float)sum/nums.length;
    }

    public static double CountingSampleVariance(float AvarageValue, int ...nums) {
        int sum = 0;
        for (int c : nums) {
            sum+=c;
        }
        double sum1 = (double)1/nums.length*sum;
        sum1 = Math.pow(sum1,2);
        sum =0;
        for (int c : nums) {
            sum+=c*c;
        }
        double sum2 = (double) 1/nums.length*sum;
        double result = sum2 - sum1;
        return result;
    }

    public static int[] ReverseArray(int[] array) {
        int tmp = 0;
        for (int i = 0; i < (array.length/2); i++) {
            tmp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1]=tmp;
        }
        return array;
    }

    public static boolean Palindrome(String Str) {
        Str = Str.replaceAll("\\s+","");
        Str = Str.replaceAll("[-+.^:,]","");
        Str = Str.toLowerCase();
        for (int i = 0; i < (Str.length()/2); i++) {
            if (Str.charAt(i)!=Str.charAt(Str.length()-i-1))
                return false;
        }
        return true;
    }

}
