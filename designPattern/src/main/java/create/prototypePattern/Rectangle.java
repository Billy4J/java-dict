package create.prototypePattern;

public class Rectangle extends Shape {
    Rectangle() {
        this.type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
