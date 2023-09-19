package Leet_Code;

import java.util.HashMap;
import java.util.Scanner;

public class LongestRepitingCharacterPL424 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        HashMap<Character,Integer> charFrequency=new HashMap<>();
        String s;
        Integer k;
        Integer maxLength=0;
        Integer left=0;
        Integer repeatcharcount=0;
        Integer nonRepeatcharcount=0;
        System.out.println("Enter the string : ");
        s=sc.nextLine();
        System.out.println("Enter the number of operations : ");
        k=sc.nextInt();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i); 
            charFrequency.put(ch,charFrequency.getOrDefault(ch, 0)+1);
            repeatcharcount=Math.max(repeatcharcount, charFrequency.get(ch));
            nonRepeatcharcount=(i-left+1)-repeatcharcount;
            if(nonRepeatcharcount>k){
                charFrequency.put(s.charAt(left),charFrequency.get(s.charAt(left))-1);
                left++;
            }
            
            maxLength=Math.max(maxLength,i-left+1);
        }
        System.out.println("The longest repeating lenth after replacement is : "+maxLength);
        sc.close();
    }
}


