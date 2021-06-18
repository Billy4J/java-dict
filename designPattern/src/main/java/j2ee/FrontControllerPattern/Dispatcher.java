package j2ee.FrontControllerPattern;

public class Dispatcher {
    private HomeView homeView;
    private StudentView studentView;

    public Dispatcher() {
        homeView = new HomeView();
        studentView = new StudentView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("home")) {
            homeView.show();
        } else {
            studentView.show();
        }
    }

}
