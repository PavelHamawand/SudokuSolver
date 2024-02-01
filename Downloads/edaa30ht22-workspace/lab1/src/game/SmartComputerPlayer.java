package game;

import javax.swing.JOptionPane;

public class SmartComputerPlayer extends Player{

	SmartComputerPlayer(String userId) {
		super(userId);		
	}

	
	int takePins(Board b) {
		if (b.getNoPins() > 10) {
			b.takePins(5);
			JOptionPane.showMessageDialog(null, "Datorn valde 5 pins");
			return b.getNoPins();

		}
	
		
		if (b.getNoPins() > 5 && b.getNoPins() < 10) {
			b.takePins(2);
		JOptionPane.showMessageDialog(null, "Datorn valde 2 pins");
		
	}
	
	else {
		b.takePins(1);
		JOptionPane.showMessageDialog(null, "Datorn valde 1 pins");
		
	}

	
	return b.getNoPins();
}
}
