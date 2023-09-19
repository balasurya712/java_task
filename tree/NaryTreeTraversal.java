import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NaryTree
{
    Integer data;
    static Integer height=0;
    NaryTree prev;
    static NaryTree root;
    ArrayList<NaryTree> ar=new ArrayList<>();
    NaryTree(int data)
    {
        this.data=data;
    }

    NaryTree(int data, NaryTree prev)
    {
        this.data=data;
        this.prev=prev;
    }

    NaryTree addNode(int data){
        NaryTree n=new NaryTree(data);
        return n;
    }

    NaryTree addNode(int data,NaryTree prev){
        NaryTree n=new NaryTree(data,prev);
        return n;
    }

    ArrayList<Integer> preorder(NaryTree root,ArrayList<Integer> arr)
    {
        if(root==null)
        return arr;
        arr.add(root.data);
        for (NaryTree n : root.ar) {
            preorder(n, arr);
        } 
        return arr;
    }

    
    ArrayList<Integer> postorder(NaryTree node,ArrayList<Integer> arr)
    {
        if(node==null)
        return arr;
        for (NaryTree n : node.ar) {
            postorder(n, arr);
        } 
        arr.add(node.data);
        return arr;
    }

    NaryTree find(NaryTree node,Integer data){
        if(node==null)
        return null;
        if(node.data==data)
        return node;
        NaryTree deletedNode=null;
        Integer i=0;
        Integer len=node.ar.size();
        for (;i<len;i++) {
            
            deletedNode=find(node.ar.get(i), data);
            if(deletedNode!=null){
                return deletedNode;
            }
        }
        return null;

    }

    void deleteNode(NaryTree node,Integer data){
        if(root.data==data){
            System.out.println("Enter the element from below list which should replace in the deleted area");
       
        for (int j=0;j<root.ar.size();j++) {
            System.out.println(j+". "+root.ar.get(j).data);
        }
        System.out.println("Enter the index of the element");
        Scanner s=new Scanner(System.in);
        Integer ind=s.nextInt();
        ArrayList<NaryTree> siblingAndChildren=new ArrayList<>();
        siblingAndChildren.addAll(root.ar);
        for (NaryTree n : root.ar) {
            n.prev=root.ar.get(ind);
            
        }
        siblingAndChildren.remove(root.ar.get(ind));
        siblingAndChildren.addAll(root.ar.get(ind).ar);
        
        root.ar.get(ind).ar.clear();
        root.ar.get(ind).ar.addAll(siblingAndChildren);
        root=root.ar.get(ind);
        root.prev=null;
        return;
        }
        NaryTree deletedNode=find(node, data);
        if(deletedNode==null){
            System.out.println("Element not found");
            return;
        }
        if(deletedNode.ar.size()<=0){
            deletedNode.prev.ar.remove(deletedNode);
            return;
        }
        
        System.out.println("Enter the element from below list which should replace in the deleted area");
       
        for (int j=0;j<deletedNode.ar.size();j++) {
            System.out.println(j+". "+deletedNode.ar.get(j).data);
        }
        System.out.println("Enter the index of the element");
        Scanner s=new Scanner(System.in);
        Integer ind=s.nextInt();
        if(ind>=deletedNode.ar.size()){
            System.out.println("Index not in range");
            return;
        }
        Integer delInd=deletedNode.prev.ar.indexOf(deletedNode);
        ArrayList<NaryTree> siblingAndChildren=new ArrayList<>();
        siblingAndChildren.addAll(deletedNode.ar);
        for (NaryTree n : deletedNode.ar) {
            n.prev=deletedNode.ar.get(ind);
            
        }
        siblingAndChildren.remove(deletedNode.ar.get(ind));
        siblingAndChildren.addAll(deletedNode.ar.get(ind).ar);
        deletedNode.prev.ar.remove(deletedNode);
        deletedNode.prev.ar.add(delInd, deletedNode.ar.get(ind));
        deletedNode.ar.get(ind).ar.clear();
        deletedNode.ar.get(ind).ar.addAll(siblingAndChildren);
        deletedNode.ar.get(ind).prev=deletedNode.prev;


        return;
    }



    void insertAfter(Integer parentVal,Integer childVal){
        NaryTree node =find(root,parentVal);
        node.ar.add(new NaryTree(childVal,node));
    }

    ArrayList<Integer> levelorder(NaryTree node,ArrayList<Integer> arr,Queue<NaryTree> que)
    {
        if(que.size()<=0)
            return arr;
        NaryTree n=que.poll();
        arr.add(n.data);
        if(node.ar!=null){
            que.addAll(node.ar);
        }
        levelorder(que.peek(), arr, que);
        return arr;
    }

    void heightOFtree(NaryTree node,Integer curHeight) {
        if(node==null){
            return;
        }
        for (NaryTree n : node.ar) {
            heightOFtree(n, curHeight+1);
            if(curHeight+1>height)
            height=curHeight+1;
        }
        

    }
}

