package create.abstractFactoryPattern;

public class FactoryProducer {
    public static AbstractFactory getFactory(String name) {
        switch (name.toLowerCase()) {
            case "shape":
                return new ShapeFactory();
            case "color":
                return new ColorFactory();
            default:
                return null;
        }
    }
}
