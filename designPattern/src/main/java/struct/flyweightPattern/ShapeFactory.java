package struct.flyweightPattern;

import java.util.HashMap;

public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle();
            circleMap.put(color, circle);
            System.out.println("create circle");
        }
        return circle;
    }
}
