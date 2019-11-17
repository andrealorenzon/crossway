package test.crossway;


import dssc.crossway.Cell;
import dssc.crossway.Colors;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

 class CellTest {

    @Test
    void initializeCell () {
        Cell c = new Cell();
        assertEquals(c.getStatus(), Colors.EMPTY);
    }

    @Test
    void initializeWithEnumClass() {
        Cell c = new Cell();
        assertEquals(c.getStatus(), Colors.EMPTY);
    }
}
