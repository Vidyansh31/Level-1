package Stack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ques {
    public static void main(String[] args) {
        String[] arr = {"Java","DotNet","MainFrame"};
        List<String> list = Arrays.asList(arr);

//        System.out.print(list);

        Stream.of(list).filter(e->e.equals("Java")== true).forEach(e->System.out.println(e));
    }
}
