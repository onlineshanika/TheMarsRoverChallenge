package com.returners.controller;

import com.returners.model.Obstacle;
import com.returners.model.Plateau;
import com.returners.model.Rectangle;

public class Rover {

    private int xCoordinate;
    private int yCoordinate;
    private Direction direction;

    private boolean obstacleDetected;
    private boolean autonomous;
    private Mobility mobility;
    private Communication communication;

    private Plateau plateau;

    public Rover() {
    }

    private void move(Direction direction) {
        if (direction == Direction.L) {
            turnLeft();
        } else if (direction == Direction.R) {
            turnRight();
        } else if (direction == Direction.M) {
            moveForward();
        }
    }

    private void turnLeft() {

        if (this.direction == Direction.N) {
            this.direction = Direction.E;
        } else if (this.direction == Direction.E) {
            this.direction = Direction.S;
        } else if (this.direction == Direction.S) {
            this.direction = Direction.W;
        } else if (this.direction == Direction.W) {
            this.direction = Direction.N;
        }
    }

    private void turnRight() {

        if (this.direction == Direction.N) {
            this.direction = Direction.W;
        } else if (this.direction == Direction.W) {
            this.direction = Direction.S;
        } else if (this.direction == Direction.S) {
            this.direction = Direction.E;
        } else if (this.direction == Direction.E) {
            this.direction = Direction.N;
        }

    }

    private void moveForward() {
        if (this.direction == Direction.N && isValidCoordinate(xCoordinate, yCoordinate + 1) && detectObstacle(xCoordinate, yCoordinate + 1)) {
            this.yCoordinate++;
        } else if (this.direction == Direction.E && isValidCoordinate(xCoordinate + 1, yCoordinate) && detectObstacle(xCoordinate + 1, yCoordinate)) {
            this.xCoordinate++;
        } else if (this.direction == Direction.S && isValidCoordinate(xCoordinate, yCoordinate - 1) && detectObstacle(xCoordinate, yCoordinate - 1)) {
            this.yCoordinate--;
        } else if (this.direction == Direction.W && isValidCoordinate(xCoordinate - 1, yCoordinate) && detectObstacle(xCoordinate - 1, yCoordinate)) {
            this.xCoordinate--;
        } else {
            makeErrorSound();
        }
    }

    private void spinLeft() {

    }

    private void spinRight() {

    }

    /**
     * The "detect" method would be responsible for checking if the next move the Rover makes would be valid or not.
     * This method would check if the Rover's next position is within the bounds of the Plateau,
     * and whether or not there is an obstacle at that location.
     */
    private boolean detectObstacle(int nextX, int nextY) {
        // Check if the next position is within the bounds of the Plateau
        if (nextX < 0 || nextX >= plateau.getShape().getWidth() || nextY < 0 || nextY >= plateau.getShape().getHeight()) {
            obstacleDetected = false;
            return false;
        }

        // Check if there is an obstacle at the next position
        for (Obstacle obstacle : plateau.getObstacles()) {
            if (obstacle.getxCoordinate() == nextX && obstacle.getyCoordinate() == nextY) {
                obstacleDetected = false;
                return false;
            }
        }

        obstacleDetected = true;
        return true;
    }

    public void setAutonomous(boolean autonomous) {
        this.autonomous = autonomous;
    }

    public void setMobility(Mobility mobility) {
        this.mobility = mobility;
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public String getPosition() {
        System.out.println(xCoordinate + " " + yCoordinate + " " + direction);
        return xCoordinate + " " + yCoordinate + " " + direction;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void initiateRoverMission(int xCoordinate, int yCoordinate, String direction, int plateauWidth, int plateauHeight) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = Direction.directionBy(direction);

        this.plateau = new Plateau();
        Rectangle shape = new Rectangle();
        shape.setHeight(plateauHeight);
        shape.setWidth(plateauWidth);
        this.plateau.setShape(shape);
        plateau.setBoundary(shape);
        plateau.loadObstacles();

    }

    public void move(String inputs) {
        if (inputs != null && !inputs.trim().isEmpty()) {
            inputs = inputs.toUpperCase().trim();
            char[] commands = inputs.toCharArray();
            for (char command : commands) {
                move(Direction.directionBy(String.valueOf(command)));
                System.out.println(" coordinates  :   " + xCoordinate + " " + yCoordinate + " " + this.direction);
            }
        }
    }

    private boolean isValidCoordinate(int newX, int newY) {
        return ((newX >= 0 && newY >= 0)
                && (this.plateau.getShape().getHeight() >= newY && this.plateau.getShape().getWidth() >= newX));

    }

    private void makeErrorSound() {
        int beepCount = 3;
        for (int i = 0; i < beepCount; ++i) {
            System.out.println("Beep : " + i);
            // Ring the bell again using the Toolkit
            java.awt.Toolkit.getDefaultToolkit().beep();
            try {
                Thread.sleep(1000); // introduce delay
            } catch (InterruptedException e) {

            }
        }

    }


//    private boolean obstacleDetected(int xCoordinate,int yCoordinate) {
//
//        for (Obstacle obstacle : this.plateau.getObstacles()) {
//            if (obstacle.getxCoordinate() == xCoordinate && obstacle.getyCoordinate() == yCoordinate) {
//                return true;
//            }
//        }
//        return false;
//    }

}



