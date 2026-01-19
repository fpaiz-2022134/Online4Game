
public class Board {

    private int rows;
    private int columns;
    private Cell[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(null);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

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
