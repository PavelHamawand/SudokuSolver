package s;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SudokuGUI extends JFrame {
    private SudokuSolver sudokuSolver;
    private JTextField[][] sudokuGrid;

    // Konstruktor för att skapa SudokuGUI-fönstret
    public SudokuGUI() {
        // Skapa en ny instans av SudokuSolver
        sudokuSolver = new Sudoku();

        // Skapa rutnätet
        sudokuGrid = new JTextField[9][9];

        // Skapa och konfigurera fönstret
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 9));

        // Lägg till textfält i rutnätet
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sudokuGrid[row][col] = new JTextField(1);
                add(sudokuGrid[row][col]);
                
                // Ändra bakgrundsfärg för varannan region
                if ((row / 3 + col / 3) % 2 == 1) {
                    sudokuGrid[row][col].setBackground(Color.LIGHT_GRAY);
                }       
            }
        }

        // Skapa Solve-knappen
        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveSudoku();
            }
        });

        // Skapa Clear-knappen
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearGrid();
            }
        });

        // Lägg till knapparna
        add(solveButton);
        add(clearButton);

        // Konfigurera fönstret
        pack();
        setLocationRelativeTo(null); // Centrera fönstret på skärmen
        setVisible(true);
    }

    // Metod för att lösa Sudoku-pusslet
    private void solveSudoku() {
        // Hämta värden från textfälten och sätt dem i SudokuSolver
        int[][] board = new int[9][9];
        Set<Integer>[] rowSet = new Set[9];
        Set<Integer>[] colSet = new Set[9];
        Set<Integer>[] regionSet = new Set[9];

        // Skapa set för varje rad, kolumn och region
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            regionSet[i] = new HashSet<>();
        }

        // Fyll i brädet och kontrollera inmatningen
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String value = sudokuGrid[row][col].getText();
                if (!value.isEmpty()) {
                    try {
                        int num = Integer.parseInt(value);
                        if (num < 1 || num > 9) {
                            // Visa felmeddelande om siffran är utanför intervallet
                            JOptionPane.showMessageDialog(this, "Ange siffror mellan 1 och 9.", "Felaktig inmatning",
                                    JOptionPane.ERROR_MESSAGE);
                            //clearGrid();
                            return;
                        }

                        // Kontrollera om siffran redan finns i rad, kolumn eller region
                        if (!rowSet[row].add(num) || !colSet[col].add(num) || !regionSet[row / 3 * 3 + col / 3].add(num)) {
                            // Visa felmeddelande om siffran redan finns
                            JOptionPane.showMessageDialog(this, "Siffran " + num + " finns redan i rad, kolumn eller region.", "Felaktig inmatning",
                                    JOptionPane.ERROR_MESSAGE);
                            //clearGrid();
                            return;
                        }

                        board[row][col] = num;
                    } catch (NumberFormatException ex) {
                        // Visa felmeddelande om det inte är en giltig siffra
                        JOptionPane.showMessageDialog(this, "Ange en giltig siffra.", "Felaktig inmatning",
                                JOptionPane.ERROR_MESSAGE);
                        //clearGrid();
                        return;
                    }
                } else {
                    board[row][col] = 0;
                }
            }
        }

        // Sätt brädet i SudokuSolver
        sudokuSolver.setBoard(board);

        // Försök lösa Sudoku
        if (sudokuSolver.solve()) {
            // Hämta lösningen från SudokuSolver och visa den i textfälten
            int[][] solution = sudokuSolver.getBoard();
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    sudokuGrid[row][col].setText(String.valueOf(solution[row][col]));
                }
            }
        } else {
            // Visa meddelande om ingen lösning hittades
            JOptionPane.showMessageDialog(this, "Ingen lösning hittades.", "Fel", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metod för att rensa rutnätet
    private void clearGrid() {
        // Töm alla textfält i rutnätet
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sudokuGrid[row][col].setText("");
            }
        }
        sudokuSolver.clear();
    }
}