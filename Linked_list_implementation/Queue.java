package Linked_list_implementation;

import java.util.Scanner;

class Node5{
    Integer val;
    Node5 next;
    static Node5 rear;
    static Node5 front;

    Node5(Integer val){
        this.val=val;
        next=null;
    }

    void enque(Integer val){
        Node5 n=new Node5(val);
        front.next=n;
        front=n; 
    }

    Integer deque(){
        if(rear!=null){
            Integer val=rear.val;
            rear= rear.next;
            return val;
        }
        return -1;
        
    }
    void peek(){
        if(rear!=null){
            System.out.println("top element is"+rear.val);
            return;
        }
    }

    void traverse(){
        Node5 node=rear;
        System.out.print("The elements are: ");
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();
    }
}

public class Queue {
    public static void main(String[] args) {
        
        Integer flag=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first element of the list");
        Node5 node=new Node5(sc.nextInt());
        node.rear=node;
        node.front=node;
        while(flag==1){
            System.out.println("Enter the number of the below option to do list operation");
            System.out.println("1. ENQUE A ELEMENT");
            System.out.println("2. VIEW QUEUE");
            System.out.println("3. DEQUE A ELEMENT");
            System.out.println("4. PEEK");
            System.out.println("5. EXIT");
            Integer opt=sc.nextInt();
            switch(opt){
                case 1:System.out.println("Enter the value to add");
                        node.enque((sc.nextInt()));
                        break;
                case 2:node.traverse();
                        break;
                case 3:System.out.println(node.deque());
                        
                        break;
                case 4:node.peek();
                        break;
                case 5:flag=0;
                        break;
            }
            
        }
    }
}
