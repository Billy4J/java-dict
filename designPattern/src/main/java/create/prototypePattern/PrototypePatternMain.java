package create.prototypePattern;


public class PrototypePatternMain {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape shapeClone = (Shape) ShapeCache.getShape("square");
        shapeClone.draw();
    }
}










