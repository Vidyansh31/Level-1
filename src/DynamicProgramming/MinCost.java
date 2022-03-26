package DynamicProgramming;

import java.util.Scanner;

public class MinCost {
    public static Scanner scn = new Scanner(System.in);

    public static void input(int[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);
        int[][] dp = new int[n][m];
        // int ans = MinCost(0,0,n-1,m-1,arr,0);
        // int ans1 = MinCostM(0,0,n-1,m-1,arr,0,dp);
        int ans2 = MinCostT(0,0,n-1,m-1,arr,dp);
        // System.out.println(ans);
        // System.out.println(ans1);
        System.out.println(ans2);


    }


    public static int MinCost(int sr,int sc, int dr,int dc, int[][] arr, int cost){

        if(sr == dr && sc == dc){
            cost += arr[sr][sc];
            // ans = Math.min(ans,cost);
            return cost;
        }

        int ans = 99999;
        if(sr+1 <= dr){
            int hr = MinCost(sr+1,sc,dr,dc,arr,cost+arr[sr][sc]);
            ans = Math.min(ans,hr);

        }
        if(sc+1 <= dc){
            int vr = MinCost(sr,sc+1,dr,dc,arr,cost+arr[sr][sc]);
            ans = Math.min(ans,vr);
        }

        return ans;

    }

    public static int MinCostT(int SR, int SC, int dr, int dc, int[][] arr,int[][] dp){

        for(int sr = dr; sr >= 0; sr--){
            for(int sc = dc; sc>=0; sc--){
                if(sr == dr && sc==dc){
                    dp[sr][sc] = arr[sr][sc];

                }
                else if(sr == dr){
                    dp[sr][sc] = arr[sr][sc] + dp[sr][sc+1];

                }
                else if(sc == dc){
                    dp[sr][sc] = arr[sr][sc] + dp[sr+1][sc];
                }
                else{
                    int min = Math.min(dp[sr+1][sc] , dp[sr][sc+1]);
                    dp[sr][sc] = arr[sr][sc] + min;
                }

            }
        }

        return dp[SR][SC];
    }

}