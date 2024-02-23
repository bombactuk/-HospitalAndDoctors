package project.control.finished.controller.impl;

import project.control.finished.controller.Command;
import project.control.finished.entity.Doctor;
import project.control.finished.entity.Hospital;
import project.control.finished.logic.HospitalLogic;
import project.control.finished.logic.LogicException;
import project.control.finished.logic.LogicProvider;

import static java.lang.Integer.parseInt;

public class UpdateCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        Hospital newHospital;
        Doctor newDoctor;

        params = request.split("\n");

        switch (params[1]) {

            case "hospital" -> {

                try {
                    newHospital = new Hospital();

                    newHospital.setName(params[3].split("=")[1]);
                    newHospital.setAddress(params[4].split("=")[1]);
                    newHospital.setCity(params[5].split("=")[1]);

                    logic.update(Integer.parseInt(params[2].split("=")[1]), newHospital);

                    response.append("Update Hospital.");

                } catch (LogicException e) {
                    response.append("Update not added.");
                }

            }

            case "doctor" -> {

                try {
                    newDoctor = new Doctor();

                    newDoctor.setIdHospital(parseInt(params[3].split("=")[1]));
                    newDoctor.setFio(params[4].split("=")[1]);
                    newDoctor.setJobTitle(params[5].split("=")[1]);

                    logic.update(Integer.parseInt(params[2].split("=")[1]), newDoctor);

                    response.append("Update Doctor.");

                } catch (LogicException e) {
                    response.append("Update not added.");
                }

            }

            default -> response.append("Field not found.");

        }

        return response;

    }
}
