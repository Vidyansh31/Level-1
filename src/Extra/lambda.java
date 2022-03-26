package Extra;

import java.util.Arrays;

public class lambda {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{5,7},{3,12},{9,18},{6,10}};

        System.out.println("Sorting increasing using 0th index");
        Arrays.sort(arr,(a,b) -> {
            return a[0]-b[0];
        });
        for(int[] d : arr){
            System.out.println(d[0]+" "+ d[1]);
        }

        System.out.println("Sorting increasing using 1th index");
        Arrays.sort(arr,(a,b) -> {
            return a[1]-b[1];
        });
        for(int[] d : arr){
            System.out.println(d[0]+" "+ d[1]);
        }

        System.out.println("Sorting decreasing using 0th index");
        Arrays.sort(arr,(a,b) -> {
            return b[0]-a[0];
        });
        for(int[] d : arr){
            System.out.println(d[0]+" "+ d[1]);
        }

        System.out.println("Sorting decreasing using 1th index");
        Arrays.sort(arr,(a,b) -> {
            return b[1]-a[1];
        });
        for(int[] d : arr){
            System.out.println(d[0]+" "+ d[1]);
        }
    }
}
