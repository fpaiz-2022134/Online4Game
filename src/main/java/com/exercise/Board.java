package com.exercise;

public class Board {
    private final int rows;
    private final int columns;
    private final Cell[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Cell[rows][columns];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(null);
            }
        }
    }

    public boolean dropPiece(int column, Piece piece) {
        if (!isValidColumn(column) || isColumnFull(column)) {
            return false;
        }

        for (int row = rows - 1; row >= 0; row--) {
            if (grid[row][column].isEmpty()) {
                grid[row][column].setPiece(piece);
                return true;
            }
        }
        return false;
    }

    public boolean isColumnFull(int column) {
        if (!isValidColumn(column)) {
            return true;
        }
        return !grid[0][column].isEmpty();
    }

    public Cell getCell(int row, int column) {
        if (isValidPosition(row, column)) {
            return grid[row][column];
        }
        return null;
    }

    public boolean isValidColumn(int column) {
        return column >= 0 && column < columns;
    }

    public boolean isValidPosition(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean isFull() {
        for (int col = 0; col < columns; col++) {
            if (!isColumnFull(col)) {
                return false;
            }
        }
        return true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void display() {
        System.out.println("\n");
        for (int col = 0; col < columns; col++) {
            System.out.print(" " + col + " ");
        }
        System.out.println();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Cell cell = grid[row][col];
                if (cell.isEmpty()) {
                    System.out.print("| |");
                } else {
                    System.out.print("|" + cell.getPiece().getSymbol() + "|");
                }
            }
            System.out.println();
        }
        System.out.println("―――――――――――――――――――――");
    }
}