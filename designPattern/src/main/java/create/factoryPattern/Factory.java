package create.factoryPattern;

public class Factory {
    public Shape getShape(String name) {
        if (name == null) {
            return null;
        }

        switch (name.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
