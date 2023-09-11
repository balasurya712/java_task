package day_6;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetEG {
    public static void main(String[] args) {
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
               System.out.println(i.next()+" ");  
               }

            if(set.equals(set1)){
                System.out.println(set.hashCode());
                System.out.println(set1.hashCode());
                System.out.println("both the set is equal");

            }
    }
}
