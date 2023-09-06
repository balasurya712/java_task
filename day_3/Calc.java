package day_3;


interface Calculator{
    Float add(Float a,Float b);
    Float sub(Float a,Float b);
    Float mul(Float a,Float b);
    Float div(Float a,Float b);

    Float add(Float a,Integer b);
    Float sub(Float a,Integer b);
    Float mul(Float a,Integer b);
    Float div(Float a,Integer b);

    Float add(Integer a,Float b);
    Float sub(Integer a,Float b);
    Float mul(Integer a,Float b);
    Float div(Integer a,Float b);

    Integer add(Integer a,Integer b);
    Integer sub(Integer a,Integer b);
    Integer mul(Integer a,Integer b);
    Integer div(Integer a,Integer b);

    Double add(Integer a,Double b);
    Double sub(Integer a,Double b);
    Double mul(Integer a,Double b);
    Double div(Integer a,Double b);

    Double add(Double a,Integer b);
    Double sub(Double a,Integer b);
    Double mul(Double a,Integer b);
    Double div(Double a,Integer b);

    Double add(Float a,Double b);
    Double sub(Float a,Double b);
    Double mul(Float a,Double b);
    Double div(Float a,Double b);

    Double add(Double a,Float b);
    Double sub(Double a,Float b);
    Double mul(Double a,Float b);
    Double div(Double a,Float b);

    Double add(Double a,Double b);
    Double sub(Double a,Double b);
    Double mul(Double a,Double b);
    Double div(Double a,Double b);
}

class Calce implements Calculator{
    public Float add(Float a,Float b){
        return a+b;
    }
    public Float sub(Float a,Float b){
        return a-b;
    }
    public Float mul(Float a,Float b){
        return a*b;
    }
    public Float div(Float a,Float b){
        return a/b;
    }

    public Float add(Float a,Integer b){
        return a+b;
    }
    public Float sub(Float a,Integer b){
        return a-b;
    }
    public Float mul(Float a,Integer b){
        return a*b;
    }
    public Float div(Float a,Integer b){
        return a/b;
    }

    public Float add(Integer a,Float b){
        return a+b;
    }
    public Float sub(Integer a,Float b){
        return a-b;
    }
    public Float mul(Integer a,Float b){
        return a*b;
    }
    public Float div(Integer a,Float b){
        return a/b;
    }

    public Integer add(Integer a,Integer b){
        return a+b;
    }
    public Integer sub(Integer a,Integer b){
        return a-b;
    }
    public Integer mul(Integer a,Integer b){
        return a*b;
    }
    public Integer div(Integer a,Integer b){
        return a/b;
    }

    public Double add(Integer a,Double b){
        return a+b;
    }
    public Double sub(Integer a,Double b){
        return a-b;
    }
    public Double mul(Integer a,Double b){
        return a*b;
    }
    public Double div(Integer a,Double b){
        return a/b;
    }

    public Double add(Double a,Integer b){
        return a+b;
    }
    public Double sub(Double a,Integer b){
        return a-b;
    }
    public Double mul(Double a,Integer b){
        return a*b;
    }
    public Double div(Double a,Integer b){
        return a/b;
    }

     public Double add(Float a,Double b){
        return a+b;
    }
    public Double sub(Float a,Double b){
        return a-b;
    }
    public Double mul(Float a,Double b){
        return a*b;
    }
    public Double div(Float a,Double b){
        return a/b;
    }

    public Double add(Double a,Float b){
        return a+b;
    }
    public Double sub(Double a,Float b){
        return a-b;
    }
    public Double mul(Double a,Float b){
        return a*b;
    }
    public Double div(Double a,Float b){
        return a/b;
    }

    public Double add(Double a,Double b){
        return a+b;
    }
    public Double sub(Double a,Double b){
        return a-b;
    }
    public Double mul(Double a,Double b){
        return a*b;
    }
    public Double div(Double a,Double b){
        return a/b;
    }
}

public class Calc {
    public static void main(String[] args) {
        Calce c=new Calce();

        System.out.println(c.add(5, 5));
        System.out.println(c.sub(5.0, 6.0));
        System.out.println(c.mul(5, 5.757));
        System.out.println(c.div(40, 5.00000));
        
    }
}