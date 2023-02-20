package com.returners.view;

import com.returners.controller.Rover;
import com.returners.exception.OutOfPlateauException;
import com.returners.model.Plateau;

import java.util.Scanner;

public class RoverMission {

    private static String coordinates = null;
    private static String commands = null;
    private static final String INPUT_COORDINATES = "^(0|[1-9]\\d*) (0|[1-9]\\d*) (N|S|E|W)$";
    private static final String INPUT_MOVEMENTS = "^[RLM]+$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        getInitialRoverCoordinates(scanner);
        getRoverMovements(scanner);

        scanner.close();

        String[] result = coordinates.split(" ");
        Rover rover = new Rover();

        rover.initiateRoverMission(Integer.parseInt(result[0]), Integer.parseInt(result[1]), result[2] ,40,40);
        try {
            rover.move(commands);
        } catch (OutOfPlateauException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValidInputCoordinates(String input) {
        return (input.matches(INPUT_COORDINATES));
    }

    private static boolean isValidInputMovements(String input) {
        return (input.matches(INPUT_MOVEMENTS));
    }

    private static void getInitialRoverCoordinates(Scanner scanner) {
        System.out.print("Enter coordinate : ");
        coordinates = scanner.nextLine();
        if (!isValidInputCoordinates(coordinates)) {
            System.out.println(" Invalid input !!! ");
            getInitialRoverCoordinates(scanner);
        }
    }


    private static void getRoverMovements(Scanner scanner) {
        System.out.print("Enter Movement commands : ");
        commands = scanner.nextLine();

        if (!isValidInputMovements(commands)) {
            System.out.println(" Invalid input !!! ");
            getRoverMovements(scanner);
        }
    }


}
