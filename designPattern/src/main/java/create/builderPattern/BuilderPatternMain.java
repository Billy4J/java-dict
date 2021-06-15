package create.builderPattern;

public class BuilderPatternMain {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareNoneVeg();
        meal.show();
        System.out.println(meal.getCost());
        meal = mealBuilder.prepareVegMeal();
        meal.show();
        System.out.println(meal.getCost());
    }

}




























