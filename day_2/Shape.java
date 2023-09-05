public class Shape {
    float pi=3.14f;
    private float r;
    Shape(){
        System.out.println("Shape is created");
    }

    Shape(float r){
        this();
        this.r=r;
    }

    Shape(Shape shp){
        this.r=shp.r;
        System.out.println(r);

    }

}
