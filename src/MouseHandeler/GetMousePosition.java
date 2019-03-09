package MouseHandeler;

import java.awt.MouseInfo;
import java.awt.Point;

import Mains.Main;

public class GetMousePosition {

	public static void GMP(){
		Point MP = MouseInfo.getPointerInfo().getLocation();
		Main.MPX = MP.x;
		Main.MPY = MP.y;
	}
}
