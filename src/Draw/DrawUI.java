package Draw;

import java.awt.Color;
import java.awt.Graphics;

import Mains.Main;
import Objects.AddObject;

public class DrawUI {
	public static void drawUI(Graphics G){
		for(int j = 0; j < Main.ScreenObjects.length; j++) {
			for(int i = 0; i < AddObject.SOL[j]; i++) {
				Color c = new Color(Main.ScreenObjects[j][i][4],Main.ScreenObjects[j][i][5],Main.ScreenObjects[j][i][6],Main.ScreenObjects[j][i][7]);
				G.setColor(c);
				if(j!=3) {
					G.fillRect(Main.ScreenObjects[j][i][0] + Main.ScreenObjects[9][0][8],Main.ScreenObjects[j][i][1],Main.ScreenObjects[j][i][2], Main.ScreenObjects[j][i][3]);
				}else if(Main.CurrentState.equals("Schedule") || Main.CurrentState.equals("List")){
					G.fillRect(Main.ScreenObjects[j][i][0],Main.ScreenObjects[j][i][1],Main.ScreenObjects[j][i][2], Main.ScreenObjects[j][i][3]);
					G.setColor(new Color(0));
					G.setFont(G.getFont().deriveFont(24.0f));
					G.drawString("Schedules", Main.SS.width/2-G.getFontMetrics().stringWidth("Schedules")/2, 33);
				}
			}
		}
		G.setColor(new Color(255,255,255));
		G.setFont(G.getFont().deriveFont(24.0f));
		G.drawString("Admin Panel",-100+Main.ScreenObjects[9][0][8]- G.getFontMetrics().stringWidth("Admin Panel")/2,100);
		G.drawString("Schedules",-100+Main.ScreenObjects[9][0][8]- G.getFontMetrics().stringWidth("Schedules")/2,160);

	}
}