package day_7;

import java.util.Scanner;

class Node1{
    Integer val;
    Node1 next;
    static Node1 head;
    static Node1 tail;

    Node1(Integer val){
        this.val=val;
        next=null;
    }

    void add(Integer val){
        Node1 n=new Node1(val);
        n.next=head;
        tail.next=n;
        tail=n; 
    }

    void remove(Integer val){
        if(head.val==val){
            head= head.next;
            tail.next=head;
            return;
        }
        Node1 prev=null;
        Node1 cur=head.next;
        while(cur.val!=val && cur.next!=head){
            prev=cur;
            cur=cur.next;
        }
        if(cur.val==val){
        prev.next=cur.next;
        if(cur.next==head){
            tail=prev;
        }
        }
        else
        System.out.println("The given element "+val+" is not in the list");
        
    }

    void insert(Integer val,Integer pos){
        Node1 newNode=new Node1(val);
        Node1 node=head;
        if(pos==1){
            newNode.next=head;
            head=newNode;
            tail.next=head;
            return;
        }
        while(pos>2){
            pos--;
            node=node.next;
        }
        if(node.next==head){
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
            return;
        }
        newNode.next=node.next;
        node.next=newNode;

    }

    void reverse(){
        Node1 pre=tail,cur,nxt,temp=head;
        cur=head;
        nxt=cur.next;
        while(cur!=tail){
            cur.next=pre;
            pre=cur;
            cur=nxt;
            nxt=cur.next;
        }
        cur.next=pre;
        tail=temp;
        head=cur;


    }

    void find(Integer val){
        Node1 node=head;
        Integer index=0;
        while(node.val!=val && node!=tail){
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
        Node1 node=head;
        System.out.print("The elements are: ");
        while(node!=tail){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println(node.val);
    }
}


public class CircularList {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first element of the list");
        Node1 node=new Node1(sc.nextInt());
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