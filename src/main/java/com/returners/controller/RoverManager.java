package com.returners.controller;

import com.returners.model.Obstacle;
import com.returners.model.Plateau;

import java.util.ArrayList;
import java.util.List;

public class RoverManager {

    private final List<Rover> rovers = new ArrayList<>();


    public void addRover(Rover rover) {
        rovers.add(rover);
    }


    public void removeRover(Rover rover) {
        rovers.remove(rover);
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public boolean isPositionOccupied(int x, int y) {
        if (!rovers.isEmpty()) {
            for (Rover rover : rovers) {
                if (rover.getxCoordinate() == x && rover.getyCoordinate() == y) {
                    return true;
                }
            }
        }

        return false;
    }


}
