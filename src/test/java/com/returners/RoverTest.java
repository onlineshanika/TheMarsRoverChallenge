package com.returners;

import com.returners.controller.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {




    @Test
    public void basicFlowWithoutAnyExceptions() {
        Rover rover = new Rover(0, 0, 'N');
        String commands = "LMLMLMLMM";
        for (char command : commands.toCharArray()) {
            rover.move(command);
        }

         assertEquals("0 1 N", rover.getPosition());
    }

}
