package com.returners.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Plateau {

    private Shape shape;
    private List<Obstacle> obstacles = new ArrayList<>();

    public void setBoundary(Shape shape) {
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }


    public int loadObstacles() {

        try (InputStream input = Plateau.class.getClassLoader().getResourceAsStream("rover.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find rover.properties");
                return 0;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and add that to obstacles list
            String obstaclesString = prop.getProperty("Obstacles");
            if (obstaclesString != null && !obstaclesString.isEmpty()) {
                String[] obstaclesArray = obstaclesString.split(",");

                for (String o : obstaclesArray) {
                    String[] coordinates = o.split(" ");
                    this.obstacles.add(new Obstacle(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return this.obstacles.size();
    }
}