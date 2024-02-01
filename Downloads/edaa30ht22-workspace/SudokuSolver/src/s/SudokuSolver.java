package s;

/**
 * Interface for solving Sudoku puzzles.
 */
public interface SudokuSolver {
    /**
     * Set sudoku board; numbers 1-9 are fixed values, 0 is unsolved.
     *
     * @param board a board to copy values from
     * @throws IllegalArgumentException if the board is invalid, e.g., not 9x9
     */
    void setBoard(int[][] board);

    /**
     * Get a copy of the Sudoku board.
     *
     * @return a copy of the 9x9 array representing the Sudoku puzzle
     */
    int[][] getBoard();

    /**
     * Solve Sudoku.
     *
     * @return true if a solution could be found
     */
    boolean solve();

    /**
     * Check if a digit is legal on the current board.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param nbr the number to check
     * @return true if the move is legal
     */
    boolean isLegal(int row, int col, int nbr);

    /**
     * Get the number on the board.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the number on the specified cell
     */
    int get(int row, int col);

    /**
     * Set the number on the board; numbers 1-9 are fixed values, 0 is unsolved.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param nbr the number to be set
     */
    void set(int row, int col, int nbr);

    /**
     * Clear the Sudoku board.
     */
    void clear();
}