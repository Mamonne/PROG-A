/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoegame;

/**
 *
 * @author PC
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver;
    
    // Constructor
    public Game() {
        board = new Board();
        setupPlayers();
        currentPlayer = player1;
        gameOver = false;
    }
    
    // Private method for setting up players (information hiding)
    private void setupPlayers() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("=== Welcome to Tic Tac Toe ===");
        System.out.println("Choose game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.print("Enter choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter name for Player 1 (X): ");
        String name1 = scanner.nextLine();
        player1 = new HumanPlayer(name1, 'X');
        
        if (choice == 1) {
            System.out.print("Enter name for Player 2 (O): ");
            String name2 = scanner.nextLine();
            player2 = new HumanPlayer(name2, 'O');
        } else {
            player2 = new ComputerPlayer("Computer", 'O');
        }
    }
    
    // Method to switch current player
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    
    // Main game loop
    public void playGame() {
        System.out.println("\nGame Started!");
        System.out.println("Players: " + player1.getName() + " (X) vs " + player2.getName() + " (O)");
        
        // Game loop continues until game is over
        while (!gameOver) {
            board.displayBoard();
            
            // Current player makes a move
            int[] move = currentPlayer.makeMove(board);
            board.makeMove(move[0], move[1], currentPlayer.getSymbol());
            
            // Check for winner
            char winner = board.checkWinner();
            if (winner != '-') {
                board.displayBoard();
                System.out.println("🎉 " + currentPlayer.getName() + " wins!");
                gameOver = true;
            } else if (board.isFull()) {
                board.displayBoard();
                System.out.println("It's a tie!");
                gameOver = true;
            } else {
                switchPlayer();
            }
        }
        
        System.out.println("Thanks for playing!");
    }
}


