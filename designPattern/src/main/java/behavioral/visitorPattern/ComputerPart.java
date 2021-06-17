package behavioral.visitorPattern;

public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
