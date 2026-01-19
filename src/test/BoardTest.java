class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(6, 7);
    }

    @Test
    void testDropPieceSuccess() {
        Piece piece = new Piece('X');
        assertTrue(board.dropPiece(0, piece));
        assertFalse(board.getCell(5, 0).isEmpty());
    }

    @Test
    void testDropPieceInvalidColumn() {
        Piece piece = new Piece('X');
        assertFalse(board.dropPiece(-1, piece));
        assertFalse(board.dropPiece(7, piece));
    }

    @Test
    void testColumnFull() {
        Piece piece = new Piece('X');
        
        for (int i = 0; i < 6; i++) {
            board.dropPiece(0, piece);
        }
        
        assertTrue(board.isColumnFull(0));
        assertFalse(board.dropPiece(0, piece));
    }

    @Test
    void testBoardFull() {
        Piece piece = new Piece('X');
        
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 6; row++) {
                board.dropPiece(col, piece);
            }
        }
        
        assertTrue(board.isFull());
    }

    @Test
    void testGetCellValid() {
        assertNotNull(board.getCell(0, 0));
        assertTrue(board.getCell(0, 0).isEmpty());
    }

    @Test
    void testGetCellInvalid() {
        assertNull(board.getCell(-1, 0));
        assertNull(board.getCell(6, 0));
        assertNull(board.getCell(0, -1));
        assertNull(board.getCell(0, 7));
    }
}