public class NaryTreeTraversal {

    void insert(NaryTree node){
        Integer val;
        Integer choise;
        Scanner sc=new Scanner(System.in);
        ArrayList<NaryTree> arr=new ArrayList<>();
        System.out.println("Enter the enter the size of array of the node "+node.data);
            Integer siz=sc.nextInt();
            for(int i=0;i<siz;i++){
                System.out.println("Enter the value");
                val=sc.nextInt();
                arr.add(new NaryTree(val,node));
                
            }
            node.ar.addAll(arr);
            for (NaryTree n : arr) {
                System.out.println("Would you like to add child for value "+n.data+" 1.yes 2.no");
                choise=sc.nextInt();
                if(choise==1){
                    insert(n);
                }
                
            }
            arr.clear();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the root node value");
        Integer r=sc.nextInt();
        NaryTree node=new NaryTree(r);
        node.root=node;
        NaryTreeTraversal in=new NaryTreeTraversal();
        in.insert(node);
Integer flag=1;
    while(flag==1){
        Queue<NaryTree> que=new LinkedList<NaryTree>();
        que.add(node.root);
        System.out.println("Enter the number of the below option to do list operation");

            System.out.println("1. PREORDER");
            System.out.println("2. POSTORDER");
            System.out.println("3. LEVELORDER");
            System.out.println("4. REMOVE A ELEMENT");

            System.out.println("5. HEIGHT OF TREE");

            System.out.println("6. INSERT AFTER");
            System.out.println("7. EXIT");
            Integer opt=sc.nextInt();
            switch(opt){
                case 1:arr=node.preorder(node.root,new ArrayList<Integer>());
                        System.out.print("preorder: ");
                        for(int i=0;i<arr.size();i++)
                            System.out.print(arr.get(i) +" ");
                        System.out.println();
                        break;
                case 2:arr=node.postorder(node.root,new ArrayList<Integer>());
                        System.out.print("postorder: ");
                        for(int i=0;i<arr.size();i++)
                            System.out.print(arr.get(i) +" ");
                        System.out.println();
                        break;
                case 3: arr=node.levelorder(node.root, new ArrayList<Integer>(), que);
                        System.out.print("levelorder: ");
                    for(int i=0;i<arr.size();i++)
                        System.out.print(arr.get(i) +" ");
                    System.out.println();
                        break;
                case 4:System.out.println("Enter the value to be deleted");
                        node.deleteNode(node,sc.nextInt());
                        break;
                case 5:node.heightOFtree(node, 1);
                        System.out.println("height of tree is "+NaryTree.height);
                        break;
                
                case 6:System.out.println("Enter parent value");
                        Integer parentVal=sc.nextInt();
                        System.out.println("Enter value to be inserted");
                        node.insertAfter(parentVal, sc.nextInt());
                        break;
                case 7:flag=0;
                        break;
    }
    
    }
}
    
}
