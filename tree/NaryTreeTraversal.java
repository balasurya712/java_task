import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NaryTree
{
    Integer data;
    static Integer height=0;
    ArrayList<NaryTree> ar=new ArrayList<>();
    NaryTree(int data)
    {
        this.data=data;
    }

    NaryTree(int data, ArrayList<NaryTree> ar)
    {
        this.data=data;
        this.ar=ar;
    }

    NaryTree addNode(int data){
        NaryTree n=new NaryTree(data);
        return n;
    }

    NaryTree addNode(int data,ArrayList<NaryTree> ar){
        NaryTree n=new NaryTree(data,ar);
        return n;
    }

    ArrayList<Integer> preorder(NaryTree root,ArrayList<Integer> arr)
    {
        if(root==null)
        return arr;
        arr.add(root.data);
        for (NaryTree node : root.ar) {
            postorder(node, arr);
        } 
        return arr;
    }

    
    ArrayList<Integer> postorder(NaryTree root,ArrayList<Integer> arr)
    {
        if(root==null)
        return arr;
        for (NaryTree node : root.ar) {
            postorder(node, arr);
        } 
        arr.add(root.data);
        return arr;
    }

    ArrayList<Integer> levelorder(NaryTree root,ArrayList<Integer> arr,Queue<NaryTree> que)
    {
        if(que.size()<=0)
            return arr;
        NaryTree n=que.poll();
        arr.add(n.data);
        if(root.ar!=null){
            que.addAll(root.ar);
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
                arr.add(new NaryTree(val));
                
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
        NaryTree root=new NaryTree(r);
        NaryTreeTraversal in=new NaryTreeTraversal();
        in.insert(root);
        Queue<NaryTree> que=new LinkedList<NaryTree>();
        que.add(root);

        arr=root.preorder(root,new ArrayList<Integer>());
    System.out.print("preorder: ");
    for(int i=0;i<arr.size();i++)
        System.out.print(arr.get(i) +" ");
    System.out.println();


    arr=root.postorder(root,new ArrayList<Integer>());
    System.out.print("postorder: ");
    for(int i=0;i<arr.size();i++)
        System.out.print(arr.get(i) +" ");
    System.out.println();


        arr=root.levelorder(root, new ArrayList<Integer>(), que);
        System.out.print("levelorder: ");
    for(int i=0;i<arr.size();i++)
        System.out.print(arr.get(i) +" ");
    System.out.println();
    sc.close();
    root.heightOFtree(root, 1);
    System.out.println("height of tree is "+NaryTree.height);
    
    }
    
}
