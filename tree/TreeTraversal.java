import java.util.ArrayList;

class Tree
{
    int data;
    Tree left;
    Tree right;
    Tree(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }

    ArrayList<Integer> preorder(Tree root,ArrayList<Integer> arr)
    {
        if(root==null)
        return arr;
        arr.add(root.data);
        preorder(root.left,arr);
        preorder(root.right,arr);
        return arr;
    }

    ArrayList<Integer> inorder(Tree root,ArrayList<Integer> arr)
    {
        if(root==null)
        return arr;
        
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
        return arr;
    }

    ArrayList<Integer> postorder(Tree root,ArrayList<Integer> arr)
    {
        if(root==null)
        return arr;
        
        postorder(root.left,arr);
        postorder(root.right,arr);
        arr.add(root.data);
        return arr;
    }
}
public class TreeTraversal {
public static void main(String args[])
{
    ArrayList<Integer>arr=new ArrayList<>();
    Tree t1=new Tree(1);
    Tree t2=new Tree(2);
    Tree t3=new Tree(3);
    t1.left=t2;
    t1.right=t3;
    Tree t4=new Tree(4);
    Tree t5=new Tree(5);
    Tree t6=new Tree(6);
    Tree t7=new Tree(7);
    t2.left=t4;
    t2.right=t5;
    t3.left=t6;
    t3.right=t7;
    arr=t1.preorder(t1,new ArrayList<Integer>());
    System.out.print("preorder: ");
    for(int i=0;i<arr.size();i++)
        System.out.print(arr.get(i) +" ");
    System.out.println();

    arr=t1.inorder(t1,new ArrayList<Integer>());
    System.out.print("inorder: ");
    for(int i=0;i<arr.size();i++)
        System.out.print(arr.get(i) +" ");
    System.out.println();

    arr=t1.postorder(t1,new ArrayList<Integer>());
    System.out.print("postorder: ");
    for(int i=0;i<arr.size();i++)
        System.out.print(arr.get(i) +" ");
    System.out.println();
}

}