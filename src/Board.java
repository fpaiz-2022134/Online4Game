
public class Board {

    private int rows;
    private int columns;
    private Cell[][] grid;

    public boolean dropPiece(int column, Piece piece) {
        for (int row = rows - 1; row >= 0; row--) {
            if (grid[row][column].isEmpty()) {
                grid[row][column].setPiece(piece);
                return true;
            }
        }
        return false; // Column is full
    }

    public boolean IsColumnFull(int column) {
        return !grid[0][column].isEmpty();
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }
}
