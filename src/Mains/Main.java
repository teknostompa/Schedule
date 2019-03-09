package Mains;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Assets.DownloadColors;
import Frame.initializeFrame;
import GameStates.GameStateHandeler;
import MouseHandeler.MouseCheck;
import Schedule.DownloadSchedule;
import UI.AddUIElements;

public class Main extends JPanel implements MouseListener{
	private static final long serialVersionUID = 6487229432938324648L;
	public static Dimension SS = Toolkit.getDefaultToolkit().getScreenSize();
	public static int[][][] ScreenObjects = new int[10][1000][9];
	public static int[][] Tasks = new int[1000][8];
	public static String[][] TaskNames = new String[1000][4];
	public static String[][] Colors = new String[1000][4];
	public static int NOObjects = 0;
	int yes=0;
	public static BufferedImage img;
	public static GraphicsEnvironment ge;
	public static Font QuicksandLight;
	public static Graphics2D g2d;
	public static int MPX;
	public static int MPY;
	public static String CurrentState = "Schedule";
	public static ImageObserver paintingChild = null;
	static String currentSchedule = "TE18";
	public void paint(Graphics G) {
		MouseCheck.checkAllMouseActions();
		init(G);
		GameStateHandeler.drawGameState(G);
		repaint();
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		JFrame F = new JFrame();
		DownloadColors.downloadColors();
		AddUIElements.addUIElements();
		initializeFrame.initFrame(F);
        F.add(main);
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		for(int i = 0; i < ScreenObjects[1].length;i++) {
			if(ScreenObjects[1][i][0] + ScreenObjects[9][0][8] < MPX
			&& ScreenObjects[1][i][1] < MPY
			&& ScreenObjects[1][i][0] + ScreenObjects[1][i][2] + ScreenObjects[9][0][8] > MPX
			&& ScreenObjects[1][i][1] + ScreenObjects[1][i][3] > MPY) {
				
				if(ScreenObjects[9][0][8]==0) {
					ScreenObjects[9][0][8] = 200;
					break;
				}else if(ScreenObjects[9][0][8]==200) {
					ScreenObjects[9][0][8] = 0;
					break;
				}
			}
		}
		for(int i = 0; i < ScreenObjects[2].length;i++) {
			if(ScreenObjects[2][i][0] + ScreenObjects[9][0][8] < MPX
			&& ScreenObjects[2][i][1] < MPY
			&& ScreenObjects[2][i][0] + ScreenObjects[2][i][2] + ScreenObjects[9][0][8] > MPX
			&& ScreenObjects[2][i][1] + ScreenObjects[2][i][3] > MPY) {
				if(i==6) {
					CurrentState="Admin";
					break;
				}else if(i==5) {
					CurrentState="Schedule";
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		 
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	public void init(Graphics G) {
		if(yes==0) {
		Calendar calendar = new GregorianCalendar();
		Date trialTime = new Date();   
		calendar.setTime(trialTime);    
		DownloadSchedule.GetSchedule("Assets/Schedules", currentSchedule, calendar.get(Calendar.WEEK_OF_YEAR));
		addMouseListener(this);
		Map<?, ?> desktopHints = 
			    (Map<?, ?>) Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");

			g2d = (Graphics2D) G;
			if (desktopHints != null) {
			    g2d.setRenderingHints(desktopHints);
			}
			g2d.setRenderingHint(
				    RenderingHints.KEY_ANTIALIASING,
				    RenderingHints.VALUE_ANTIALIAS_ON);
		try {
		    img = ImageIO.read(new File("bg.png"));
		} catch (IOException e) {
			
		}
		try {
			QuicksandLight = Font.createFont(Font.TRUETYPE_FONT, new File("Quicksand-Light.ttf")).deriveFont(18f);
		    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(QuicksandLight);
		} catch (FontFormatException | IOException e) {
		     //Handle exception
		}
		yes=1;
	}
	}
}
