package behavioral.mediatorPattern;

public class MediatorPatternMain {
    public static void main(String[] args) {
        User john = new User("john");
        User billy = new User("billy");

        john.sendMessage("hello");
        billy.sendMessage("word");

    }
}
