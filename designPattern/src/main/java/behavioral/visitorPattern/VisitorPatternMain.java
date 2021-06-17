package behavioral.visitorPattern;

public class VisitorPatternMain {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
