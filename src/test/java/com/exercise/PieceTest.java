package com.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PieceTest {
    @Test
    void testPieceCreation() {
        Piece piece = new Piece('X');
        assertEquals('X', piece.getSymbol());
    }

    @Test
    void testDifferentPieces() {
        Piece piece1 = new Piece('X');
        Piece piece2 = new Piece('O');
        
        assertNotEquals(piece1.getSymbol(), piece2.getSymbol());
    }
}