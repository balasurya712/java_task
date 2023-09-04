import java.util.*;


//loop code start
class Loop{
 void printStarPattern(int n){
    for(int ctr=1;ctr<=n;ctr++){
        for(int i=1;i<=ctr;i++){
            System.out.print("*");
        }
        for(int j=0;j<(2*n)-(ctr*2);j++){
             System.out.print(" ");
        }
        for(int i=1;i<=ctr;i++){
            System.out.print("*");
        }
    
    System.out.println("");
    }
}

 void printMinus(int n){
     
       for(int ctr=0;ctr<n;ctr++){
        for(int i=n;i>ctr;i--){
            System.out.print("-");
        }
        for(int j=(2*n);j>(2*n)-(ctr*2);j--){
             System.out.print(" ");
        }
        for(int i=n;i>ctr;i--){
            System.out.print("-");
        }
    
    System.out.println("");
    }
    
}
 void run(int n) {

      

    printStarPattern(n);
    printMinus(n);
}
}
//loop code end

// recursion code start

class Recursion {
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
void run(int n) {
     

    printStarPattern(n,1);
    printMinusPattern(n,0);
   

}
}

//Recrsion code end

class Pattern {
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);  
    System.out.print("Enter a number ");  
    int n= sc.nextInt();
    sc.nextLine();
    Loop pl= new Loop();
    pl.run(n);
    System.out.println("recursion output");
    Recursion pr= new Recursion();
    pr.run(n);
    sc.close();
    }
}