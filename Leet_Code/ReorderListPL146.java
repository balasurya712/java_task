

package Leet_Code;

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
        Node n=new Node(1);
        n.head=n;
        n.tail=n;
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(5);
        n.add(6);
        n.traverse();
        s.reorderList(n);
        n.traverse();
    }
}

//output
// The elements are: 1 2 3 4 5 6 
// The elements are: 1 6 2 5 3 4