package blackJack;

import java.util.Scanner;

public class BotGame{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Play pl=new Play();
        Integer flag=1;
        Integer option;
        pl.start();
        System.out.println("Enter the number of deck you would like to play");
        Integer deck=sc.nextInt();
        pl.changeDeck(deck);
        System.out.println("Enter a limit to for the game");
        Integer limit=sc.nextInt();
        pl.setLimit(limit);
        while(flag==1){
            System.out.println("Would you like to 1.stay or 2.hit (enter 1 or 2)");
            option=sc.nextInt();
            if(option==2){
                pl.hit(pl.pc);
                flag=pl.result(pl.p1_sum);
            }else{
                break;
            }
            if(flag==0){
            System.out.println("your total is "+pl.p1_sum+" which execeed the limit");
            System.out.println("so the delar wins");
        }
        }
        pl.pc=pl.pc^1;
        if(flag==1){
            pl.showHidden();
            
        }
        while(flag==1){
            flag=pl.delar(pl.pc);
        }
        
        
        if(flag==2){
            pl.stay();
        }
        sc.close();
    
    }

   
}