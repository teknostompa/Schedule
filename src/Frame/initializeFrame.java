package Frame;

import javax.swing.JFrame;

import Mains.Main;

public class initializeFrame {
	public static JFrame initFrame(JFrame F) {
		F.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		F.setUndecorated(true);
		F.setSize(Main.SS);
		F.setTitle("Schedule");
        F.setVisible(true);
        F.setResizable(true);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return F;
	}
}
