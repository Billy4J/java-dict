package struct.decoratorPattern;

public class DecoratorPatternMain {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redSquare = new RedShapeDecorator(new Square());

        circle.draw();
        redCircle.draw();
        redSquare.draw();
    }
}
