package project.control.finished.controller.impl;

import project.control.finished.controller.Command;
import project.control.finished.logic.HospitalLogic;
import project.control.finished.logic.LogicException;
import project.control.finished.logic.LogicProvider;

public class DeleteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;

        try {
            params = request.split("\n");

            switch (params[1]) {

                case "hospital", "doctor" -> {

                    logic.delete(params[1], Integer.parseInt(params[2].split("=")[1]));

                    response.append("Deletion completed.");

                }

                default -> response.append("Field not found.");

            }

        } catch (LogicException e) {
            response.append("Delete not.");
        }

        return response;

    }

}
