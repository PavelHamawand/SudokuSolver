package s;

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
     * 
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
    	 // Kontrollerar om brädet har rätt storlek
        if (board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("Invalid board size. Must be 9x9.");
        }
        // Tilldelar brädet med de angivna värdena
        this.board = board.clone();
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
        // Basfall: Om vi har nått slutet av pusslet finns en lösning
        if (row == 9) {
            return true;
        }

        // Beräkna nästa rad- och kolumnindex
        
        /*int nextRow;
        if (col == 8) {
            nextRow = row + 1;
        } else {
            nextRow = row;
        }*/
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col + 1) % 9;

        // Om den aktuella cellen redan är ifylld, gå till nästa cell
        if (get(row, col) != 0) {
            return solve(nextRow, nextCol);
        }

        // Prova att placera siffror 1 till 9 i den aktuella cellen
        for (int num = 1; num <= 9; num++) {
            if (isLegal(row, col, num)) {
                // Om att placera num är ett giltigt drag, sätt cellvärdet
                set(row, col, num);

                // Försök rekursivt lösa pusslet med den uppdaterade tavlan
                if (solve(nextRow, nextCol)) {
                    return true;  // En lösning hittades
                }

                // Om det aktuella draget inte leder till en lösning, backa
                set(row, col, 0);
            }
        }

        // Inget giltigt drag hittades, backa till den föregående cellen
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
            // Kontrollera raden och kolumnen
        for (int i = 0; i < 9; i++) {
            if (get(row, i) == num || get(i, col) == num) {
                return false;  // Siffran finns redan i raden eller kolumnen
            }
        }

        // Kontrollera 3x3-regionen
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (get(startRow + i, startCol + j) == num) {
                    return false;  // Siffran finns redan i regionen
                }
            }
        }

        return true;  // siffran är lagligreturn isValid(row, col, num);
    }
    
   
   // private boolean isValid(int row, int col, int num) {
    
   // }



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
