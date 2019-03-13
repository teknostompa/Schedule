package UI;

import java.awt.Color;

import Mains.Main;
import Objects.AddObject;

public class AddUIElements {
	public static void addUIElements(){
		AddObject.addObject(0 ,-200 , 0, 200, Main.SS.height, new Color(49, 48, 48));
		AddObject.addObject(1, 10, 10, 30, 25, new Color(0,0,0,0));
		AddObject.addObject(1, 10, 10, 30, 3, new Color(0,0,0));
		AddObject.addObject(1, 10, 20, 30, 3, new Color(0,0,0));
		AddObject.addObject(1, 10, 30, 30, 3, new Color(0,0,0));
		AddObject.addObject(2 ,-200 , 70, 200, 50, new Color(200, 200, 48));
		AddObject.addObject(2 ,-200 , 130, 200, 50, new Color(200, 200, 48));
		AddObject.addObject(3 ,Main.SS.width/2-100 , 5, 200, 40, new Color(255, 255, 255));
	}
}
