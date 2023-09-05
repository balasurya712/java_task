public class Shape {
    float pi=3.14f;
    float r;
    Shape(){
        System.out.println("Shape is created");
    }

    Shape(float r){
        this();
        this.r=r;
    }

    Shape(Shape shp){
        this.r=shp.r;
    }

}
