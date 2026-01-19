public class RuleChecker {

    public boolean checkWin(Board board, Piece piece) {
        int rows = board.getRows();
        int columns = board.getColumns();
        char symbol = piece.getSymbol();

        // Check horizontal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= columns - 4; col++) {
                if (checkLine(board, row, col, 0, 1, symbol)) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int row = 0; row <= rows - 4; row++) {
            for (int col = 0; col < columns; col++) {
                if (checkLine(board, row, col, 1, 0, symbol)) {
                    return true;
                }
            }
        }

        // Check diagonal (down-right)
        for (int row = 0; row <= rows - 4; row++) {
            for (int col = 0; col <= columns - 4; col++) {
                if (checkLine(board, row, col, 1, 1, symbol)) {
                    return true;
                }
            }
        }

        // Check diagonal (up-right)
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col <= columns - 4; col++) {
                if (checkLine(board, row, col, -1, 1, symbol)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkLine(Board board, int startRow, int startCol, int rowDir, int colDir, char symbol) {
        for (int i = 0; i < 4; i++) {
            Cell cell = board.getCell(startRow + i * rowDir, startCol + i * colDir);
            if (cell.isEmpty() || cell.getPiece().getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
