package struct.decoratorPattern;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratedShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
