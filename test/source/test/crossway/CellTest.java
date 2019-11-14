package test.crossway;


import dssc.crossway.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    void initializeCell () {
        Cell c = new Cell();
        assertEquals(c.getStatus(), "null");
    }
}
