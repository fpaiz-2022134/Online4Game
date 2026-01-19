
public class Board {

    private int rows;
    private int columns;
    private Cell[][] grid;

    public dropPiece(int column, Piece piece) {
        for (int row = rows - 1; row >= 0; row--) {
            if (grid[row][column].isEmpty()) {
                grid[row][column].setPiece(piece);
                return true;
            }
        }


    public IsColumnFull(int column) {
        return grid[0][column].isOccupied();
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }
}
