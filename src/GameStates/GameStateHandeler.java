package GameStates;

import java.awt.Graphics;

import Draw.DrawSchedule;
import Draw.DrawUI;
import Mains.Main;

@SuppressWarnings("hiding")
public class GameStateHandeler<GameStateHandeler> {
	public static void drawGameState(Graphics G) {
		G.drawImage(Main.img, 0, 0, Main.SS.width, Main.SS.height, Main.paintingChild);
		if(Main.CurrentState.equals("Schedule")) {
			DrawSchedule.drawSchedule(G);
		}
		DrawUI.drawUI(G);
	}
}
