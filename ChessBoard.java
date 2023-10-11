import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.Applet;
import javax.swing.ImageIcon;
class ChessBoard extends Frame implements ActionListener,MouseListener
{
	static int occupied=0;
	static int chance;
	int x,y,x1=0,y1=0;
	TextField t1,t2;
	String str,coinColor;
	static String checking=" ",whoWins="";
	int ethuku=1;
	int valueForThis;
	String whichcolor="";
	ChessBoard(String coinColor)  throws Exception 
	{
		setVisible(true);
		setLayout(null);
		this.coinColor=coinColor;
		System.out.println("coin color is "+coinColor);
		if(coinColor.equals("white"))
		{
			setTitle("chess board white");
			chance=99;							// whose chance is this if its odd white will play else black
			valueForThis=0;
			whichcolor="black";
		}
		else
		{
			whichcolor="white";
			setTitle("chess board black");
			// System.out.println("dfsgh");
			chance=99;
			valueForThis=1;
			Client.receive();
			chance=100;
		}
		
		
		t1=new TextField(10);
		t1.setBounds(100,730,80,20);
		add(t1);

		t2=new TextField(10);
		t2.setBounds(100,755,80,20);
		add(t2);

		Button b=new Button("submit");
		b.setBounds(100,780,80,20);
		// b.setColor = "green"
		add(b);
		b.addActionListener(this);

		addMouseListener(this);
		repaint();
	}
	
