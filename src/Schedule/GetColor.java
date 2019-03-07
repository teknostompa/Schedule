package Schedule;

import java.awt.Color;

public class GetColor {
	static Color co;
	public static void getColor(String c){
		if(c.equals("Svenska")) {
			co = new Color(149,149,255);
		}else if(c.equals("Matte")) {
			co = new Color(255,128,192);
		}else if(c.equals("Kemi")) {
			co = new Color(196,121,173);
		}else if(c.equals("Historia")) {
			co = new Color(128,128,255);
		}else if(c.equals("Språk")) {
			co = new Color(255,255,128);
		}else if(c.equals("Teknik")) {
			co = new Color(255,255,128);
		}else if(c.equals("Idrott")||c.equals("Idrott_Specialicering")) {
			co = new Color(159,223,187);
		}else if(c.equals("Mentors_Tid")) {
			co = new Color(4,189,251);
		}else if(c.equals("Lunch")) {
			co = new Color(204,204,204);
		}else if(c.equals("Engelska")) {
			co = new Color(255,170,170);
		}else{
			co = new Color(255,0,255);
		}
	}
	
}
