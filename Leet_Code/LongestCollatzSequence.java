package Leet_Code;

import java.util.*;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

class Solve{
    static Map<Long,Long> hp=new HashMap<>();
    long chainCount(long num,long count){
        if(num==1)
        return 1;
        long temp=num;
        
        while(temp!=1 && !hp.containsKey(temp)){
        if(temp%2==0)
        temp=temp/2;
        else
        temp=(3*temp)+1;
        count++;
        }

        if(hp.containsKey(temp)){
        long a=hp.get(temp);
        count+=a;
        }

        hp.put(num,count);
        return (count);
        
    }
}

public class LongestCollatzSequence {
    
    public static void main(String[] args) {
        System.out.println(java.time.LocalTime.now()); 
        Solve s=new Solve();
        s.hp.put(1l, 1l);
        long max=0;
        System.out.println();
        for(long i=2;i<1000000;i++){
            long temp=s.chainCount(i, 0);
            if(temp>max){
                max=temp;
            }
        }
        System.out.println(max);
        // System.out.println(s.hp);
        // System.out.println(s.chainCount(837799, 1));
        System.out.println(java.time.LocalTime.now()); 
    }
}
