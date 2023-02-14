package com.returners;

import com.returners.model.Plateau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {


    @Test
    public void getAllObstacles() {
        Plateau plateau = new Plateau();
//        plateau.loadObstacles();
        assertEquals("4 5,2 3",plateau.loadObstacles() );
    }
}



