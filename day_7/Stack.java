package day_7;

import java.util.Scanner;

class Node4{
    Integer val;
    Node4 next;
    static Node4 head;
    static Node4 tail;

    Node4(Integer val){
        this.val=val;
        next=null;
    }

    void push(Integer val){
        Node4 n=new Node4(val);
        n.next=head;
        head=n; 
    }

    Integer pop(){
        if(head!=null){
            Integer val=head.val;
            head= head.next;
            return val;
        }
        return -1;
        
    }
    void peek(){
        if(head!=null){
            System.out.println("Top element is "+head.val);
            return;
        }
    }

    void traverse(){
        Node4 node=head;
        System.out.print("The elements are: ");
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();
    }
}

public class Stack {
    public static void main(String[] args) {
        
        
        Integer flag=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first element of the list");
        Node4 node=new Node4(sc.nextInt());
        node.head=node;
        node.tail=node;
        while(flag==1){
            System.out.println("Enter the number of the below option to do list operation");
            System.out.println("1. PUSH A ELEMENT");
            System.out.println("2. VIEW STACK");
            System.out.println("3. POP A ELEMENT");
            System.out.println("4. PEEK");
            System.out.println("5. EXIT");
            Integer opt=sc.nextInt();
            switch(opt){
                case 1:System.out.println("Enter the value to add");
                        node.push((sc.nextInt()));
                        break;
                case 2:node.traverse();
                        break;
                case 3:System.out.println(node.pop());
                        
                        break;
                case 4:node.peek();
                        break;
                case 5:flag=0;
                        break;
            }
            
        }
        
    }
}
