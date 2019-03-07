package Schedule;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.TextAttribute;

import javax.swing.text.AttributeSet.FontAttribute;

import Mains.Main;

public class DrawSchedule {
	public static void drawSchedule(Graphics G) {
		for (int i = 0; i<AddTask.SN; i++) {
			Color c = new Color(0,0,0,100);
			G.setColor(c);
			G.setFont(Main.QuicksandLight);
			//G.setFont(G.getFont().deriveFont(18.0f));
			//G.fillRoundRect(Main.Tasks[i][0]+5,Main.Tasks[i][1]+5, Main.Tasks[i][2], Main.Tasks[i][3], 10, 10);
			c = new Color(Main.Tasks[i][4],Main.Tasks[i][5],Main.Tasks[i][6]);
			G.setColor(c);
			G.fillRoundRect(Main.Tasks[i][0],Main.Tasks[i][1], Main.Tasks[i][2], Main.Tasks[i][3], 10, 10);
			c = new Color(0,0,0);
			G.setFont(Main.QuicksandLight);
			G.setColor(c);
			if(!Main.TaskNames[i][0].equals("null")) {
				int wi = G.getFontMetrics().stringWidth(Main.TaskNames[i][0]);
				G.drawString(Main.TaskNames[i][0], Main.Tasks[i][0]+200-wi-10,Main.Tasks[i][1]+30);
			}

			if(!Main.TaskNames[i][2].equals("Lunch")) {
				G.setFont(Main.QuicksandLight);
				G.drawString(Main.TaskNames[i][3], Main.Tasks[i][0]+10,Main.Tasks[i][1]+60);
			}
			String Name = Main.TaskNames[i][2].replace('_', ' ') ;
			G.drawString(Name, Main.Tasks[i][0]+10,Main.Tasks[i][1]+30);
		}
	}
}
