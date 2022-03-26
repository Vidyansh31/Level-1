package DynamicProgramming;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        boolean[][] dp = new boolean[n+1][tar+1];

        boolean ans = targetSum(arr,dp);
        System.out.println(ans);
    }

    public static boolean targetSum( int[] arr, boolean[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j == 0){
                    dp[i][j] = true;
                }
                else if( i == 0){
                    dp[i][j] = false;
                }
                else{
                    //real game
                    boolean notPlayed = dp[i-1][j];

                    boolean played = false;
                    if(j - arr[i-1] >= 0){
                        played = dp[i-1][j-arr[i-1]];
                    }

                    dp[i][j] = notPlayed || played;
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
