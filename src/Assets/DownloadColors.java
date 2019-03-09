package Assets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Mains.Main;

public class DownloadColors {
	public static void downloadColors(){
		
		try(BufferedReader br = new BufferedReader(new FileReader("Assets/Colors/OGColorScheme"))){
	
			String currentLine;
			int i = 0;
			while((currentLine = br.readLine()) != null) {
				if(currentLine.isEmpty()) {
					continue;
				}
				String[] values = currentLine.trim().split(" ");
				String[] Color = values[1].trim().split(",");
				Main.Colors[i][0] = values[0];
				Main.Colors[i][1] = Color[0];
				Main.Colors[i][2] = Color[1];
				Main.Colors[i][3] = Color[2];
				i++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
