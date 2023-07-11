package org.example.ParkingLot;

import org.example.ParkingLot.commands.CommandRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        AppConfiguration appConfiguration = AppConfiguration.getInstance();
        CommandRegistry CommandInvoker = appConfiguration.getCommandRegistry();
        String inputFile ="C:\\Users\\shiva\\Downloads\\rest (1)\\ParKingLot\\sampleInput\\sampleInputFile.txt";
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while(line!=null){
                List<String> token = Arrays.asList(line.split(" "));
                List<String>tokens = new ArrayList<>(token);
                CommandInvoker.executeCommand(tokens);
                line = reader.readLine();

            }
        }catch(IOException e){
            e.printStackTrace();
        }
        }
    }
