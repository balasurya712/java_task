package blackJack;

import java.util.*;
interface Cards{
    HashMap <Integer,Integer> card = new HashMap<Integer,Integer>()
    { {put(2,4);
    put(3,4);
    put(4,4);
    put(5,4);
    put(6,4);
    put(7,4);
    put(8,4);
    put(9,4);
    put(10,4);
    put(11,16);
    }};
    void start();//this method run at the starting of the program
    Integer random();//generate a random number from 2 to 11
    void hit(int pc);//calls when user want to hit the card
    Integer result(Integer sum);//check the sum is less than or greater than given limit
    Integer delar(Integer pc2);//bot which play for delar
    void showHidden();// used to show the hidden card
}

class Play implements Cards{
    Integer p1_sum;//player total value
    Integer p2_sum;//delar total value
    Integer pc=1;//says wich players chance to play
    Integer HiddenCard;//Hidden card value of delar
    Integer limit;// user defined limit to which the total should not cross
    
    public void start(){

        Integer playerCard1=random();//player first card value
        Integer playerCard2=random();//player second card value
        Integer delarCard1=random();//delar first card value
        HiddenCard=random();
        p1_sum=playerCard1+playerCard2;
        p2_sum=delarCard1+HiddenCard;

        System.out.println("Welcome to Black Jack game");
        System.out.println("you get a "+playerCard1+" and "+playerCard2+".");
        System.out.println("Your total is "+p1_sum);
        System.out.println("Delar get a "+delarCard1+" and he has a hidden card");
        System.out.println("His total is hidden, too.");

        
    }


    public void showHidden(){
        System.out.println("Delar hidden card is "+HiddenCard);
        System.out.println("His total is "+p2_sum);
    }//invoked when player choose to stay

    public Integer random(){
        Integer ran=(int)Math.floor(Math.random() * (11 - 2 + 1) + 2);//random value generated from 2 to 11
        if(card.get(ran)==0){
            return random();//if the generated random value card is overed from deck
        }
        card.replace(ran, card.get(ran), card.get(ran)-1);
            return ran;
    }

    public void hit(int pc){
        Integer tempRandom=random();
        
        if(pc==1){
            System.out.println("you drew "+tempRandom);
            p1_sum+=tempRandom;
            System.out.println("your total is "+p1_sum);
        }else{
            System.out.println("Delar drew "+tempRandom);
            p2_sum+=tempRandom;
            System.out.println("Delar total is "+p2_sum);
        }

    }

    public Integer result(Integer sum){
        if(sum>limit){
            return 0;
        } 
        else{
            return 1;
        }
        
    }

    public Integer delar(Integer pc2) {
        Integer ran1=(int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
        Integer fl=2;
        if(ran1==2){
                System.out.println("Delar choose to hit");
                hit(pc);
                fl = result(p2_sum);
            }
        else{
            System.out.println("Delar choose to stay");
            return 2;
        }
        return fl;
    }

    public void stay() {
        System.out.println("Your total is "+p1_sum);
        System.out.println("Delar total is "+p2_sum);
        if(p1_sum>p2_sum){
            System.out.println("You won the game");
        }
        else if(p1_sum<p2_sum){
            System.out.println("Delar won the game");
        }
        else{
            System.out.println("the game is tie");
        }
    }


    public void setLimit(Integer limit) {
        this.limit=limit;
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Play pl=new Play();
        Integer flag=1;
        Integer option;
        pl.start();
        
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
            System.out.println("Delar Would you like to 1.stay or 2.hit (enter 1 or 2)");
            option=sc.nextInt();
            if(option==2){
                pl.hit(pl.pc);
                flag=pl.result(pl.p2_sum);
            }else{
                break;
            }
            if(flag==0){
            System.out.println("Delar total is "+pl.p2_sum+" which execeed the limit");
            System.out.println("So you win the game");
        }
        }
        
        if(flag==1){
            pl.stay();
        }
        sc.close();
    }
    
}
