package day_7;

import java.util.Scanner;

class Node2{
    Integer val;
    Node2 next;
    Node2 prev;
    static Node2 head;
    static Node2 tail;
    static Integer size=1;

    Node2(Integer val){
        this.val=val;
        next=null;
        this.prev=null;
    }

    void add(Integer val){
        Node2 n=new Node2(val);
        tail.next=n;
        n.prev=tail;
        tail=n;
        size++;
    }

    void remove(Integer val){
        if(head.val==val){
            head= head.next;
            head.prev=null;
            return;
        }
        Node2 cur=head.next;
        while(cur.val!=val && cur.next!=null){
            cur=cur.next;
        }
        if(cur.val==val && cur.next!=null){
        cur.next.prev=cur.prev;
        cur.prev.next=cur.next;
        }else if(cur.val==val && cur.next==null){
            cur.prev.next=cur.next;
            tail=tail.prev;
        
        }
        else{
        System.out.println("The given element "+val+" is not in the list");
    return;
    }
    size--;
        
    }

    void insert(Integer val,Integer pos){
        size++;
        if(pos>=size){
            add(val);
            return;
        }
        
        
        Node2 newNode=new Node2(val);
        if(pos==size){
            tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        return;
        }
        Node2 node=head;
        if(pos==1){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
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
        Node2 pre=null,cur,temp=head;
        cur=head;
        while(cur!=tail){
            pre=cur.prev;
            cur.prev=cur.next;
            cur.next=pre;
            cur=cur.prev;
        }
        cur.next=cur.prev;
        cur.prev=null;
        tail=temp;
        head=cur;


    }

    void find(Integer val){
        Node2 node=head;
        Integer index=0;
        while(node.val!=val && node.next!=null){
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
        Node2 node=head;
        System.out.print("The elements are: ");
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();
    }
}


public class DoublyLinkListEg {
     public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first element of the list");
        Node2 node=new Node2(sc.nextInt());
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
                        break;
                case 7:flag=0;
                        break;
            }
            
        }
       
    }
}
