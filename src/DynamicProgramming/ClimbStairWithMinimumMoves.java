//1. You are given a number n, representing the number of stairs in a staircase.
//        2. You are on the 0th step and are required to climb to the top.
//        3. You are given n numbers, where ith element's value represents - till how far from the step you
//        could jump to in a single move.  You can of-course fewer number of steps in the move.
//        4. You are required to print the number of minimum moves in which you can reach the top of
//        staircase.
//        Note -> If there is no path through the staircase print null.

//Difference btw int arr and integer array
//int arr have 0 as initial val while Integer array has null as initial value
//        arr[i] = 5 for int arr 5 is stored at index i while in Integer arr address of 5 is stored at index i


package DynamicProgramming;

import java.util.Scanner;

public class ClimbStairWithMinimumMoves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int ans = climb(n, arr);
        System.out.println(ans);
    }

    public static int climb(int n, int[] arr){
        //In this question we have to use Interger array
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
            if(arr[i] > 0){
                int min = Integer.MAX_VALUE;
                for(int jump = 1; jump <= arr[i] && i+jump < dp.length; jump++){
                    if(dp[i+jump] != null){
                        min = Math.min(min,dp[i+jump]);
                    }
                }

                if(min != Integer.MAX_VALUE){
                    dp[i] = min+1;
                }

            }
        }
        return dp[0];
    }
}