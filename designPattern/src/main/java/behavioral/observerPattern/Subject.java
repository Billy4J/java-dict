package behavioral.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private int state;
    private List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifiedAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifiedAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
