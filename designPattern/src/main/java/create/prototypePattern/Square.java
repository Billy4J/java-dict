package create.prototypePattern;

public class Square extends Shape {
    Square() {
        this.type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
