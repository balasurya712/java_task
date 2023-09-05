package day_3;

class Shape{
float r,l,b;
float pi=3.14f;

Shape(float r){
    this.r=r;
}

Shape(float l,float b){
    this.l=l;
    this.b=b;
}

void area(){
    System.out.println("area is "+(l*b));
}

}

class Rectangle extends Shape{

Rectangle(float l,float b){
    super(l,b);
}

void area(){
    super.area();
}

}

class Circle extends Shape{

Circle(float r){
    super(r);
}

void area(){
    System.out.println("area is "+(r*r*pi));
}

}

public class Inheritance {
    
    public static void main(String args []){
        Circle c=new Circle(10);
        Rectangle r= new Rectangle(5, 3);
        c.area();
        r.area();
    }
}
