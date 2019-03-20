package Schedule;

import java.awt.Color;

import Mains.Main;

public class GetColor {
	public static Color co;
	public static void getColor(String c){
		for(int i = 0; i < Main.Colors.length; i++) {
			if(c.equals(Main.Colors[i][0])) {
				co = new Color(Integer.parseInt(Main.Colors[i][1]),Integer.parseInt(Main.Colors[i][2]),Integer.parseInt(Main.Colors[i][3]),255);
				break;
			} else {	
				co = new Color(200,200,200);
			}
		}
	}
	
}
