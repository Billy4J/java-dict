package create.builderPattern;

public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "coke";
    }

    @Override
    public float price() {
        return 2.5F;
    }
}
