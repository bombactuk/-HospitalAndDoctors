package project.control.finished.controller;

public class StartController {

    public void doAction(String reques) {

        RequestThreadExecutor executor = new RequestThreadExecutor(reques);
        new Thread(executor).start();

    }

}
