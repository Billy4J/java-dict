package create.abstractFactoryPattern;

public class ShapeFactory extends AbstractFactory {

    @Override
    ShapeStyle getShapeStyle(String name) {
        switch (name.toLowerCase()) {
            case "circle":
                return new CircleImp();
            case "square":
                return new SquareImp();
            default:
                return null;
        }
    }

    @Override
    Color getColor(String name) {
        return null;
    }
}
