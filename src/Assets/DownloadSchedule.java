package Assets;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;

import Mains.Main;
import Schedule.AddTask;
import Schedule.GetColor;

public class DownloadSchedule {
	public static int i = 0;
	public static void GetSchedule(String Path, String CS, int Week){
		DownloadColors.downloadColors();
		try(BufferedReader br = new BufferedReader(new FileReader(Path+"/"+CS+"/"+Week))){
			
			String currentLine;
			while((currentLine = br.readLine()) != null) {
				if(currentLine.isEmpty()) {
					continue;
				}
				String[] values = currentLine.trim().split(" ");
				GetColor.getColor(values[1]);
				Color c = GetColor.co;
				String T = values[2] + ":" + values[3] + "-" + values[4] + ":" + values[5];
				AddTask.addTask(Main.SS.width/2+((Integer.valueOf(values[0])-3)*210-105), ((Integer.valueOf(values[2])*60+Integer.valueOf(values[3]))*3)/2-650, 200, ((Integer.valueOf(values[4])*60+Integer.valueOf(values[5]))*3 - (Integer.valueOf(values[2])*60+Integer.valueOf(values[3]))*3)/2 , c, values[6], values[7], values[1], T);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void download(String currentschedule, int week) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();//.getByName("192.168.1.232");
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        boolean breakIt = false;
		DownloadColors.downloadColors();
		int done1 = 0;
        	try {
            socket = new Socket(host.getHostName(), 25565);
            oos = new ObjectOutputStream(socket.getOutputStream());
            //System.out.println("Sending request to Socket Server");
            if(i==100)oos.writeObject("exit");
            else oos.writeObject(i+" "+currentschedule+" "+week);
            ois = new ObjectInputStream(socket.getInputStream());
            
            ArrayList<String> message = (ArrayList<String>) ois.readObject();
            //System.out.println(message);
            String[] values = {"yes"};
            if(message.get(0).equals("end")) {
            	Main.done=1;
            	done1 = 1;
            }
            if(done1==0) {
			GetColor.getColor(message.get(1));
			Color c = GetColor.co;
			String T = message.get(2) + ":" + message.get(3) + "-" + message.get(4) + ":" + message.get(5);
			AddTask.addTask(Main.SS.width/2+((Integer.valueOf(message.get(0))-3)*210-105),
					((Integer.valueOf(message.get(2))*60+Integer.valueOf(message.get(3)))*3)/2-650,
					200,
					((Integer.valueOf(message.get(4))*60+Integer.valueOf(message.get(5)))*3 - (Integer.valueOf(message.get(2))*60+Integer.valueOf(message.get(3)))*3)/2 ,
					c,
					message.get(6),
					message.get(7),
					message.get(1),
					T);
            ois.close();
            oos.close();
            Thread.sleep(10);
            }
            if(message.equals("end")) {
                Main.done=1;
            }
            }catch (EOFException | SocketException e) {
				e.printStackTrace();
			}
        	i++;
    }
}
