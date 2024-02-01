package s;

import javax.swing.SwingUtilities;

public class SudokuApplication {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new SudokuGUI();
	            }
	        });
	}

}