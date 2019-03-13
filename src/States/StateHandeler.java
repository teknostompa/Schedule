package States;

import java.awt.Graphics;

import Draw.DrawAdmin;
import Draw.DrawList;
import Draw.DrawSchedule;
import Draw.DrawUI;
import Mains.Main;

@SuppressWarnings("hiding")
public class StateHandeler<GameStateHandeler> {
	public static void drawState(Graphics G) {
		G.drawImage(Main.img, 0, 0, Main.SS.width, Main.SS.height, Main.paintingChild);
		if(Main.CurrentState.equals("Schedule")) {
			DrawSchedule.drawSchedule(G);
		}
		else if (Main.CurrentState.equals("Admin")) {
			DrawAdmin.drawAdmin(G);
		}
		else if (Main.CurrentState.equals("List")) {
			DrawSchedule.drawSchedule(G);
			DrawList.drawList(G);
		}
		DrawUI.drawUI(G);
	}
}
