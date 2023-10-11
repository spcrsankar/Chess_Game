import java.io.*;
import java.net.*;
import java.util.Vector;
class MainServer
{
	public static void main(String arg[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(1331);
		System.out.println("Server is ready");
		while(true)
		{
			Socket s=ss.accept();
			
			DataInputStream inp=new DataInputStream(System.in);

			DataInputStream  dis=new DataInputStream(s.getInputStream()); 
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeUTF("white");
			String name1 = dis.readUTF();
			Socket s1=ss.accept();

			DataInputStream  dis1=new DataInputStream(s1.getInputStream()); 
			DataOutputStream dos1=new DataOutputStream(s1.getOutputStream());
			dos1.writeUTF("black");
			String name2 = dis1.readUTF();

			ClientHandler c1=new ClientHandler(dis,dos,dis1,dos1,name1,name2);
			Thread ct1=new Thread(c1);
			ct1.start();
			
		}
	}
}
class ClientHandler extends Thread
{
	static int chance = 0;
	DataInputStream dis;
	DataOutputStream dos;
	boolean flagForConnection = false;
	DataInputStream dis1;
	DataOutputStream dos1;
	String name1,name2;
	
	ClientHandler(DataInputStream dis,DataOutputStream dos,DataInputStream dis1,DataOutputStream dos1,String name1,String name2)
	{
		this.dis=dis;
		this.dos=dos;
		this.dis1=dis1;
		this.dos1=dos1;
		this.name1 = name1;
		this.name2 = name2;
		
		System.out.println(name1 + "  vs  " + name2);
	}
		
	public void run()
	{	
		while(true)
		{
			try{
			String s=dis.readUTF();
			dos1.writeUTF(s);

			String s1[]=s.split("@",2);
			if(!s1[1].isEmpty())
				System.out.println(name1 + "  vs  " + name2 + "-----> "+ name1 + " wins");
			s=dis1.readUTF();
			dos.writeUTF(s);

			s1=s.split("@",2);
			if(!s1[1].isEmpty())
				System.out.println(name1 + "  vs  " + name2 + "-----> "+ name2 + " wins");
			
			}
			catch(Exception e){}
		}
	}
}

		