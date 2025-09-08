/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import tictactoegame.Board;

public class TicTacToeFunctionalityTest {
    
    private Board board;
    
    @Before
    public void setUp() {
        board = new Board();
    }
    
    @After
    public void tearDown() {
        board = null;
    }
    
    @Test
    public void testBoardBasicFunctionality() {
        // Test valid move
        assertTrue("Should allow valid move", board.makeMove(0, 0, 'X'));
        
        // Test invalid move on occupied spot
        assertFalse("Should prevent move on occupied spot", board.makeMove(0, 0, 'O'));
        
        // Test valid move check
        assertTrue("Position (1,1) should be valid", board.isValidMove(1, 1));
        assertFalse("Occupied position should be invalid", board.isValidMove(0, 0));
    }
    
   
    
    @Test
    public void testWinnerDetection() {
        // Test row win
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        
        assertEquals("Should detect X as winner", 'X', board.checkWinner());
    }
    
    @Test
    public void testDiagonalWin() {
        // Test diagonal win
        board.makeMove(0, 0, 'O');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 2, 'O');
        
        assertEquals("Should detect O diagonal win", 'O', board.checkWinner());
    }
    
    @Test
    public void testNoWinner() {
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        
        assertEquals("Should have no winner yet", '-', board.checkWinner());
    }
    
    @Test
    public void testFullBoard() {
        // Test empty board
        assertFalse("New board should not be full", board.isFull());
        
        // Fill the board
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'O');
        board.makeMove(2, 1, 'X');
        board.makeMove(2, 2, 'O');
        
        assertTrue("Full board should be detected", board.isFull());
    }
    
    @Test
    public void testInvalidMoves() {
        // Test out of bounds moves
        assertFalse("Negative row should be invalid", board.isValidMove(-1, 0));
        assertFalse("Negative column should be invalid", board.isValidMove(0, -1));
        assertFalse("Row too large should be invalid", board.isValidMove(3, 0));
        assertFalse("Column too large should be invalid", board.isValidMove(0, 3));
    }

    private static class HumanPlayer {

        public HumanPlayer() {
        }

        private HumanPlayer(String alice, char c) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }


        private Object getName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object getSymbol() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class ComputerPlayer {

        public ComputerPlayer() {
        }

        private ComputerPlayer(String bot, char c) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object getSymbol() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object getName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private int[] makeMove(Board board) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }
}