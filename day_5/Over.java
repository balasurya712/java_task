package day_5;

class Cal{
    Integer add(Integer a,Integer b){
        return a+b;
    }
     Double add(Double a,Double b){
        return a+b;
    }
     Float add(Float a,Float b){
        return a+b;
    }
}

public class Over {

    public static void main(String[] args) {
        Cal c=new Cal();
    System.out.println(c.add(5,5));
    System.out.println(c.add(5f,5f));
    System.out.println(c.add(5.88,5.88));
    }
}
