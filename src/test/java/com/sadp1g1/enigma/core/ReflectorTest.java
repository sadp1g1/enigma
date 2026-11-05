package com.sadp1g1.enigma.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReflectorTest {

    @Test
    void reflectsAToY() {
        assertEquals('Y' - 'A', Reflector.B.reflect('A' - 'A'));
    }

    @Test
    void reflectsYBackToA() {
        assertEquals('A' - 'A', Reflector.B.reflect('Y' - 'A'));
    }

    @Test
    void everyLetterIsPairedBothWays() {
        // If X reflects to Y, then Y must reflect back to X
        for (int c = 0; c < 26; c++) {
            int other = Reflector.B.reflect(c);
            assertEquals(c, Reflector.B.reflect(other));
        }
    }

    @Test
    void noLetterReflectsToItself() {
        for (int c = 0; c < 26; c++) {
            assertNotEquals(c, Reflector.B.reflect(c));
        }
    }
}