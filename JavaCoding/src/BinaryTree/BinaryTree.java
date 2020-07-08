package BinaryTree;

import java.util.Scanner;

public class BinaryTree {
    Node root;
    public BinaryTree(){
        root=null;
    }
    public BinaryTree(int value){
        this.root=new Node(value);
    }

    public static void main(String[] args) {
        int arr[]=getArray();
        BinaryTree tree=new BinaryTree();
        tree.root=createTreeFromArray(arr);
        printTree(tree.root);
        
    }

    private static void printTree(Node root) {
        if(root==null)
            System.out.println("Empty root");

    }

    private static Node createTreeFromArray(int[] arr) {
    return null;
    }

    private static int[] getArray() {
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int arr[]=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=scanner.nextInt();
        }
        return arr;
    }

}
