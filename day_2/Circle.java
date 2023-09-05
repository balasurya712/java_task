public class Circle extends Shape {

    Circle(float r){
        super(r);
    }

    Circle(Circle shp){
        super(shp);
    }
    
    void draw(){
        System.out.println("Area of Circle is "+(r*r*pi));
    }

     public static void main(String arge []){
        Circle c=new Circle(5.0f);
        Circle c1=new Circle(c);
        System.out.println(c1.r);
        c1.draw();
        c.draw();
    }
}
