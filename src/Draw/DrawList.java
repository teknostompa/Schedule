package Draw;

import java.awt.Color;
import java.awt.Graphics;

import Mains.Main;

public class DrawList {
	public static void drawList(Graphics G) {
		for(int i = 0; i < Main.ListItems.size();i++) {
			G.setColor(new Color(255,255,255));
			G.fillRect(Main.SS.width/2-100, 45+(i*40), 200, 40);
			G.setColor(new Color(0,0,0));
			G.drawRect(Main.SS.width/2-100, 45+(i*40), 200, 40);
		}
	}
}
