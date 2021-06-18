package j2ee.ServiceLocatorPattern;

public class Service1 implements Service{
    @Override
    public String getName() {
        return "service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service1");

    }
}
