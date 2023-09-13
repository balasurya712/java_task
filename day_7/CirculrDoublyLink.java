package day_7;

import java.util.Scanner;

class Node3{
    Integer val;
    Node3 next;
    Node3 prev;
    static Node3 head;
    static Node3 tail;
    static Integer size=1;

    Node3(Integer val){
        this.val=val;
        next=null;
        this.prev=null;
    }

    void add(Integer val){
        Node3 n=new Node3(val);
        n.next=head;
        n.prev=tail;
        head.prev=n;
        tail.next=n;
        tail=n;
        size++;
    }

    void remove(Integer val){
        if(head.val==val){
            head= head.next;
            head.prev=tail;
            tail.next=head;
            return;
        }

        Node3 cur=head.next;
        while(cur.val!=val && cur.next!=head){
            cur=cur.next;
        }

        if(cur.val==val && cur.next!=head){
        cur.next.prev=cur.prev;
        cur.prev.next=cur.next;
        }
        else if(cur.val==val && cur.next==head){

            cur.prev.next=cur.next;
            tail=tail.prev;
            head.prev=tail;
        }
        else{
        System.out.println("The given element "+val+" is not in the list");
    return;
    }
    size--;
        
    }

    void insert(Integer val,Integer pos){
        
        
        size++;
        System.out.println(size);
        Node3 newNode=new Node3(val);
        if(pos==size){
            tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        tail.next=head;
        head.prev=tail;
        System.out.println(tail.val+" "+tail.next.val+" "+tail.prev.val);
        return;
        }
        Node3 node=head;
        if(pos==1){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            tail.next=head;
            return;
        }
        while(pos>2){
            pos--;
            node=node.next;
        }
        newNode.next=node.next;
        newNode.prev=node;
        node.next=newNode;
        newNode.next.prev=newNode;

    }

    void reverse(){
        Node3 pre=tail,cur,nxt,temp=head;
        cur=head;
        nxt=cur.next;
        while(cur!=tail){
            pre=cur.prev;
            cur.prev=cur.next;
            cur.next=pre;
            cur=cur.prev;
        }
        cur.next=cur.prev;
        cur.prev=temp;
        tail=temp;
        head=cur;


    }

    void find(Integer val){
        Node3 node=head;
        Integer index=0;
        while(node.val!=val && node.next!=head){
            node=node.next;
            index++;
        }
        if(node.val==val){
            System.out.println("the element "+val+" is found at index "+index);
        }
        else{
            System.out.println("The given element "+val+" is not present in list");
        }
    }

    void traverse(){
        Node3 node=head;
        System.out.print("The elements are: ");
        while(node!=tail){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println(node.val);
    }
}


public class CirculrDoublyLink {
    public static void main(String[] args) {
        
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first element of the list");
        Node3 node=new Node3(sc.nextInt());
        node.head=node;
        node.tail=node;
        Integer flag=1;
        while(flag==1){
            System.out.println("Enter the number of the below option to do list operation");
            System.out.println("1. ADD A ELEMENT");
            System.out.println("2. VIEW LIST");
            System.out.println("3. REMOVE A ELEMENT");
            System.out.println("4. REVERSE LIST");
            System.out.println("5. FIND A ELEMENT");
            System.out.println("6. INSERT A ELEMENT");
            System.out.println("7. EXIT");
            Integer opt=sc.nextInt();
            switch(opt){
                case 1:System.out.println("Enter the value to add");
                        node.add(sc.nextInt());
                        break;
                case 2:node.traverse();
                        break;
                case 3:System.out.println("Enter the value to remove");
                        node.remove(sc.nextInt());
                        break;
                case 4:node.reverse();
                        break;
                case 5:System.out.println("Enter the value to be searched");
                        node.find(sc.nextInt());
                        break;
                case 6:System.out.println("Enter element to be inserted");
                        Integer vl=sc.nextInt();
                        System.out.println("Enter the index to be inserted");
                        node.insert(vl, sc.nextInt());
                        System.out.println(node.tail.val+" "+node.tail.next.val+" ");
                        break;
                case 7:flag=0;
                        break;
            }
            
        }
       
    }
}
