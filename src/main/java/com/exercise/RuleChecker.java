package com.exercise;

public class RuleChecker {
    private static final int WIN_COUNT = 4;

    public boolean checkWin(Board board, Piece piece) {
        if (board == null || piece == null) {
            return false;
        }

        return checkHorizontal(board, piece) ||
                checkVertical(board, piece) ||
                checkDiagonalAscending(board, piece) ||
                checkDiagonalDescending(board, piece);
    }

    private boolean checkHorizontal(Board board, Piece piece) {
        for (int row = 0; row < board.getRows(); row++) {
            int count = 0;
            for (int col = 0; col < board.getColumns(); col++) {
                if (isPieceAt(board, row, col, piece)) {
                    count++;
                    if (count >= WIN_COUNT) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(Board board, Piece piece) {
        for (int col = 0; col < board.getColumns(); col++) {
            int count = 0;
            for (int row = 0; row < board.getRows(); row++) {
                if (isPieceAt(board, row, col, piece)) {
                    count++;
                    if (count >= WIN_COUNT) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalAscending(Board board, Piece piece) {
        for (int row = 3; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns() - 3; col++) {
                if (isPieceAt(board, row, col, piece) &&
                        isPieceAt(board, row - 1, col + 1, piece) &&
                        isPieceAt(board, row - 2, col + 2, piece) &&
                        isPieceAt(board, row - 3, col + 3, piece)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalDescending(Board board, Piece piece) {
        for (int row = 0; row < board.getRows() - 3; row++) {
            for (int col = 0; col < board.getColumns() - 3; col++) {
                if (isPieceAt(board, row, col, piece) &&
                        isPieceAt(board, row + 1, col + 1, piece) &&
                        isPieceAt(board, row + 2, col + 2, piece) &&
                        isPieceAt(board, row + 3, col + 3, piece)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPieceAt(Board board, int row, int col, Piece piece) {
        Cell cell = board.getCell(row, col);
        if (cell == null || cell.isEmpty()) {
            return false;
        }
        Piece cellPiece = cell.getPiece();
        return cellPiece != null && cellPiece.getSymbol() == piece.getSymbol();
    }
}