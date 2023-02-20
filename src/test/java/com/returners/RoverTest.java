package com.returners;

import com.returners.controller.Rover;
import com.returners.exception.OutOfPlateauException;
import com.returners.util.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverTest {


    @Test
    public void basicFlowWithoutAnyExceptions() throws OutOfPlateauException {
        Rover rover = new Rover();
        rover.initiateRoverMission(1, 2, "N", 5, 5);
        rover.move("LMLMLMLMM");
        assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    public void withObstacles() throws OutOfPlateauException {
        Rover rover = new Rover();
        rover.initiateRoverMission(3, 3, "E", 5, 5);
        rover.move("MMRMMRMRRM");
        assertEquals("6 5 E", rover.getPosition());
    }


    @Test
    public void  roverOutOfPlateau() throws OutOfPlateauException {
        Rover rover = new Rover();
        rover.initiateRoverMission(3, 3, "E" ,5,5);

        Exception exception = assertThrows(OutOfPlateauException.class, () -> rover.move("MMMMMM"));
        assertEquals(Message.ROVER_OUT_OF_RANGE, exception.getMessage());
    }

}
