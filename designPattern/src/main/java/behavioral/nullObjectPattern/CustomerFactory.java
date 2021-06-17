package behavioral.nullObjectPattern;

public class CustomerFactory {
    private static final String[] names = {"billy", "john", "julie"};

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
