package project.control.finished.controller.impl;

import project.control.finished.controller.Command;
import project.control.finished.entity.Doctor;
import project.control.finished.logic.HospitalLogic;
import project.control.finished.logic.LogicException;
import project.control.finished.logic.LogicProvider;

import static java.lang.Integer.parseInt;

public class AddDoctorCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        Doctor newDoctor;

        try {
            params = request.split("\n");

            newDoctor = new Doctor();

            newDoctor.setIdHospital(parseInt(params[1].split("=")[1]));
            newDoctor.setFio(params[2].split("=")[1]);
            newDoctor.setJobTitle(params[3].split("=")[1]);

            logic.add(newDoctor);

            response.append("Added Doctor.");

        } catch (LogicException e) {
            response.append("Doctor not added.");
        }

        return response;

    }
}
