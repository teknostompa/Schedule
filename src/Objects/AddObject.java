package Objects;

import java.awt.Color;

import Mains.Main;

public class AddObject {
	public static int SOL = 0;
	public static void addObject(int x, int y, int w, int h, Color c) {
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		Main.ScreenObjects[SOL][0]=x;
		Main.ScreenObjects[SOL][1]=y;
		Main.ScreenObjects[SOL][2]=w;
		Main.ScreenObjects[SOL][3]=h;
		Main.ScreenObjects[SOL][4]=r;
		Main.ScreenObjects[SOL][5]=g;
		Main.ScreenObjects[SOL][6]=b;
		SOL+=1;
	}
}
