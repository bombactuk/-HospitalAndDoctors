package controller;

public interface Command {
    StringBuilder execute(String request);
}
