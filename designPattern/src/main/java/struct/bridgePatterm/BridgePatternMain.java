package struct.bridgePatterm;

public class BridgePatternMain {
    public static void main(String[] args) {
        Circle blueCircle = new Circle(10, 2, 3, new BlueCircle());
        Circle redCircle = new Circle(10, 2, 3, new RedCircle());
        blueCircle.draw();
        redCircle.draw();
    }
}
