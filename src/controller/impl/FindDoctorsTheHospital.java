package controller.impl;

import controller.Command;
import entity.Hospital;
import logic.HospitalLogic;
import logic.LogicException;
import logic.LogicProvider;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindDoctorsTheHospital implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        ResultSet result;

        params = request.split("\n");

        try {
            result = logic.findDoctors(Integer.parseInt(params[1].split("=")[1]));

            response.append("Found doctors are printed.");

            while (result.next()) {

                System.out.println(result.getString(3) + " " +
                        result.getString(4));

            }

        } catch (LogicException | SQLException e) {
            response.append("doctors not.");
        }

        return response;

    }

}
