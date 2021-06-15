package create.abstractFactoryPattern;

public class AbstractFactoryPatternMain {
    /**
     * 定义同类item接口
     * 实现item接口的item类
     * 定义抽象工厂类
     * 继承抽象工厂类的工厂类
     */
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        shapeFactory.getShapeStyle("circle").draw();
        shapeFactory.getShapeStyle("square").draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        colorFactory.getColor("red").fill();
        colorFactory.getColor("blue").fill();
    }
}





















