package Draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints;
import Mains.Main;
import Schedule.AddTask;

public class DrawSchedule {
	public static void drawSchedule(Graphics G) {
		Main.g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		for (int i = 0; i<AddTask.SN; i++) {
			G.setFont(Main.QuicksandLight);
			//G.setFont(G.getFont().deriveFont(18.0f));
			//G.fillRoundRect(Main.Tasks[i][0]+5,Main.Tasks[i][1]+5, Main.Tasks[i][2], Main.Tasks[i][3], 10, 10);
			Color c = new Color(Main.Tasks[i][4],Main.Tasks[i][5],Main.Tasks[i][6]);
			G.setColor(c);
			G.fillRoundRect(Main.Tasks[i][0],Main.Tasks[i][1], Main.Tasks[i][2], Main.Tasks[i][3], 10, 10);
			c = new Color(0,0,0, Main.Tasks[i][7]);
			G.setColor(c);
			G.setFont(Main.QuicksandLight);
			if(!Main.TaskNames[i][0].equals("null")) {
				int wi = G.getFontMetrics().stringWidth(Main.TaskNames[i][0]);
				G.drawString(Main.TaskNames[i][0], (int) (Main.Tasks[i][0]+(Main.SS.width/7)-wi-10),Main.Tasks[i][1]+30);
			}

			if(!Main.TaskNames[i][2].equals("Lunch")) {
				G.drawString(Main.TaskNames[i][3], Main.Tasks[i][0]+10,Main.Tasks[i][1]+60);
			}
			String Name = Main.TaskNames[i][2].replace('_', ' ') ;
			G.drawString(Name, Main.Tasks[i][0]+10,Main.Tasks[i][1]+30);
			
			c = new Color(Main.Tasks[i][4],Main.Tasks[i][5],Main.Tasks[i][6], 255-Main.Tasks[i][7]);
			G.setColor(c);
			G.fillRoundRect(Main.Tasks[i][0],Main.Tasks[i][1], Main.Tasks[i][2], Main.Tasks[i][3], 10, 10);
			c = new Color(0,0,0, 255-Main.Tasks[i][7]);
			G.setColor(c);
			if(!Main.TaskNames[i][1].equals("null")) {
				G.drawString(Main.TaskNames[i][1], Main.Tasks[i][0]+10,Main.Tasks[i][1]+30);
			}else if(Main.TaskNames[i][2].equals("Lunch")) {
				G.drawString(Main.TaskNames[i][3], Main.Tasks[i][0]+10,Main.Tasks[i][1]+30);
			}else {
				G.drawString("No info.", Main.Tasks[i][0]+10,Main.Tasks[i][1]+30);
			}
		}
		int b = -2;
		Color c = new Color(0,0,0, 255);
		G.setColor(c);
		String a = "Monday";
		int wi =G.getFontMetrics().stringWidth(a);
		G.drawString(a, Main.SS.width/2-wi/2+b*210,70);
		b+=1;
		a = "Tuesday";
		wi =G.getFontMetrics().stringWidth(a);
		G.drawString(a, Main.SS.width/2-wi/2+b*210,70);
		b+=1;
		a = "Wednesday";
		wi =G.getFontMetrics().stringWidth(a);
		G.drawString(a, Main.SS.width/2-wi/2+b*210,70);
		b+=1;
		a = "Thursday";
		wi =G.getFontMetrics().stringWidth(a);
		G.drawString(a, Main.SS.width/2-wi/2+b*210,70);
		b+=1;
		a = "Friday";
		wi =G.getFontMetrics().stringWidth(a);
		G.drawString(a, Main.SS.width/2-wi/2+b*210,70);
		
	}
}
