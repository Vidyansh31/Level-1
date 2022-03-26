package DynamicProgramming;

import java.util.Scanner;

public class GoldMines {
    public static Scanner scn = new Scanner(System.in);

    public static void input(int[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);


        //Recursive and Memoization
//        int[][] dp = new int[n][m];
//        int maxGold = Integer.MIN_VALUE;
//        for(int i = 0; i < n ; i++){
////            int ansR = collectGold(i,0,arr);
//            int ansR = collectGoldM(i,0,arr,dp);
//            maxGold = Math.max(ansR,maxGold);
//        }
//        System.out.println(maxGold);

        //Tabulation
        int ans = collectGoldT(arr);
        System.out.println(ans);
    }

    public static int collectGoldT(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for(int j = m-1; j >= 0; j--){
            for(int i = 0; i < n; i++){
                if(j == m-1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                }
                else if(i == n-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                }
                else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j+1],Math.max(dp[i][j+1],dp[i+1][j+1]));
                }
            }
        }

        int max = -1;
        for(int i = 0; i < dp.length; i++){
            max = Math.max(dp[i][0],max);
        }

        return max;
    }

    public static int collectGold(int i, int j, int[][] arr){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length){
            return 0;
        }
        int a = collectGold(i-1,j+1,arr);
        int b = collectGold(i, j+1,arr);
        int c = collectGold(i+1,j+1,arr);

        return Math.max(a,Math.max(b,c))+arr[i][j];
    }

    public static int collectGoldM(int i, int j, int[][] arr,int[][] dp){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int a = collectGoldM(i-1,j+1,arr,dp);
        int b = collectGoldM(i, j+1,arr,dp);
        int c = collectGoldM(i+1,j+1,arr,dp);

        return dp[i][j] = Math.max(a,Math.max(b,c))+arr[i][j];
    }


}
