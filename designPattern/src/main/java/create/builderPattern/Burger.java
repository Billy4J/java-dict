package create.builderPattern;

public abstract class Burger implements Item {
    @Override
    public Packaging packaging() {
        return new Wrapper();
    }
}
