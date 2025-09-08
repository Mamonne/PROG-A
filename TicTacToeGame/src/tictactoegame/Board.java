/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoegame;

/**
 *
 * @author PC
 */
public class Board {
    private char[][] grid; // 2D array to represent the board
    private final int SIZE = 3;
    
    // Constructor - initializes empty board
    public Board() {
        grid = new char[SIZE][SIZE];
        initializeBoard();
    }
    
    // Private method for information hiding
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '-';
            }
        }
    }
    
    // Public method to display the board
    public void displayBoard() {
        System.out.println("\nCurrent Board:");
        System.out.println("  0 1 2");
        
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Method to check if a move is valid
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col] == '-';
    }
    
    // Method to place a symbol on the board
    public boolean makeMove(int row, int col, char symbol) {
        if (isValidMove(row, col)) {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }
    
    // Method to check for a winner
    public char checkWinner() {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] != '-' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return grid[i][0];
            }
        }
        
        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (grid[0][j] != '-' && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
                return grid[0][j];
            }
        }
        
        // Check diagonals
        if (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[0][0];
        }
        
        if (grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[0][2];
        }
        
        return '-'; // No winner
    }
    
    // Method to check if board is full
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

