package create.prototypePattern;

public class Circle extends Shape {
    Circle() {
        this.type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
