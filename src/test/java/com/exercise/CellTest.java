package com.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testEmptyCell() {
        Cell cell = new Cell(null);
        assertTrue(cell.isEmpty());
        assertNull(cell.getPiece());
    }

    @Test
    void testCellWithPiece() {
        Piece piece = new Piece('X');
        Cell cell = new Cell(piece);
        assertFalse(cell.isEmpty());
        assertEquals(piece, cell.getPiece());
    }

    @Test
    void testSetPiece() {
        Cell cell = new Cell(null);
        Piece piece = new Piece('O');
        
        cell.setPiece(piece);
        assertFalse(cell.isEmpty());
        assertEquals('O', cell.getPiece().getSymbol());
    }
}
