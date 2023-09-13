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

    public void swapValue(Integer val1, Integer val2) {
        Node3 node=head.next;
        
        Node3 n1=null,n2=null;
        if(head.val==val1 )
        n1=head;
        if(head.val==val2)
        n2=head;
        if(tail.val==val1 )
        n1=tail;
        if(tail.val==val2)
        n2=tail;
        while(node.next!=head.next){
            if(node.val==val1){
                n1=node;
            }
            else if(node.val==val2){
                n2=node;
            }
            node=node.next;
        }
        if(n1!=null && n2!=null){
            if(n1.next==n2){
                n1.prev.next=n2;
                n2.next.prev=n1;
                n2.prev=n1.prev;
                n1.next=n2.next;
                n1.prev=n2;
                n2.next=n1;
                if(n1==head)
            head=n2;
            else if(n2==head)
            head=n1;
            if(n1==tail)
            tail=n2;
            else if(n2==tail)
            tail=n1;
            }
            else if(n2.next==n1){
                n2.prev.next=n1;
                n1.next.prev=n2;
                n1.prev=n2.prev;
                n2.next=n1.next;
                n2.prev=n1;
                n1.next=n2;
            if(n1==head)
            head=n2;
            else if(n2==head)
            head=n1;
            if(n2==tail)
            tail=n1;
            else if(n2==tail)
            tail=n2;
            }
            else{
            System.out.println(n1.val+" "+n2.val);
            Node3 temp=new Node3(0);
            temp.next=n1.next;
            temp.prev=n1.prev;

            n1.next=n2.next;
            n1.prev=n2.prev;

            n1.prev.next=n1;
            n1.next.prev=n1;

            n2.next=temp.next;
            n2.prev=temp.prev;
            
            System.out.println(n1.val+" "+n2.val);
            System.out.println(n1.prev.val+" "+n1.next.val);
            
            System.out.println(n1.prev.next.val+" "+n1.next.prev.val);
            System.out.println();
            System.out.println(n2.prev.val+" "+n2.next.val);
            n2.prev.next=n2;
            n2.next.prev=n2;
            System.out.println(n2.prev.next.val+" "+n2.next.prev.val);
             if(n1==head)
            head=n2;
            else if(n2==head)
            head=n1;
            if(n2==tail)
            tail=n1;
            else if(n2==tail)
            tail=n2;
           } 
            
            
            
            
            System.out.println(tail.next.val+" "+head.prev.val);

        
        }
        else{
            System.out.println("given value is not in the list");
        }
    
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
            System.out.println("7. SWAP NODES");
            System.out.println("8. EXIT");
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
                case 7:System.out.println("Enter the values to be swaped");
                        System.out.println("Enter the value 1");
                        Integer val1=sc.nextInt();
                        System.out.println("Enter the value 2");
                        node.swapValue(val1,sc.nextInt());
                        break;
                case 8:flag=0;
                        break;
            }
            
        }
       
    }
}
