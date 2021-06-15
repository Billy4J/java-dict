package create.abstractFactoryPattern;

public abstract class AbstractFactory {
    abstract ShapeStyle getShapeStyle(String name);

    abstract Color getColor(String name);

}