	public void mousePressed(MouseEvent e)
	{
		int x1=e.getX();
		int y1=e.getY();
		x1=x1/80-1;
		y1=y1/80-1;
		if(x1<8 && y1<8)
		{
			if(ethuku%2==1)
			{
				BoardArray.peakvalue=0;
				t1.setText(String.valueOf(y1*10+x1));
				if(BoardArray.a[y1][x1]==1 || BoardArray.a[y1][x1]==11)
					BoardArray.king(y1,x1,-101);
				else if(BoardArray.a[y1][x1]==2 || BoardArray.a[y1][x1]==12)
					BoardArray.queen(y1,x1,-101);
				else if(BoardArray.a[y1][x1]==3 || BoardArray.a[y1][x1]==13)
					BoardArray.bisaph(y1,x1,-101);
				else if(BoardArray.a[y1][x1]==4 || BoardArray.a[y1][x1]==14)
					BoardArray.knight(y1,x1,-101);
				else if(BoardArray.a[y1][x1]==5 || BoardArray.a[y1][x1]==15)
					BoardArray.rook(y1,x1,-101);
				else if(BoardArray.a[y1][x1]==6 || BoardArray.a[y1][x1]==16)
					BoardArray.chip(y1,x1,-101);	
				repaint();
				ethuku--;
			}
			else
			{
				t2.setText(String.valueOf(y1*10+x1));
				ethuku++;	
			}
		}
		repaint();
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent ee){}
	public void mouseExited(MouseEvent e){}

		
	public void actionPerformed(ActionEvent e)
	{
		x=Integer.parseInt(t1.getText());
		y=Integer.parseInt(t2.getText());

		if(chance%2==1)
		{
			if(BoardArray.a[x/10][x%10]>0 && BoardArray.a[x/10][x%10]<=6)
			{
				BoardArray.white((x/10),(x%10),y);
			}
			else
			{
				chance--;
			}
		}
		else
		{
			if(BoardArray.a[x/10][x%10]>10 && BoardArray.a[x/10][x%10]<=16)
			{
				BoardArray.black((x/10),(x%10),y);
			}
			else
			{
				chance--;
			}	
		}
		chance++;
		// System.out.println(chance);
		if(chance%2==valueForThis)		//value for this helps to identify its white or black
		{
			occupied=1;
			repaint();
		}
	}
	public void paint(Graphics g)
	{
		int i=0,j=0;	
		
		Font f=new Font("Serif",Font.BOLD,30);
		g.setFont(f);
		
		g.drawString(whoWins,1000,200);

		for(i=0;i<8;i++)
		{
			g.drawString(String.valueOf(i+1),((i+1)*80)+40,50);
			for(j=0;j<8;j++)
			{
				if(j==0)
					g.drawString(String.valueOf((char)('a'+i)),50,((i+1)*80)+50);
				if((i+j)%2==0)
					g.drawRect((i+1)*80,(j+1)*80,80,80);
				else 
					g.fillRect((i+1)*80,(j+1)*80,80,80);
			}
		}

		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{		
				if(BoardArray.a[j][i]==1)
				{		
						g.drawImage(new ImageIcon("coins/wking.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==2)
				{
					g.drawImage(new ImageIcon("coins/wqueen.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==3)
				{
					g.drawImage(new ImageIcon("coins/wbishop.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);
				}	
				else if(BoardArray.a[j][i]==4)
				{
					g.drawImage(new ImageIcon("coins/wknight.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);
				}	
				else if(BoardArray.a[j][i]==5)
				{
					g.drawImage(new ImageIcon("coins/wrook.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==6)
				{
					g.drawImage(new ImageIcon("coins/wchip.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==11)
				{
					g.drawImage(new ImageIcon("coins/bking.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==13)
				{
					g.drawImage(new ImageIcon("coins/bbishop.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==14)
				{
					g.drawImage(new ImageIcon("coins/bknight.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==15)
				{
					g.drawImage(new ImageIcon("coins/brook.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==16)
				{
					g.drawImage(new ImageIcon("coins/bchip.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);	
				}	
				else if(BoardArray.a[j][i]==12)
				{
					g.drawImage(new ImageIcon("coins/bqueen.png").getImage(),(i+1)*80,(j+1)*80,80,80,this);
				}	
			}
		}
		for(j=1;j<=9;j++)
		{
				g.drawLine(80,j*80,720,j*80);
				g.drawLine(j*80,80,j*80,720);
		}
		g.setColor(Color.red);
		if(chance%2==1)
		{
			g.drawString("chance for white",200,800);
		}
		else
		{
			g.drawString("chance for block",200,800);
		}
		if(BoardArray.inCheck==1)
		{
			g.drawString("Block in check "+checking,200,750);
		}
		else if(BoardArray.inCheck==2)
		{
			g.drawString("white in check"+checking,200,750);
		}
		else
		{
			g.drawString("continue the game",200,750);
		}
		if(BoardArray.illegalmove==1)
		{
			g.drawString("illegal move",350,820);
			BoardArray.illegalmove=0;
		}
		
		for(int b=0;b<BoardArray.peakvalue;b++)
		{
			int x=BoardArray.search[b];
			g.setColor(Color.red);
			g.drawLine(((x%10)+1)*80,((x/10)+1)*80,((x%10)+1)*80+80,(((x/10)+1)*80));
			g.drawLine(((x%10)+1)*80,((x/10)+1)*80,((x%10)+1)*80,(((x/10)+1)*80)+80);
			g.drawLine(((x%10)+1)*80,((x/10)+1)*80+80,((x%10)+1)*80+80,((x/10)+1)*80+80);
			g.drawLine(((x%10)+1)*80+80,((x/10)+1)*80,((x%10)+1)*80+80,((x/10)+1)*80+80);
			g.fillOval((x%10+1)*80+35,(x/10+1)*80+35,10,10);
		}
		
		if(occupied==1)
		{	
			String t2val="",t3val="";
			try{
			if(BoardArray.finish==0)
			{
				//t3val="nothing";
				whoWins=t3val;
				
			}
			else if(BoardArray.finish==1)
			{
			
				//t3val=whichcolor+" in check";
				whoWins=t3val;
				
			}
			else
			{
				t3val=coinColor+"wins";
				whoWins=t3val;
				
			}
			if(Integer.parseInt(t2.getText())/10==0)
			{
				t2val="0"+t2.getText();
			}
			else
			{
				t2val=t2.getText();
			}
			g.drawString(whoWins,350,820);
			Client.send(t1.getText()+t2val+"@"+t3val);
			
			}
			catch(Exception eqwa){
				System.out.println("error occurs1" + eqwa);
			}
			
			
			occupied=0;
			repaint();
		}
	}			
}