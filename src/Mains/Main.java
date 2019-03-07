package Mains;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Objects.AddObject;
import Schedule.AddTask;
import Schedule.DownloadSchedule;
import Schedule.DrawSchedule;

public class Main extends JPanel{
	private static final long serialVersionUID = 6487229432938324648L;
	public static Dimension SS = Toolkit.getDefaultToolkit().getScreenSize();
	public static int[][] ScreenObjects = new int[1000][7];
	public static int[][] Tasks = new int[1000][7];
	public static String[][] TaskNames = new String[1000][4];
	public static int NOObjects = 0;
	int yes=0;
	BufferedImage img;
	public static Font QuicksandLight;
	public void paint(Graphics G) {
		if(yes==0) {
			try {
			    img = ImageIO.read(new File("bg.jpg"));
			} catch (IOException e) {
				
			}
		}
		
		ImageObserver paintingChild = null;
		G.drawImage(img, 0, 0, SS.width, SS.height, paintingChild);
		DrawSchedule.drawSchedule(G);
		yes=1;
		for(int i = 0; i < AddObject.SOL; i++) {
			G.fillRect(ScreenObjects[i][0],ScreenObjects[i][1],ScreenObjects[i][2], ScreenObjects[i][3]);
		}
	}
	
	public static void main(String[] args) {
		try {
			QuicksandLight = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\custom_font.ttf")).deriveFont(Font.BOLD,24f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(QuicksandLight);
		} catch (FontFormatException | IOException e) {
		     //Handle exception
		}
		Main main = new Main();
		JFrame F = new JFrame();
		F.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		F.setUndecorated(true);
		DownloadSchedule.GetSchedule("Schedules/TE18/", 10);
		//AddObject.addObject(0, 0, 160, SS.width, new Color(200,100,0));
		F.setSize(SS);
		F.setTitle("Schedule");
        F.setVisible(true);
        F.setResizable(true);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.add(main);
	}
	
	

}
