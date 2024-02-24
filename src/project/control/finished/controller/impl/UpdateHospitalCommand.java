package project.control.finished.controller.impl;

import project.control.finished.controller.Command;
import project.control.finished.entity.Hospital;
import project.control.finished.logic.HospitalLogic;
import project.control.finished.logic.LogicException;
import project.control.finished.logic.LogicProvider;

public class UpdateHospitalCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        Hospital newHospital;

        params = request.split("\n");

        try {
            newHospital = new Hospital();

            newHospital.setName(params[2].split("=")[1]);
            newHospital.setAddress(params[3].split("=")[1]);
            newHospital.setCity(params[4].split("=")[1]);

            logic.update(Integer.parseInt(params[1].split("=")[1]), newHospital);

            response.append("Update Hospital.");

        } catch (LogicException e) {
            response.append("Update not added.");
        }

        return response;

    }
}
