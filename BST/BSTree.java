package BST;

import java.util.ArrayList;
import java.util.Scanner;

class Node{
    Integer data;
    static Node root=null;
    Node left;
    Node right;

    Node(Integer data){
        this.data=data;
    }

    Node addNode(Integer data){
        Node n=new Node(data);
        if(root==null)
        root=n;
        return n;
    }

    void add(Node node,Integer data){
        if(data<node.data){
            if(node.left==null)
            node.left=addNode(data);
            else
            add(node.left, data);
        }
        else if(data>node.data){
            if(node.right==null)
            node.right=addNode(data);
            else
            add(node.right, data);
        }
        else
        System.out.println("Duplicate elements not allowed in Binary Search tree");
    }

    ArrayList<Integer> inorder(Node root,ArrayList<Integer> arr)
    {
        if(root==null)
        return arr;
        
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
        return arr;
    }

}

public class BSTree {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer>arr=new ArrayList<>();
        System.out.println("Enter the first node value");
        Node root=new Node(sc.nextInt());
        Integer chance;
        while(true){
            System.out.println("would you like to add value to tree 1.yes 2.no ");
            chance=sc.nextInt();
            if(chance==2) break;
            System.out.println("Enter the value: ");
            root.add(root, sc.nextInt());
        }
    
        arr=root.inorder(root,new ArrayList<Integer>());
        System.out.print("inorder: ");
        for(int i=0;i<arr.size();i++)
            System.out.print(arr.get(i) +" ");
        System.out.println();

    }
    
}
