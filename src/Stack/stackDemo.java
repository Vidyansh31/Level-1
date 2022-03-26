package Stack;
import java.util.*;


public class stackDemo {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        st.pop();
        st.peek();


        System.out.println(st);
    }
}
