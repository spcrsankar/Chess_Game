/** chat between server and client */
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.Applet;
import javax.swing.ImageIcon;

import java.io.*;
import java.net.*;

public class Client
{
	static DataInputStream dis;
	static DataOutputStream dos;
	static boolean justflag=true;
	public static void main(String args[]) throws Exception
	{
		DataInputStream inp=new DataInputStream(System.in);
		System.out.println("Enter your name ");
		// inp.readLine();
		String name = inp.readLine();
		// InetAddress ip=InetAddress.getLocalHost();	// IPv4 Address. . . . . . . . . . . : 192.168.43.198 using ip config we can get lan address
		System.out.println("Enter IP address of the server");
		String ip = inp.readLine();
		Socket s=new Socket(ip,1331); 
		dis=new DataInputStream(s.getInputStream()); 
		dos=new DataOutputStream(s.getOutputStream());
		String color=dis.readUTF();
		dos.writeUTF(name);
		System.out.println(name + " you are" + color);
		ChessBoard c=new ChessBoard(color);
		
		//dis.close();
		//s.close();
	}
	
	static public void send(String str) throws Exception
	{
		dos.writeUTF(str);
		ChessBoard.chance++;
		receive();

	}
	static public void receive()  throws Exception
	{
		String strs=dis.readUTF();
		
		String s1[]=strs.split("@",2);
		int fullsize=Integer.parseInt(s1[0]);	
		ChessBoard.whoWins=s1[1];
		int fromposition=fullsize/100;
		int toposition=fullsize%100;
		BoardArray.a[toposition/10][toposition%10]=BoardArray.a[fromposition/10][fromposition%10];
		System.out.println(fromposition+"  "+toposition);
		BoardArray.a[fromposition/10][fromposition%10]=0;
		ChessBoard.occupied=1;
		// System.out.println("From server: "+strs);
	}		
}




