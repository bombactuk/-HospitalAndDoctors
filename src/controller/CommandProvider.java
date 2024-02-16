package controller;

import controller.impl.AddCommand;
import controller.impl.FindDoctorsTheHospital;
import controller.impl.FindHospitalCommand;
import controller.impl.NoSuchCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        repository.put(CommandName.ADD, new AddCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
        repository.put(CommandName.FIND, new FindHospitalCommand());
        repository.put(CommandName.FINDDOCTORS, new FindDoctorsTheHospital());

    }

    Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;

        try {

            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);

        } catch (IllegalArgumentException | NullPointerException e) {

            command = repository.get(CommandName.WRONG_REQUEST);

        }

        return command;

    }

}
