package pk1;

import java.util.*;
interface Cards{
    HashMap <Integer,Integer> ar = new HashMap<Integer,Integer>()
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

}

class Play implements Cards{
    Integer p1_sum=random()+random();
    Integer p2_sum=random();
    Integer pc=1;

    Integer random(){
        Integer ran=(int)Math.floor(Math.random() * (11 - 2 + 1) + 2);
        if(ar.get(ran)==0){
            return random();

        }
        ar.replace(ran, ar.get(ran), ar.get(ran)-1);
            return ran;
    }

    void hit(int pc){
        if(pc==1){
            p1_sum+=random();
        }else{
            p2_sum+=random();
        }
    }

    Integer result(){
        if(p1_sum>21){
            System.out.println("Player sum is "+p1_sum+" which execeeds the given number");
            System.out.println("So, congrats Delar wins");
            return 0;
        }else if(p2_sum>16){
            System.out.println("Delar sum is "+p2_sum+" which execeeds the given number");
            System.out.println("So, congrats Player wins");
            return 0;
        }
        else{
            return 1;
        }
        
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Play pl=new Play();
        Integer flag=pl.result();
        String playerChance="Player";
        Integer option;
        System.out.println("Welcome to Black Jack game");
        while(flag==1){
            System.out.println("Player your current sum is "+pl.p1_sum);
            System.out.println("Delar your current sum is "+pl.p2_sum);
            if(pl.pc==0){
                playerChance="Delar";
            }
            else{
                playerChance="Player";
            }
            System.out.println(playerChance+" would you like to 1.stay or 2.hit (enter 1 or 2)");
            option=sc.nextInt();
            if(option==2){
                pl.hit(pl.pc);
                flag=pl.result();
            }
            pl.pc=pl.pc^1;
        }
        sc.close();
    }
    
}
