package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterFrequencyElement {
    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 3, 4, 2, 1 };
        int len = 7;
        int max = Integer.MIN_VALUE;

        //to find the size of frequency array
        for(int i = 0; i < len; i++ ){
            if(a[i] > max){
                max = a[i];
            }
        }

        int[] freq = new int[max+1];

        //filling frequency arr
        for(int i = 0; i < len; i++){
            freq[a[i]]++;
        }

        NFG(a,len,freq);

    }

    public static void NFG(int[] a, int len, int[] freq){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        for(int i = 1; i < len; i++){
            if(freq[a[st.peek()]] > freq[a[i]]){
                st.push(i);
            }
            else{
                while(st.size() > 0 && freq[a[st.peek()]] < freq[a[i]]){
                    int idx = st.pop();
                    ans[idx] = a[i];
                }
                st.push(i);
            }
        }

        for (int i = 0; i < len; i++)
        {
            // Print the res list containing next
            // greater frequency element
            System.out.print(ans[i] + " ");
        }

    }
}
