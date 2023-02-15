package com.returners;

import com.returners.model.Plateau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {


    @Test
    public void getAllObstacles() {
        Plateau plateau = new Plateau();
         assertEquals(2,plateau.loadObstacles() );
    }
}



