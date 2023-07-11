package org.example.ParkingLot.commands;

import org.example.ParkingLot.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {
    Map<String,Icommand> commandRegistry;

    public CommandRegistry() {
        this.commandRegistry = new HashMap<>();
    }

    public void registerCommand(String commandType,Icommand command){
        commandRegistry.put(commandType,command);
    }
    public Icommand getCommand(String commandType){
        return commandRegistry.get(commandType);
    }

    public void executeCommand(List<String> tokens){
        String commandType = tokens.get(Constants.ZERO);
        Icommand command = getCommand(commandType);
        command.execute(tokens);

    }


}
