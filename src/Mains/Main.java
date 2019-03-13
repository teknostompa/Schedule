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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import AddForm.FormObjects;
import Assets.DownloadColors;
import Assets.DownloadSchedule;
import Assets.DownloadScheduleList;
import Frame.initializeFrame;
import MouseHandeler.MouseCheck;
import Schedule.AddTask;
import States.StateHandeler;
import UI.AddUIElements;

public class Main extends JPanel implements MouseListener{
	private static final long serialVersionUID = 6487229432938324648L;
	public static Dimension SS = Toolkit.getDefaultToolkit().getScreenSize();
	public static int[][][] ScreenObjects = new int[10][1000][9];
	public static int[][] AdminForm = new int[1000][9];
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
	public static JFrame F;
	public static JPanel p;
	public static int done = 0;
	public static ArrayList<String> ListItems;
	public void paint(Graphics G) {
		MouseCheck.checkAllMouseActions();
		init(G);
		loadSchedule();
		StateHandeler.drawState(G);
		repaint();
	}
	
	public static void main(String[] args) {
		try {
			DownloadScheduleList.DownloadList();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		Main main = new Main();
		F = new JFrame();
		p = new JPanel(new SpringLayout());
		DownloadColors.downloadColors();
		AddUIElements.addUIElements();
		FormObjects.addFormObjects();
		initializeFrame.initFrame(F);
        F.add(main);
		//F.add(p);
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
				if(i==0) {
					CurrentState="Admin";
					break;
				}else if(i==1) {
					CurrentState="Schedule";
				}
			}
		}
		if(CurrentState.equals("List")
//			&& MPX>SS.width-100
//			&& MPX<SS.width+100
			&& MPY>45) {
			int tempY = MPY-45;
			tempY/=40;
			if(tempY<ListItems.size()) {
				currentSchedule=ListItems.get(tempY);
				System.out.println(currentSchedule);
				done=0;
				DownloadSchedule.i=0;
				Tasks = new int[1000][8];
				TaskNames = new String[1000][4];
				AddTask.SN=0;
			}
		}
		if(ScreenObjects[3][0][0] < MPX
			&& ScreenObjects[3][0][1] < MPY
			&& ScreenObjects[3][0][0] + ScreenObjects[3][0][2] > MPX
			&& ScreenObjects[3][0][1] + ScreenObjects[3][0][3] > MPY
			&& CurrentState.equals("Schedule") || CurrentState.equals("List")) {
			if(CurrentState=="List") {
				CurrentState="Schedule";
			}else {
				CurrentState="List";	
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
		//DownloadSchedule.GetSchedule("Assets/Schedules", currentSchedule, calendar.get(Calendar.WEEK_OF_YEAR));
		
//		try {
//			DownloadSchedule.download();
//		} catch (ClassNotFoundException | IOException | InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
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
	public static void loadSchedule() {
		if(done==0) {
			Calendar calendar = new GregorianCalendar();
			Date trialTime = new Date();   
			calendar.setTime(trialTime);    
			try {
				DownloadSchedule.download(currentSchedule, calendar.get(Calendar.WEEK_OF_YEAR));
			} catch (ClassNotFoundException | IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
