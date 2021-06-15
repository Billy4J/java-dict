package create.builderPattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0F;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void show() {
        for (Item item : items) {
            System.out.println(item.name());
            System.out.println(item.packaging().pack());
        }
    }

}
