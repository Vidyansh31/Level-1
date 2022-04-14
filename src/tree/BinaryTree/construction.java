package tree.BinaryTree;

import java.util.Stack;

public class construction {
    public static class Node{
        int data;
        Node left;
        Node right;

        //Creating constructor
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right= right;
        }

        Node(int data){
            this.data = data;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0]);

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

       int idx = 1;

       while(st.size() > 0){
           Pair top = st.peek();

           if(top.state == 1){
               //waiting for left child
               if(arr[idx] != null){
                   Node leftChild = new Node(arr[idx]);
                   top.node.left = leftChild;

                   Pair left_pair = new Pair(leftChild,1);
                   st.push(left_pair);
               }
               idx++;
               top.state++;
           }
           else if(top.state == 2){
               //waiting for right child
               if(arr[idx] != null){
                   Node rightChild = new Node(arr[idx]);
                   top.node.right = rightChild;

                   Pair right_pair = new Pair(rightChild,1);
                   st.push(right_pair);
               }
               idx++;
               top.state++;
           }
           else{
               st.pop();
           }
       }

       return root;
    }

    public static void display(Node root){
        if(root == null){
            return;
        }

        String str = "<- " + root.data + " ->";

        String left = (root.left == null) ? "." : " "+root.left.data;
        String right = (root.right == null) ? "." : " "+root.right.data;
        str = left + str + right;

        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

        Node root = construct(arr);

        display(root);
    }
}
