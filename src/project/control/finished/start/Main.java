package project.control.finished.start;

import project.control.finished.controller.StartController;

public class Main {

    public static void main(String[] args) {

        StartController server = new StartController();
        String request;

        //request = "ADDHOSPITAL\nname=Хирургическая поликлинника\naddress=ул. Проспект косарева 156\ncity=Минск";
        //server.doAction(request);

        //request = "ADDDOCTOR\nidhospital=1\nfio=Петрова Ирина Андреевна\njobTitle=Окулист";
        //server.doAction(request);

        //request = "FINDHOSPITAL\ndoctor=1";
        //server.doAction(request);

        request = "FINDDOCTOR\nhospital=1";
        server.doAction(request);

        //request = "UPDATEHOSPITAL\nidhospital=1\nname=Советская поликлинника\naddress=ул. Косарева 195\n" +
        //        "city=Гомель";
        //server.doAction(request);

        //request = "UPDATEDOCTOR\niddoctor=1\nidhospital=1\nfio=Левшунов Егор Юрьевич\njobTitle=Хирург";
        //server.doAction(request);

        //request = "DELETE\nhospital\nidhospital=15";
        // server.doAction(request);

        //request = "DELETE\ndoctor\niddoctor=6";
        //server.doAction(request);

    }

}
