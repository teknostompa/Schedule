package Draw;

import java.awt.Color;
import java.awt.Graphics;

import Mains.Main;

public class DrawAdmin {
	public static void drawAdmin(Graphics G) {
		G.setColor(new Color(Main.AdminForm[1][4],Main.AdminForm[1][5],Main.AdminForm[1][6]));
		G.fillRoundRect(Main.AdminForm[1][0], Main.AdminForm[1][1], Main.AdminForm[1][2], Main.AdminForm[1][3], 20, 20);
		G.setColor(new Color(Main.AdminForm[0][4],Main.AdminForm[0][5],Main.AdminForm[0][6]));
		G.fillRoundRect(Main.AdminForm[0][0], Main.AdminForm[0][1], Main.AdminForm[0][2], Main.AdminForm[0][3], 20, 20);
	}
}
