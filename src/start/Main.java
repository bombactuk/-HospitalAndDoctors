package start;

import controller.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        String request;
        StringBuilder response = new StringBuilder();

        //  request = "ADD\nhospital\nname=Облостная Поликлинника\naddress=ул. Богданова 25\n" +
        //          "city=Гомель";
        //  response.append(controller.doAction(request));
        //   System.out.println(response);

        //request = "ADD\ndoctor\nidhospital=1\nfio=Петров Игорь Иванович\n" +
        //        "jobTitle=Терапевт";
        //response.append(controller.doAction(request));
        // System.out.println(response);

        //request = "FIND\ncity=Гомель";
        //response.append(controller.doAction(request));
        //System.out.println(response);

        request = "FINDDOCTORS\nid=1";
        response.append(controller.doAction(request));
        System.out.println(response);

    }

}
