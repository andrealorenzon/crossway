package test.crossway;


import dssc.crossway.Cell;
import dssc.crossway.CellStatus;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    void initializeCell () {
        Cell c = new Cell();
        assertEquals(c.getStatus(), CellStatus.EMPTY);
    }

    @Test
    void initializeWithEnumClass() {
        Cell c = new Cell();
        assertEquals(c.getStatus(), CellStatus.EMPTY);
    }
}
