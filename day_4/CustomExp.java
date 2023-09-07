package day_4;

import java.util.Scanner;

class Excep extends Exception{
    Excep(String msg){
        super(msg);
        System.out.println("Custome Exception");
    }

}

public class CustomExp {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer age=sc.nextInt();
     sc.close();
    try {
        if(age<18){
        throw new Excep("You are not eligible for vote");
    }
    System.out.println("You can vote");
    } catch (Excep e) {
        System.out.println(e);
    }
   
    
}
    
    
}
