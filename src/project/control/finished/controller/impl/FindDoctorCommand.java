package project.control.finished.controller.impl;

import project.control.finished.controller.Command;
import project.control.finished.entity.Doctor;
import project.control.finished.logic.HospitalLogic;
import project.control.finished.logic.LogicException;
import project.control.finished.logic.LogicProvider;

import java.util.List;

public class FindDoctorCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        List<Doctor> doctors;

        try {
            params = request.split("\n");
            params = params[1].split("=");

            switch (params[0]) {

                case "fio", "jobTitle", "hospital" -> {

                    doctors = logic.findDoctor(params[0], params[1]);
                    response.append("Found hospitals are printed.\n");

                    for (Doctor doctor : doctors) {
                        response.append(doctor.getFio() + ", " + doctor.getJobTitle() + "\n");
                    }

                }

                default -> response.append("Field not found.");

            }

        } catch (LogicException e) {
            response.append("Сouldn't find.");
        }

        return response;

    }

}
