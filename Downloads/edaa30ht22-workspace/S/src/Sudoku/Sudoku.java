package Sudoku;

/**
 * En klass som implementerar gränssnittet SudokuSolver för att lösa Sudoku-problem.
 */
/**
 * Represents a Sudoku puzzle and provides methods to manipulate and solve it.
 * The puzzle is a 9x9 grid where some cells are initially filled with numbers.
 * The goal is to fill the entire grid according to Sudoku rules.
 */
public class Sudoku implements SudokuSolver {

    /**
     * The 9x9 grid representing the Sudoku puzzle.
     */
    private int[][] board;

    /**
     * Constructs an empty Sudoku puzzle.
     */
    public Sudoku() {
        board = new int[9][9];
    }

    /**
     * Sets the Sudoku board with the provided values.
     *
     * @param board a 9x9 array representing the Sudoku puzzle
     * @throws IllegalArgumentException if the board is not 9x9
     */
    @Override
    public void setBoard(int[][] board) throws IllegalArgumentException {
        if (board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("Invalid board size. Must be 9x9.");
        }
        this.board = board;
    }

    /**
     * Gets a copy of the current Sudoku board.
     *
     * @return a copy of the 9x9 array representing the Sudoku puzzle
     */
    @Override
    public int[][] getBoard() {
        return board.clone();
    }

    /**
     * Attempts to solve the Sudoku puzzle.
     *
     * @return true if a solution is found, false otherwise
     */
    @Override
    public boolean solve() {
        return solve(0, 0);
    }

    
   private boolean solve(int row, int col) {
        // Base case: If we have reached the end of the puzzle, a solution is found
        if (row == 9) {
            return true;
        }

        // Calculate the next row and column indices
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col + 1) % 9;

        // If the current cell is already filled, move to the next cell
        if (board[row][col] != 0) {
            return solve(nextRow, nextCol);
        }

        // Try placing numbers 1 to 9 in the current cell
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                // If placing num is a valid move, set the cell value
                board[row][col] = num;

                // Recursively attempt to solve the puzzle with the updated board
                if (solve(nextRow, nextCol)) {
                    return true;  // A solution is found
                }

                // If the current placement does not lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        // No valid move was found, backtrack to the previous cell
        return false;
    }



    /**
     * Checks if placing a number at a specific cell is a legal move.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param num the number to be placed
     * @return true if the move is legal, false otherwise
     */
    @Override
    public boolean isLegal(int row, int col, int num) {
        return isValid(row, col, num);
    }
    
   
    private boolean isValid(int row, int col, int num) {
        // Check the row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;  // Number already exists in row or column
            }
        }

        // Check the 3x3 region
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;  // Number already exists in the region
                }
            }
        }

        return true;  // The move is legal
    }



    /**
     * Gets the number at a specific cell on the Sudoku board.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the number at the specified cell
     */
    @Override
    public int get(int row, int col) {
        return board[row][col];
    }

    /**
     * Sets a number at a specific cell on the Sudoku board.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param num the number to be set
     */
    @Override
    public void set(int row, int col, int num) {
        board[row][col] = num;
    }

    /**
     * Clears the entire Sudoku board.
     */
    @Override
    public void clear() {
        board = new int[9][9];
    }

    // Helper methods for checking the validity of moves in rows, columns, and regions...
}
