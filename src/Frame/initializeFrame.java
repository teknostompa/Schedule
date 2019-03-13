package Frame;

import javax.swing.JFrame;

import Mains.Main;
import MouseHandeler.Hover;

public class initializeFrame {
	public static JFrame initFrame(JFrame F) {
		Hover h = new Hover();
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
