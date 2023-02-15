package com.returners;

import com.returners.controller.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {




    @Test
    public void basicFlowWithoutAnyExceptions() {
        Rover rover = new Rover();
        rover.initiateRoverMission(1, 2, "N" ,5,5);
        rover.move("LMLMLMLMM");
        assertEquals("1 3 N", rover.getPosition());




    }
    @Test
    public void  withObstacles() {
        Rover rover = new Rover();
        rover.initiateRoverMission(3, 3, "E" ,5,5);
        rover.move("MMRMMRMRRM");
        assertEquals("6 5 E", rover.getPosition());
    }


}
