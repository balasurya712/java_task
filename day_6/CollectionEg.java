package day_6;

import java.util.*;

public class CollectionEg {


    void hashSetEg(){
        System.out.println("Linked HashSet example");
        HashSet<Integer> set=new HashSet();  
               set.add(10);
               set.add(11);
               set.add(12);
               Integer temp=0;
               while(set.add(temp)){
                temp+=1;
               }
               Iterator<Integer> i=set.iterator(); 
               
               while(i.hasNext())  
               {  
               System.out.print(i.next()+" ");  
               } 
                
               System.out.println();
               if(set.contains(10)){
                System.out.println("set contain 10");
               }
               while(set.remove(temp)){
                temp+=1;
               }  
                i=set.iterator();  
               while(i.hasNext())  
               {  
               System.out.print(i.next()+" ");  
               }  
                
               System.out.println();
               
               HashSet<Integer> set1=new HashSet();
               set1=(HashSet<Integer>) set.clone();
               if(set1.isEmpty()==false){
                System.out.println("set1 is not empty");
                System.out.println("so the size of set1 is "+set1.size());
               }
                i=set1.iterator();
               while(i.hasNext())  
               {  
               System.out.print(i.next()+" ");  
               }


               System.out.println();


            if(set.equals(set1)){
                System.out.println(set.hashCode());
                System.out.println(set1.hashCode());
                System.out.println("both the set is equal");

            }
            System.out.println();
    }

    void linkedHashSetEg(){
        System.out.println("Linked HashSet example");
        LinkedHashSet<Integer> set=new LinkedHashSet();  
               set.add(10);
               set.add(11);
               set.add(12);
               Integer temp=0;
               while(set.add(temp)){
                temp+=1;
               }
               Iterator<Integer> i=set.iterator(); 
               
               while(i.hasNext())  
               {  
               System.out.print(i.next()+" ");  
               } 
                
               System.out.println();
               if(set.contains(10)){
                System.out.println("set contain 10");
               }
               while(set.remove(temp)){
                temp+=1;
               }  
                i=set.iterator();  
               while(i.hasNext())  
               {  
               System.out.print(i.next()+" ");  
               }  
                
               System.out.println();
               
               LinkedHashSet<Integer> set1=new LinkedHashSet();
               set1=(LinkedHashSet<Integer>) set.clone();
               if(set1.isEmpty()==false){
                System.out.println("set1 is not empty");
                System.out.println("so the size of set1 is "+set1.size());
               }
                Iterator<Integer> j=set1.iterator();
               while(j.hasNext())  
               {  
               System.out.print(j.next()+" ");  
               }

               System.out.println();

            if(set.equals(set1)){
                System.out.println(set.hashCode());
                System.out.println(set1.hashCode());
                System.out.println("both the set is equal");

            }
            System.out.println("is set1 contain all element in set?"+set.containsAll(set1));
            
            set1.remove(5);
            System.out.println("set: "+set);
            System.out.println("set1:"+set1);
            System.out.println("After retain all function");
            set.retainAll(set1);
            System.out.println("set:"+set);
            System.out.println("set1:"+set1);

    }
    public static void main(String[] args) {
        CollectionEg cg=new CollectionEg();
        
        List<Integer> al=new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
       System.out.println( al.remove(al.indexOf(1)));
        
        // cg.hashSetEg();
        cg.linkedHashSetEg();
        
    }
}
