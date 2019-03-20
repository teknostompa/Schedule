package Assets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import Mains.Main;

public class DownloadScheduleList {
	@SuppressWarnings({ "resource", "unchecked" })
	public static void DownloadList() throws IOException, ClassNotFoundException {
		InetAddress host = InetAddress.getLocalHost();//.getByName("192.168.1.232");
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
		try {
            socket = new Socket(host.getHostName(), 25565);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("schedules");
            ois = new ObjectInputStream(socket.getInputStream());
			Main.ListItems = (ArrayList<String>) ois.readObject();
            ois.close();
            oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
