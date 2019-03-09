package MouseHandeler;

import Mains.Main;
import Schedule.AddTask;

	public class Hover {

	public static void hoverOverTask() {
		for(int i = 0; i < AddTask.SN; i++) {
			if(Main.MPX > Main.Tasks[i][0]
			&& Main.MPY > Main.Tasks[i][1]
			&& Main.MPX < Main.Tasks[i][0]+Main.Tasks[i][2]
			&& Main.MPY < Main.Tasks[i][1]+Main.Tasks[i][3]) {
				if(Main.Tasks[i][7] > 0) {
					Main.Tasks[i][7]-=15;
				}
			}else {
				if(Main.Tasks[i][7] < 255) {
					Main.Tasks[i][7]+=15;
				}
			}
		}
	}
	
}
