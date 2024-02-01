package game;

import javax.swing.JOptionPane;

public class TakePinsGame {

	public static void main(String[] args) {
		
		Board board = new Board();
		String s = JOptionPane.showInputDialog("Ange dit namn:");
		int n = UserInterface.askForSetup(JOptionPane.showInputDialog("Hur många pins vill du spela med?"));
		board.setUp(n);
		//Ber om spelares namn och hur många pins spelet ska innehålla, sedan skapas en bräda med det antalet pins.
		
		
		Player hp = new HumanPlayer(s);
		Player cp = new ComputerPlayer("Dator");
		
		
		
		while (board.getNoPins() > 0 ){
			
			if(board.getNoPins()>0) {

				hp.takePins(board);
				if(board.getNoPins() == 0) {
					JOptionPane.showMessageDialog(null, hp.getUserId() + " har vunnit!");
					break;
					
				}
			}
		
			if(board.getNoPins()>0) {
				cp.takePins(board);
				JOptionPane.showMessageDialog(null, "Antal pins kvar i spelet: " + board.getNoPins());
				if(board.getNoPins() == 0) {
					JOptionPane.showMessageDialog(null, cp.getUserId() + " har vunnit!");

					break;
					
				}
			}

		}

	}

}
		
		
