package AddForm;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Mains.Main;
import Test.SpringUtilities;

public class FormObjects {
	public static void addFormObjects() {
		String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		for (int i = 0; i < numPairs; i++) {
		    JLabel l = new JLabel(labels[i], JLabel.TRAILING);
		    Main.p.add(l);
		    JTextField textField = new JTextField(10);
		    l.setLabelFor(textField);
		    Main.p.add(textField);
		}

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(Main.p,
		                                numPairs, 2,
		                                100, 100,
		                                6, 6); 
	}
}
