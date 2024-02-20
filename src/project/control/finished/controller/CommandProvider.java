package project.control.finished.controller;

import project.control.finished.controller.impl.AddCommand;
import project.control.finished.controller.impl.FindDoctorCommand;
import project.control.finished.controller.impl.FindHospitalCommand;
import project.control.finished.controller.impl.NoSuchCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        repository.put(CommandName.ADD, new AddCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
        repository.put(CommandName.FINDHOSPITAL, new FindHospitalCommand());
        repository.put(CommandName.FINDDOCTOR, new FindDoctorCommand());

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
