package controller.impl;

import controller.Command;
import logic.HospitalLogic;
import logic.LogicException;
import logic.LogicProvider;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindHospitalCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final HospitalLogic logic = logicProvider.getHospitallogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        ResultSet result;

        params = request.split("\n");
        params = params[1].split("=");

        switch (params[0]) {

            case "name", "address", "city" -> {

                try {
                    result = logic.find(params[0], params[1]);

                    while (result.next()) {

                        System.out.println(result.getString(2) + " "
                                + result.getString(3) + " " +
                                result.getString(4));

                    }

                    response.append("Found hospitals are printed.");

                } catch (LogicException | SQLException e) {
                    response.append("Сouldn't find.");
                }

            }

            default -> response.append("Field not found.");

        }

        return response;

    }

}
