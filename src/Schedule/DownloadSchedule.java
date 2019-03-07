package Schedule;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Mains.Main;

public class DownloadSchedule {
	public static void GetSchedule(String Path, int Week){
		try(BufferedReader br = new BufferedReader(new FileReader(Path+Week))){

			String currentLine;
			while((currentLine = br.readLine()) != null) {
				if(currentLine.isEmpty()) {
					continue;
				}
				String[] values = currentLine.trim().split(" ");
				GetColor.getColor(values[1]);
				Color c = GetColor.co;
				String T = values[2] + ":" + values[3] + "-" + values[4] + ":" + values[5];
				AddTask.addTask(Main.SS.width/2+((Integer.valueOf(values[0])-3)*210-Main.SS.width/14), ((Integer.valueOf(values[2])*60+Integer.valueOf(values[3]))*3)/2-650, 200, ((Integer.valueOf(values[4])*60+Integer.valueOf(values[5]))*3 - (Integer.valueOf(values[2])*60+Integer.valueOf(values[3]))*3)/2 , c, values[6], values[7], values[1], T);
			}
		}
		catch(IOException e) {}
	}
}
