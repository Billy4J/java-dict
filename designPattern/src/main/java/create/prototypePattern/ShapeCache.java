package create.prototypePattern;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeName) {
        Shape shape = shapeMap.get(shapeName);
        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Circle circleP = new Circle();
        shapeMap.put("circle", circleP);

        Square squareP = new Square();
        shapeMap.put("square", squareP);

        Rectangle rectangleP = new Rectangle();
        shapeMap.put("rectangle", rectangleP);
    }

}
