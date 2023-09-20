package Leet_Code;

import java.util.Scanner;

class Node{
    Integer val;
    Node next;
    static Node head;
    static Node tail;
    static Integer size=1;

    Node(Integer val){
        this.val=val;
        next=null;
    }

    void add(Integer val){
        Node n=new Node(val);
        tail.next=n;
        tail=n;
        size++;
        
    }

     void traverse(){
        Node node=head;
        System.out.print("The elements are: ");
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();
    }
}

class Solution {
    Node reverse(Node head){
        Node prev=null,temp;

        while(head!=null){
            temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
    public void reorderList(Node head) {
        Node temp=head,mid;
        Integer count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(count<=2){
            return;
        }
        mid=head;
        Integer i=1;
        while(i<=count/2){
        mid=mid.next;
        i++;
        }
        mid=reverse(mid);

        temp=head;
        Node firstNext;
        while(mid!=null && temp!=null){
            firstNext=temp.next;
            temp.next=mid;
            mid=mid.next;
            temp=temp.next;
            temp.next=firstNext;
            temp=temp.next;
        }
        if(temp!=null){
            temp.next=null;
        }

        
    }
}

public class ReorderListPL146{
    public static void main(String[] args) {
        Solution s=new Solution();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the root node value");
        Node n=new Node(sc.nextInt());
        n.head=n;
        n.tail=n;
        Integer a;
        while(true){
            System.out.println("Would you like to add element 1.yes 2.no");
            
            if(sc.nextInt()==2)
            break;
            System.out.println("Enter the Element value");
            a=sc.nextInt();
            n.add(a);
        }
        System.out.println("list original order");
        n.traverse();

        s.reorderList(n);
        System.out.println("list Reorder");
        n.traverse();
    }
}

//output
// The elements are: 1 2 3 4 5 6 
// The elements are: 1 6 2 5 3 4