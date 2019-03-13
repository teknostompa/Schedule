package Objects;

import java.awt.Color;

import Mains.Main;

public class AddObject {
	public static int[] SOL = new int[100];
	public static void addObject(int n, int x, int y, int w, int h, Color c) {
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		int a = c.getAlpha();
		Main.ScreenObjects[n][SOL[n]][0]=x;
		Main.ScreenObjects[n][SOL[n]][1]=y;
		Main.ScreenObjects[n][SOL[n]][2]=w;
		Main.ScreenObjects[n][SOL[n]][3]=h;
		Main.ScreenObjects[n][SOL[n]][4]=r;
		Main.ScreenObjects[n][SOL[n]][5]=g;
		Main.ScreenObjects[n][SOL[n]][6]=b;
		Main.ScreenObjects[n][SOL[n]][7]=a;
		SOL[n]+=1;
	}
}
