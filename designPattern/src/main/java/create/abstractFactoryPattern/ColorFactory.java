package create.abstractFactoryPattern;

public class ColorFactory extends AbstractFactory {

    @Override
    ShapeStyle getShapeStyle(String name) {
        return null;
    }

    @Override
    Color getColor(String name) {
        switch (name.toLowerCase()) {
            case "red":
                return new Red();
            case "blue":
                return new Blue();
            default:
                return null;
        }
    }
}
