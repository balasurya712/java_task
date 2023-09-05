public class Circle extends Shape {

    Circle(float r){
        super(r);
    }

    Circle(Circle shp){
        super(shp);
    }
    
    // void draw(){
    //     System.out.println("Area of Circle is "+(r*r*pi));
    // }

     public static void main(String arge []){
        Shape c=new Shape(5.0f);
        Shape c1=new Shape(c);
        // System.out.println(c1.r);
        // c1.draw();
        // c.draw();
    }
}
