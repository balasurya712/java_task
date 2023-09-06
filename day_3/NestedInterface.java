package day_3;

import java.util.Scanner;

// interface Calci{
//     interface Arithmetic{
//     Double add(Double a,Double b);
//     Double sub(Double a,Double b);
//     Double mul(Double a,Double b);
//     Double div(Double a,Double b);
//     }

   
// }

// class ArithmeticCalculator implements Calci.Arithmetic{

//     public Double add(Double a,Double b){
//         return a+b;
//     }
//     public Double sub(Double a,Double b){
//         return a-b;
//     }
//     public Double mul(Double a,Double b){
//         return a*b;
//     }
//     public Double div(Double a,Double b){
//         return a/b;
//     }
// }

// class Calci{
//     interface Arithmetic{
//     Double add(Double a,Double b);
//     Double sub(Double a,Double b);
//     Double mul(Double a,Double b);
//     Double div(Double a,Double b);
//     }

   
// }

// class ArithmeticCalculator implements Calci.Arithmetic{

//     public Double add(Double a,Double b){
//         return a+b;
//     }
//     public Double sub(Double a,Double b){
//         return a-b;
//     }
//     public Double mul(Double a,Double b){
//         return a*b;
//     }
//     public Double div(Double a,Double b){
//         return a/b;
//     }
// }

interface Calci{
    Double add(Double a,Double b);
    Double sub(Double a,Double b);
    public class Arithmetic{
    
     Double mul(Double a,Double b){
        return a*b;
    }
     Double div(Double a,Double b){
        return a/b;
    }
    }

   
}

class ArithmeticCalculator extends Calci.Arithmetic implements Calci{

    public Double add(Double a,Double b){
        return a+b;
    }
    public Double sub(Double a,Double b){
        return a-b;
    }
   
}

class NestedInterface{
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       ArithmeticCalculator ac=new ArithmeticCalculator();
       System.out.println("Enter num1");
       Double a=sc.nextDouble();
       System.out.println("Enter num2");
       Double b=sc.nextDouble();
    
        System.out.println(ac.add(a,b));
        System.out.println(ac.sub(a,b));
        System.out.println(ac.mul(a,b));
        System.out.println(ac.div(a,b));
        sc.close();
    }
}