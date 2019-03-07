package Schedule;

import java.awt.Color;

import Mains.Main;

public class AddTask {
	public static int SN = 0;
	public static void addTask(int x, int y, int w, int h, Color c, String ExtraInfo, String Room, String Subject, String T) {
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		Main.Tasks[SN][0]=x;
		Main.Tasks[SN][1]=y;
		Main.Tasks[SN][2]=w;
		Main.Tasks[SN][3]=h;
		Main.Tasks[SN][4]=r;
		Main.Tasks[SN][5]=g;
		Main.Tasks[SN][6]=b;
		Main.Tasks[SN][7]=255;
		Main.TaskNames[SN][0]=ExtraInfo;
		Main.TaskNames[SN][1]=Room;
		Main.TaskNames[SN][2]=Subject;
		Main.TaskNames[SN][3]=T;
		
		SN+=1;
	}
}
