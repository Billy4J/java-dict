package create.builderPattern;

public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VergeBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNoneVeg() {
        Meal meal = new Meal();
        meal.addItem(new noneVergeBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
