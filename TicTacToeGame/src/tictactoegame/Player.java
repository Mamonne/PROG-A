/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoegame;

/**
 *
 * @author PC
 */
    abstract class Player {
    protected char symbol;
    protected String name;
    
    // Constructor
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    
    // Information hiding - getter methods
    public char getSymbol() {
        return symbol;
    }
    
    public String getName() {
        return name;
    }
    
    // Abstract method to be implemented by subclasses
    public abstract int[] makeMove(Board board);
}


