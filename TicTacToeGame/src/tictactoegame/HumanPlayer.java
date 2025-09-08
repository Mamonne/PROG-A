/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoegame;

/**
 *
 * @author PC
 */

    // Human player class inheriting from Player
class HumanPlayer extends Player {
    private java.util.Scanner scanner;
    
    // Constructor using super()
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
        this.scanner = new java.util.Scanner(System.in);
    }
    
    @Override
    public int[] makeMove(Board board) {
        int[] move = new int[2];
        boolean validInput = false;
        
        // Loop until valid input is received
        while (!validInput) {
            try {
                System.out.println(name + " (" + symbol + "), enter your move:");
                System.out.print("Row (0-2): ");
                move[0] = scanner.nextInt();
                System.out.print("Column (0-2): ");
                move[1] = scanner.nextInt();
                
                if (board.isValidMove(move[0], move[1])) {
                    validInput = true;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter valid numbers!");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        
        return move;
    }
}

