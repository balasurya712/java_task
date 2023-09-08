package blackJack;

import java.util.Scanner;

public class BotGame{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Play pl=new Play();
        Integer flag=pl.result();
        Integer option;
        System.out.println("Welcome to Black Jack game");
        while(flag==1){
            System.out.println("Player your current sum is "+pl.p1_sum);
            System.out.println("Delar your current sum is "+pl.p2_sum);
            System.out.println("Player would you like to 1.stay or 2.hit (enter 1 or 2)");
            option=sc.nextInt();
            if(option==2){
                pl.hit(pl.pc);
                flag=pl.result();
            }
            pl.pc=pl.pc^1;
            flag= pl.delar(pl.pc);
            if(flag==0){
                break;
            }
            pl.pc=pl.pc^1;
        }
        sc.close();
    
    }

   
}