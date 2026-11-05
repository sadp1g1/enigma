package com.sadp1g1.enigma.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RotorTest {

    @Test
    void forwardWithoutShift() {
        // Rotor I wires A to E when it stands at A
        assertEquals('E' - 'A', Rotor.I.forward('A' - 'A', 0));
    }

    @Test
    void forwardWithShift() {
        // At position B the signal from A enters the next wire and comes out as J
        assertEquals('J' - 'A', Rotor.I.forward('A' - 'A', 1));
    }

    @Test
    void backwardUndoesForwardForOneLetter() {
        assertEquals('A' - 'A', Rotor.I.backward('J' - 'A', 1));
    }

    @Test
    void backwardUndoesForwardForAllLettersAndPositions() {
        // Going through the rotor and back must return the original letter
        Rotor[] rotors = {Rotor.I, Rotor.II, Rotor.III};
        for (Rotor rotor : rotors) {
            for (int position = 0; position < 26; position++) {
                for (int c = 0; c < 26; c++) {
                    assertEquals(c, rotor.backward(rotor.forward(c, position), position));
                }
            }
        }
    }

    @Test
    void notchesAreDetected() {
        assertTrue(Rotor.I.isNotch('Q' - 'A'));
        assertTrue(Rotor.II.isNotch('E' - 'A'));
        assertTrue(Rotor.III.isNotch('V' - 'A'));
    }

    @Test
    void otherPositionsAreNotNotches() {
        assertFalse(Rotor.I.isNotch('A' - 'A'));
        assertFalse(Rotor.I.isNotch('R' - 'A'));
    }
}