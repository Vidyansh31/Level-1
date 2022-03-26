package DynamicProgramming;

import java.util.Scanner;

public class FriendPairing {
    public static void main(String[] args)  {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        // int ans = pairR(n);
        // int ans1 = pairM(n,dp);
        int ans2 = pairT(n,dp);
        // System.out.println(ans);
        // System.out.println(ans1);
        System.out.println(ans2);
    }

    public static int pairR(int n){
        if(n <= 2){
            return n;
        }

        return pairR(n-1) + (pairR(n-2))*(n-1);


    }

    public static int pairM(int n, int[] dp){
        if(n <= 2){
            return dp[n] = n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int ans = pairR(n-1) + (pairR(n-2))*(n-1);

        return dp[n] = ans;

    }

    public static int pairT(int N,  int[] dp){
        for(int n = 0; n < dp.length; n++){
            if(n <= 2){
                dp[n] = n;
                continue;
            }

            int ans = pairR(n-1) + (pairR(n-2))*(n-1);

            dp[n] = ans;
        }

        return dp[N];
    }
}