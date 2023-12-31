
import java.util.Scanner;

public class PatternRecursion {
     void printStar(int ctr){
        if(ctr<=0){
            return ;
        }
         System.out.print("*");
         printStar(ctr-1);   
    }

     void printStarSpace(int ctr){
        if(ctr<=0){
            return ;
        }
         System.out.print(" ");
         printStarSpace(ctr-1);   
    }

     void printStarPattern(int n,int ctr){
    if(n<ctr){
        return ;
    }
    printStar(ctr);
    printStarSpace((2*n)-(ctr*2));
    printStar(ctr);
    System.out.println("");
    printStarPattern(n,ctr+1);
    
}

void printMinus(int n){
if(n<=0){
    return ;
}
System.out.print("-");
printMinus(n-1);
}

void printMinusSpace(int ctr){
        if(ctr<=0){
            return ;
        }
         System.out.print(" ");
         printStarSpace(ctr-1);   
    }

void printMinusPattern(int n,int ctr){
     
    if(n<=ctr){
        return ;
    }
        printMinus(n-ctr);
        printMinusSpace(ctr*2);
        printMinus(n-ctr);
    
    System.out.println("");
    printMinusPattern(n, ctr+1);
    
    
}
public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);  
    System.out.print("Enter a number ");  
    int n= sc.nextInt();
PatternRecursion obj=new PatternRecursion();
    obj.printStarPattern(n,1);
    obj.printMinusPattern(n,0);
    sc.close();

}
}
