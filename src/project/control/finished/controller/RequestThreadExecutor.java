package project.control.finished.controller;

public class RequestThreadExecutor implements Runnable {

    private String request;
    private Controller controller = Controller.getInstance();

    public RequestThreadExecutor(String request) {
        this.request = request;
    }

    @Override
    public void run() {

        String response = controller.doAction(request);

        System.out.println(response);

    }

}
