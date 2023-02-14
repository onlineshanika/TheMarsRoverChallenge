package com.returners;

import com.returners.controller.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {




    @Test
    public void basicFlowWithoutAnyExceptions() {
        Rover rover = new Rover();
        rover.initiateRoverMission(0, 0, "N" ,40,10);
        rover.move("RMMRM");
        assertEquals("2 0 S", rover.getPosition());
    }

}
