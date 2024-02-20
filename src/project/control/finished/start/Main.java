package project.control.finished.start;

import project.control.finished.controller.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        String request;
        StringBuilder response = new StringBuilder();

         //request = "ADD\nhospital\nname=Областная Поликлинника\naddress=ул. Победы 157\n" +
        //          "city=Минск";
         // response.append(controller.doAction(request));
         //  System.out.println(response);

       // request = "ADD\ndoctor\nidhospital=1\nfio=Алексеенко Екатерина Андреевна\n" +
       //         "jobTitle=Психотерапетв";
       // response.append(controller.doAction(request));
       //  System.out.println(response);

        request = "FIND\ncity=Гомель";
        response.append(controller.doAction(request));
        System.out.println(response);

        // request = "FINDHOSPITAL\ndoctor=1";
        //response.append(controller.doAction(request));
       // System.out.println(response);

        //request = "FINDDOCTOR\nhospital=1";
        //response.append(controller.doAction(request));
        //System.out.println(response);

    }

}
