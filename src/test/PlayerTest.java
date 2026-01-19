class PlayerTest {
    @Test
    void testPlayerCreation() {
        Player player = new Player("Test Player", 'X');
        assertEquals("Test Player", player.getName());
        assertEquals('X', player.getPiece().getSymbol());
    }

    @Test
    void testPlayerWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("", 'X');
        });
    }

    @Test
    void testPlayerWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null, 'X');
        });
    }
}