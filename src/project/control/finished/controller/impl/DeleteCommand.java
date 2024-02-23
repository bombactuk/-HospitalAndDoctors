package project.control.finished.controller.impl;

import project.control.finished.controller.Command;
import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;
import project.control.finished.logic.HospitalLogic;
import project.control.finished.logic.LogicException;
import project.control.finished.logic.LogicProvider;

import static java.lang.Integer.parseInt;

public class DeleteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;

        params = request.split("\n");

        switch (params[1]) {

            case "hospital", "doctor" -> {

                try {
                    logic.delete(params[1], Integer.parseInt(params[2].split("=")[1]));

                    response.append("Deletion completed.");

                } catch (LogicException e) {
                    response.append("Delete not.");
                }

            }

            default -> response.append("Field not found.");

        }

        return response;


    }

}
