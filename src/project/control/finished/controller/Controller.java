package project.control.finished.controller;

public class Controller {

    private final char paramDelimeter = '\n';

    private final CommandProvider provider = new CommandProvider();

    public String doAction(String request) {

        String commandName;
        Command executionCommand;
        StringBuilder response = new StringBuilder();

        try {
            commandName = request.substring(0, request.indexOf(paramDelimeter));
            executionCommand = provider.getCommand(commandName.toUpperCase());

            response.append(executionCommand.execute(request));

        } catch (Exception e) {
            response.append("Technical problems.");
        }

        return response.toString();

    }
}
