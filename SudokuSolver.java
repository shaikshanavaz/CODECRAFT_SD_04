package project;

	import java.util.Arrays;

	public class SudokuSolver {

	    private static final int GRID_SIZE = 9;

	    public static void main(String[] args) {
	        // Example of an unsolved Sudoku puzzle (0 represents empty cells)
	        int[][] board = {
	                {5, 3, 0, 0, 7, 0, 0, 0, 0},
	                {6, 0, 0, 1, 9, 5, 0, 0, 0},
	                {0, 9, 8, 0, 0, 0, 0, 6, 0},
	                {8, 0, 0, 0, 6, 0, 0, 0, 3},
	                {4, 0, 0, 8, 0, 3, 0, 0, 1},
	                {7, 0, 0, 0, 2, 0, 0, 0, 6},
	                {0, 6, 0, 0, 0, 0, 2, 8, 0},
	                {0, 0, 0, 4, 1, 9, 0, 0, 5},
	                {0, 0, 0, 0, 8, 0, 0, 7, 9}
	        };

	        System.out.println("Unsolved Sudoku:");
	        printBoard(board);

	        if (solveSudoku(board)) {
	            System.out.println("\nSolved Sudoku:");
	            printBoard(board);
	        } else {
	            System.out.println("\nNo solution exists.");
	        }
	    }

	    private static void printBoard(int[][] board) {
	        for (int row = 0; row < GRID_SIZE; row++) {
	            if (row % 3 == 0 && row != 0) {
	                System.out.println("-----------+-----------+-----------");
	            }
	            for (int col = 0; col < GRID_SIZE; col++) {
	                if (col % 3 == 0 && col != 0) {
	                    System.out.print("| ");
	                }
	                System.out.print(board[row][col] == 0 ? ". " : board[row][col] + " ");
	            }
	            System.out.println();
	        }
	    }

	    private static boolean solveSudoku(int[][] board) {
	        for (int row = 0; row < GRID_SIZE; row++) {
	            for (int col = 0; col < GRID_SIZE; col++) {
	                if (board[row][col] == 0) {
	                    for (int number = 1; number <= GRID_SIZE; number++) {
	                        if (isValidPlacement(board, number, row, col)) {
	                            board[row][col] = number;

	                            if (solveSudoku(board)) { // Recursive call
	                                return true;
	                            } else {
	                                board[row][col] = 0; // Backtrack
	                            }
	                        }
	                    }
	                    return false; // Trigger backtracking
	                }
	            }
	        }
	        return true; // Puzzle solved
	    }

	    private static boolean isValidPlacement(int[][] board, int number, int row, int col) {
	        // Check row
	        for (int i = 0; i < GRID_SIZE; i++) {
	            if (board[row][i] == number) {
	                return false;
	            }
	        }

	        // Check column
	        for (int i = 0; i < GRID_SIZE; i++) {
	            if (board[i][col] == number) {
	                return false;
	            }
	        }

	        // Check 3x3 subgrid
	        int boxRow = row - row % 3;
	        int boxCol = col - col % 3;

	        for (int i = boxRow; i < boxRow + 3; i++) {
	            for (int j = boxCol; j < boxCol + 3; j++) {
	                if (board[i][j] == number) {
	                    return false;
	                }
	            }
	        }

	        return true;
	    }
	} 



