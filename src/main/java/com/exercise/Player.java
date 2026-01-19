package com.exercise;

public class Player {
    private final String name;
    private final Piece piece;

    public Player(String name, char symbol) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del jugador no puede estar vacío");
        }
        this.name = name;
        this.piece = new Piece(symbol);
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return name + " (" + piece.getSymbol() + ")";
    }
}