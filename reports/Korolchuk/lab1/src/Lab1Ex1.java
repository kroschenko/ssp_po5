package com.spp.labs;

public class Lab1Ex1 {
    public static void main(String[] args) {
        double[] nums = new double[args.length];
        
        for (int i = 0; i < args.length; i++) {
            nums[i] = Double.parseDouble(args[i]);
        }
        
        boolean isSorted = false;
        double buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] > nums[i+1]){
                    isSorted = false;
 
                    buf = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = buf;
                }
            }
        }
        
        double median = 0;
        
        if (nums.length % 2 == 0) {
            median = nums[nums.length / 2] + nums[nums.length / 2 - 1];
            median /= 2;
        }
        else {
            median = nums[nums.length / 2];
        }
        
        System.out.println("Медиана: " + median);
    }
}
