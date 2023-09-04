import java.util.Scanner;

public class Fibonacci {
        static void printLoop(int n) {
            int a=0;
            int b=1;
            int sum=a+b;
            System.out.print(a+" ");
            if(n<2){
                return ;
            }
            System.out.print(b+" ");
            for(int ctr=1;ctr<=n-2;ctr++){
                System.out.print(sum+" ");
                a=b;
                b=sum;
                sum=a+b;
            }
            System.out.println();
    }

    // recursion method
    static void printRecursion(int a,int b,int n) {
        if(n==0){
            return ;
        }
        System.out.print((a+b)+" ");
        printRecursion(b, a+b, n-1);

    }
    public static void main(String args []){
    Scanner sc=new Scanner(System.in);  
    System.out.print("Enter a number ");  
    int n= sc.nextInt();
    
    printLoop(n);
    System.out.println("Using Recursion");
    System.out.print(0+" ");
    if(n<2){
        System.exit(0);
    }
    System.out.print(1+" ");
    printRecursion(0,1,n-2);
    }


}
