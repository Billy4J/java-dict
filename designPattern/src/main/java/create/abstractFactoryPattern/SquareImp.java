package create.abstractFactoryPattern;

public class SquareImp implements ShapeStyle {
    @Override
    public void draw() {
        System.out.println("square");
    }
}
