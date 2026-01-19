
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class RuleCheckerTest {
    private Board board;
    private RuleChecker ruleChecker;
    private Piece pieceX;
    private Piece pieceO;

    @BeforeEach
    void setUp() {
        board = new Board(6, 7);
        ruleChecker = new RuleChecker();
        pieceX = new Piece('X');
        pieceO = new Piece('O');
    }

    @Test
    void testHorizontalWin() {
        // Colocar 4 fichas horizontalmente
        board.dropPiece(0, pieceX);
        board.dropPiece(1, pieceX);
        board.dropPiece(2, pieceX);
        board.dropPiece(3, pieceX);

        assertTrue(ruleChecker.checkWin(board, pieceX));
        assertFalse(ruleChecker.checkWin(board, pieceO));
    }

    @Test
    void testVerticalWin() {
        // Colocar 4 fichas verticalmente
        board.dropPiece(0, pieceX);
        board.dropPiece(0, pieceX);
        board.dropPiece(0, pieceX);
        board.dropPiece(0, pieceX);

        assertTrue(ruleChecker.checkWin(board, pieceX));
    }

    @Test
    void testDiagonalAscendingWin() {
        // Crear diagonal ascendente
        board.dropPiece(0, pieceX);
        
        board.dropPiece(1, pieceO);
        board.dropPiece(1, pieceX);
        
        board.dropPiece(2, pieceO);
        board.dropPiece(2, pieceO);
        board.dropPiece(2, pieceX);
        
        board.dropPiece(3, pieceO);
        board.dropPiece(3, pieceO);
        board.dropPiece(3, pieceO);
        board.dropPiece(3, pieceX);

        assertTrue(ruleChecker.checkWin(board, pieceX));
    }

    @Test
    void testDiagonalDescendingWin() {
        // Crear diagonal descendente
        board.dropPiece(3, pieceO);
        board.dropPiece(3, pieceO);
        board.dropPiece(3, pieceO);
        board.dropPiece(3, pieceX);
        
        board.dropPiece(2, pieceO);
        board.dropPiece(2, pieceO);
        board.dropPiece(2, pieceX);
        
        board.dropPiece(1, pieceO);
        board.dropPiece(1, pieceX);
        
        board.dropPiece(0, pieceX);

        assertTrue(ruleChecker.checkWin(board, pieceX));
    }

    @Test
    void testNoWin() {
        board.dropPiece(0, pieceX);
        board.dropPiece(1, pieceO);
        board.dropPiece(2, pieceX);

        assertFalse(ruleChecker.checkWin(board, pieceX));
        assertFalse(ruleChecker.checkWin(board, pieceO));
    }

    @Test
    void testThreeInRowNotWin() {
        board.dropPiece(0, pieceX);
        board.dropPiece(1, pieceX);
        board.dropPiece(2, pieceX);

        assertFalse(ruleChecker.checkWin(board, pieceX));
    }
}
