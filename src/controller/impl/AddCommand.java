package controller.impl;

import controller.Command;
import entity.Doctor;
import entity.Hospital;
import logic.HospitalLogic;
import logic.LogicException;
import logic.LogicProvider;

import static java.lang.Integer.parseInt;

public class AddCommand implements Command {

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

                    newHospital.setName(params[2].split("=")[1]);
                    newHospital.setAddress(params[3].split("=")[1]);
                    newHospital.setCity(params[4].split("=")[1]);

                    logic.add(newHospital);

                    response.append("Added Hospital.");

                } catch (LogicException e) {
                    response.append("Hospital not added.");
                }

            }

            case "doctor" -> {

                try {
                    newDoctor = new Doctor();

                    newDoctor.setIdHospital(parseInt(params[2].split("=")[1]));
                    newDoctor.setFio(params[3].split("=")[1]);
                    newDoctor.setJobTitle(params[4].split("=")[1]);

                    logic.add(newDoctor);

                    response.append("Added Doctor.");

                } catch (LogicException e) {
                    response.append("Doctor not added.");
                }

            }

        }

        return response;

    }

}
