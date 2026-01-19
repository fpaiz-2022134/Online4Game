package com.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {
    @Test
    void testPlayerCreation() {
        Player player = new Player("Test Player", 'X');
        assertEquals("Test Player", player.getName());
        assertEquals('X', player.getPiece().getSymbol());
    }

    @Test
    void testPlayerWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("", 'X');
        });
    }

    @Test
    void testPlayerWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null, 'X');
        });
    }
}