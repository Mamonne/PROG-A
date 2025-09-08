/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoegame;

/**
 *
 * @author PC
 */

 class ComputerPlayer extends Player {
    
    // Constructor
    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }
    
    @Override
    public int[] makeMove(Board board) {
        int[] move = new int[2];
        
        // Simple AI - find first available spot
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isValidMove(i, j)) {
                    move[0] = i;
                    move[1] = j;
                    System.out.println(name + " (" + symbol + ") chooses: Row " + i + ", Column " + j);
                    return move;
                }
            }
        }
        
        return move;
    }
}

