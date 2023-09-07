package day_5;

// abstract class Calci{
//     abstract void add(Integer a,Integer b);
//     abstract void sub(Integer a,Integer b) throws Exception;
// }

// class Calculator extends Calci{
//     void add(Integer a,Integer b){
//         System.out.println(a+b);
//     }
//     void sub(Integer a,Integer b) throws Exception{
//         System.out.println(a+b);
//     }
// }

interface Calci{
     void add(Integer a,Integer b);
    void sub(Integer a,Integer b) throws Exception;
}

class Calculator implements Calci{
    public void add(Integer a,Integer b){
        System.out.println(a+b);
    }
    public void sub(Integer a,Integer b) throws Exception{
        System.out.println(a+b);
    }
}


public class abs {
    
}
