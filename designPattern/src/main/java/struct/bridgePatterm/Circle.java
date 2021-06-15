package struct.bridgePatterm;

public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;

    Circle(int radius, int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.draw(radius, x, y);
    }
}
