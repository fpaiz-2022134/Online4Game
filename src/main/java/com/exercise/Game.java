package com.exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Player> players;
    private int currentPlayerIndex;
    private boolean isGameOver;
    private final RuleChecker ruleChecker;
    private static final int DEFAULT_ROWS = 6;
    private static final int DEFAULT_COLUMNS = 7;

    public Game() {
        this(DEFAULT_ROWS, DEFAULT_COLUMNS);
    }

    public Game(int rows, int columns) {
        this.board = new Board(rows, columns);
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.isGameOver = false;
        this.ruleChecker = new RuleChecker();
        initializePlayers();
    }

    private void initializePlayers() {
        players.add(new Player("Jugador 1", 'X'));
        players.add(new Player("Jugador 2", 'O'));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   BIENVENIDO A CONNECT 4");
        System.out.println("=================================");
        System.out.println("Objetivo: Conecta 4 fichas en línea (horizontal, vertical o diagonal)");

        board.display();

        while (!isGameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\nTurno de: " + currentPlayer);

            int column = getValidColumn(scanner, currentPlayer);

            boolean moved = playTurn(column);
            if (moved) {
                board.display();

                if (ruleChecker.checkWin(board, currentPlayer.getPiece())) {
                    System.out.println("\n ¡FELICIDADES! " + currentPlayer.getName() + " ha ganado! ");
                    isGameOver = true;
                } else if (board.isFull()) {
                    System.out.println("\n¡Empate! El tablero está lleno.");
                    isGameOver = true;
                } else {
                    switchTurn();
                }
            }
        }

        scanner.close();
        System.out.println("\n¡Gracias por jugar!");
    }

    private int getValidColumn(Scanner scanner, Player player) {
        int column = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Ingresa la columna (0-" + (board.getColumns() - 1) + "): ");

            if (scanner.hasNextInt()) {
                column = scanner.nextInt();

                if (board.isValidColumn(column) && !board.isColumnFull(column)) {
                    validInput = true;
                } else if (board.isValidColumn(column)) {
                    System.out.println(" La columna " + column + " está llena. Intenta otra.");
                } else {
                    System.out.println(" Columna inválida. Debe estar entre 0 y " +
                            (board.getColumns() - 1));
                }
            } else {
                System.out.println(" Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }

        return column;
    }

    public boolean playTurn(int column) {
        Player currentPlayer = players.get(currentPlayerIndex);
        return board.dropPiece(column, currentPlayer.getPiece());
    }

    public void switchTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}