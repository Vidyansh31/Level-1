package DynamicProgramming;

import java.util.Scanner;

public class countBinary {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ans = count(n);
        System.out.println(ans);
    }

    public static int count(int n){
        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];

        dp0[1] = 1;
        dp1[1] = 1;

        for(int i = 2; i <=n; i++ ){
            dp0[i] = dp1[i-1];
            dp1[i] = dp0[i-1]+dp1[i-1];
        }

        return dp0[n]+dp1[n];

    }
}
