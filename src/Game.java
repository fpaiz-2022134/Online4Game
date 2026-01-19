import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean isGameOver;
    private RuleChecker ruleChecker;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.isGameOver = false;
        this.ruleChecker = new RuleChecker();
    }

    public void start() {
        this.currentPlayerIndex = 0;
        this.isGameOver = false;
    }

    public boolean playTurn(int column) {
        if (isGameOver) {
            return false;
        }

        Player currentPlayer = players.get(currentPlayerIndex);
        Piece piece = currentPlayer.getPiece();

        if (board.IsColumnFull(column)) {
            return false;
        }

        boolean dropped = board.dropPiece(column, piece);
        if (!dropped) {
            return false;
        }

        if (ruleChecker.checkWin(board, piece)) {
            isGameOver = true;
            return true;
        }

        switchTurn();
        return true;
    }

    public void switchTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public Board getBoard() {
        return board;
    }
}
