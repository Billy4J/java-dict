package j2ee.InterceptingFilterPattern;

public class AuthenticactionFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
