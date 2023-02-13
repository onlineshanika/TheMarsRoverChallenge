package com.returners.controller;

public class Rover {

    private int xCoordinate;
    private int yCoordinate;
    private char direction;

    public Rover(int xCoordinate, int yCoordinate, char direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }



    public void move(char command) {
        switch (command) {
            case 'L' -> turnLeft();
            case 'R' -> turnRight();
            case 'M' -> moveForward();
            default -> System.out.println("Invalid command received.");
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N' -> direction = 'W';
            case 'W' -> direction = 'S';
            case 'S' -> direction = 'E';
            case 'E' -> direction = 'N';
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N' -> direction = 'E';
            case 'E' -> direction = 'S';
            case 'S' -> direction = 'W';
            case 'W' -> direction = 'N';
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N' -> yCoordinate++;
            case 'E' -> xCoordinate++;
            case 'S' -> yCoordinate--;
            case 'W' -> xCoordinate--;
        }
    }

    public String getPosition() {
        System.out.println(xCoordinate + " " + yCoordinate + " " + direction );
        return xCoordinate + " " + yCoordinate + " " + direction;
    }
}


