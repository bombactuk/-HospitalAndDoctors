package project.control.finished.start;

import project.control.finished.controller.Controller;
import project.control.finished.controller.StartController;

public class Main {

    public static void main(String[] args) {

        StartController server = new StartController();

        String request;
        StringBuilder response = new StringBuilder();

        //request = "ADD\nhospital\nname=Центральная поликлинника\naddress=ул. Проспект победы 156\n" +
        //  server.doAction(request);

        // request = "ADD\ndoctor\nidhospital=1\nfio=Алексеенко Екатерина Андреевна\n" +
        //         "jobTitle=Психотерапетв";
        //server.doAction(request);

        //request = "FIND\ncity=Гомель";
        //server.doAction(request);;

        // request = "FINDHOSPITAL\ndoctor=1";
        // server.doAction(request);

        //request = "FINDDOCTOR\nhospital=1";
        //server.doAction(request);

        //request = "UPDATE\nhospital\nidhospital=1\nname=Советская поликлинника\naddress=ул. Косарева 151\n" +
        //        "city=Гомель";
        // server.doAction(request);

        //request = "UPDATE\ndoctor\niddoctor=1\nidhospital=1\nfio=Левшунов Егор Юрьевич\njobTitle=Зам. Хирурга";
        //server.doAction(request);

        // request = "DELETE\nhospital\nidhospital=8";
        // server.doAction(request);

        //request = "DELETE\ndoctor\niddoctor=4";
        //server.doAction(request);

    }

}
