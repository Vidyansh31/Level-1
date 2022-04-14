package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MergeOverlappingStack {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void display(int[][] ans){
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i][0] + " "+ ans[i][1]);
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Arrays.sort(arr,(a, b) -> {
            return a[0] - b[0];
        });

        Stack<int[]> st = new Stack<>();
        st.push(arr[0]);

        for(int i = 1; i < arr.length; i++){
            int[] top = st.pop();
            int s1 = top[0];
            int e1 = top[1];
            int s2 = arr[i][0];
            int e2 = arr[i][1];
            if(e1 >= s2){
                int em = Math.max(e1,e2);

                st.push(new int[] {s1,em});
            }
            else{
                st.push(top);
                st.push(arr[i]);
            }
        }

        int[][] ans = new int[st.size()][2];

        for(int i = ans.length-1; i >= 0; i--){
            int[] t = st.pop();
            ans[i][0] = t[0];
            ans[i][1] = t[1];
        }

        display(ans);
    }


//                    or

    public static void mergeOverlappingIntervals1(int[][] arr){
        Pair[] pair = new Pair[arr.length];
        for(int i = 0; i < arr.length; i++){
            pair[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(arr);

        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < pair.length; i++){
            if(i == 0){
                st.push(pair[i]);
            }else{
                Pair top = st.peek();

                if(pair[i].st > top.et){
                    st.push(pair[i]);
                }
                else{
                    top.et = Math.max(pair[i].et, top.et);
                }
            }
        }

        Stack<Pair> rs = new Stack<>();
        while(st.size() > 0){
            rs.push(st.pop());
        }

        while(rs.size() > 0){
            Pair top = rs.pop();
            System.out.println(top.st+" "+top.et);
        }
    }

    public static class Pair implements Comparable<Pair> {
        int st ;
        int et;

        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        //this > state return +
        //this = state return 0
        //this < state return -
        public int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st;
            }
            else{
                return this.et-other.et;
            }
        }
    }
}
