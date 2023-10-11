class BoardArray
{
	public static int a[][]={{5,4,3,2,1,3,4,5},{6,6,6,6,6,6,6,6},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{16,16,16,16,16,16,16,16},{15,14,13,12,11,13,14,15}};
	static int w,t,peak,peakvalue=0,o,o1;
	static int search[]=new int[100];
	static int q,noof=0;
	static int findking[]=new int[10];
	static int inCheck=0;
	static int alreadin=0;
	static int illegalmove=0;
	static int finish=0;
	static void white(int a1,int b1,int c1)
	{
		ChessBoard.checking=" ";
		if(a[a1][b1]==6)
		{
			chip(a1,b1,c1);
		}
		else if(a[a1][b1]==1)
		{
			king(a1,b1,c1);
		}
		else if(a[a1][b1]==2)
		{
			queen(a1,b1,c1);
		}
		else if(a[a1][b1]==4)
		{
			knight(a1,b1,c1);
		}
		else if(a[a1][b1]==3)
		{
			bisaph(a1,b1,c1);
		}
		else if(a[a1][b1]==5)
		{
			rook(a1,b1,c1);
		}
		if(ChessBoard.chance%2==0)
		{
			illegalmove=1;
			ChessBoard.chance--;
			return;
		}
		int checker =checkwhite();
		if(1==checker || 2==checker)
		{
			illegalmove=1;
			System.out.println("illegal move");
			a[a1][b1]=a[c1/10][c1%10];
			a[c1/10][c1%10]=alreadin;    // alreadin -- first i change the position without concern about illegal move so to go back if its illegal move i use alreadin varaiable
			ChessBoard.chance--;        // change defines whose chance is this so if its illegal move we have degrement it.
			return;
		}
		int g=checkblack();
		if(0<g)
		{
			inCheck=1;
			finish=1;
			int z=checkblack1();
			if(z==1)
			{
				System.out.println("check only");
			}
			else if(z==2)
			{
				System.out.println("check mate");
				ChessBoard.checking="mate";
				finish=2;
			}	
		}
		/*else if(1==g)
		{
			inCheck=1;
			System.out.println("check only2");
		}*/
		peakvalue=0;
		return;

	}
	static void black(int a1,int b1,int c1)
	{
		ChessBoard.checking=" ";
		if(a[a1][b1]==16)
		{
			chip(a1,b1,c1);
		}
		else if(a[a1][b1]==11)
		{
			king(a1,b1,c1);
		}
		else if(a[a1][b1]==12)
		{
			queen(a1,b1,c1);
		}
		else if(a[a1][b1]==14)
		{
			knight(a1,b1,c1);
		}
		else if(a[a1][b1]==13)
		{
			bisaph(a1,b1,c1);
		}
		else if(a[a1][b1]==15)
		{
			rook(a1,b1,c1);
		}
		if(ChessBoard.chance%2==1)
		{
			illegalmove=1;
			ChessBoard.chance--;
			return;
		}
		if(1==checkblack() || 2==checkblack())
		{
			illegalmove=1;
			
			a[a1][b1]=a[c1/10][c1%10];
			a[c1/10][c1%10]=alreadin;
			ChessBoard.chance--;
			return;
		}
		int g=checkwhite();
		if(0<g)
		{
			inCheck=2;
			finish=1;
			int z=checkwhite1();
			if(z==1)
			{
				System.out.println("check only3");
			}
			else if(z==2)
			{
				System.out.println("check mate");
				ChessBoard.checking="mate";
				finish=2;
			}
		}
		/*else if(1==g)
		{
			inCheck=2;
			System.out.println("check only 4");
		}*/
		peakvalue=0;
		return;
	}



	
	public static void chip(int a1,int b1,int c1)
	{
		
		int i,q=0;
		int z[]=new int[100];
		
		if(a[a1][b1]==6)
		{
			if(a1*10+b1>=10 && a1*10+b1<=17)
			{
				if(a[a1+2][b1]==0 && a[a1+1][b1]==0)
				{
					z[q]=(a1+2)*10+b1;
					q++;
				
				}
			}
			if(a1+1<8 )
			if(a[a1+1][b1]==0)
			{
				z[q]=(a1+1)*10+b1;
				q++;
			}
			if(a1+1<8 && b1+1<8)
			if(a[a1+1][b1+1]==16||a[a1+1][b1+1]==11||a[a1+1][b1+1]==12||a[a1+1][b1+1]==13||a[a1+1][b1+1]==14||a[a1+1][b1+1]==15)
			{
				z[q]=(a1+1)*10+b1+1;
				q++;
			}
			if(a1+1<8 && b1-1>=0)
			if(a[a1+1][b1-1]==16||a[a1+1][b1-1]==11||a[a1+1][b1-1]==12||a[a1+1][b1-1]==13||a[a1+1][b1-1]==14||a[a1+1][b1-1]==15)
			{
				z[q]=(a1+1)*10+b1-1;
				q++;
			}
		}
		if(a[a1][b1]==16)
		{
			if(a1*10+b1>=60 && a1*10+b1<=67)
			{
				if(a[a1-2][b1]==0 && a[a1-1][b1]==0)
				{
					z[q]=(a1-2)*10+b1;
					q++;
				}
			}
			if(a1-1>=0 )
			if(a[a1-1][b1]==0)
			{
				z[q]=(a1-1)*10+b1;
				q++;
			}
			if(a1-1>=0 && b1+1<8)
			if(a[a1-1][b1+1]==6||a[a1-1][b1+1]==1||a[a1-1][b1+1]==2||a[a1-1][b1+1]==3||a[a1-1][b1+1]==4||a[a1-1][b1+1]==5)
			{
				z[q]=(a1-1)*10+b1+1;
				q++;
			}
			if(a1-1>=0 && b1-1>=0)
			if(a[a1-1][b1-1]==6||a[a1-1][b1-1]==1||a[a1-1][b1-1]==2||a[a1-1][b1-1]==3||a[a1-1][b1-1]==4||a[a1-1][b1-1]==5)
			{
				z[q]=(a1-1)*10+b1-1;
				q++;
			}
		}
		if(c1==-100)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}
		if(c1==-101)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}
		for( i=0;i<q;i++)
		{
			if(z[i]==c1)
			{
			
				alreadin=a[c1/10][c1%10];
				a[c1/10][c1%10]=a[a1][b1];
				
				a[a1][b1]=0;
				return;
			}
		}

		ChessBoard.chance--;	
	}




	public static void rook(int a1,int b1,int c1)
	{
		int i,j,n,q=0;
		int z[]=new int[100];
		if(a[a1][b1]==5)
		{
			
			for(i=a1+1;i<8;i++)
			{
				if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					break;
				}
				else if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					z[q]=(i*10)+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
			
				q++;
			}
			for(i=a1-1,j=b1;i>=0;i--)
			{
				if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					break;
				}
				else if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					z[q]=i*10+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
				q++;
			}
			for(j=a1,i=b1+1;i<8;i++)
			{
				if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					break;
				}
				else if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}
			for(j=a1,i=b1-1;i>=0;i--)
			{
				if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					break;
				}
				else if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}
		}
		if(a[a1][b1]==15)
		{
			for(i=a1+1;i<8;i++)
			{
				if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					break;
				}
				else if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					z[q]=(i*10)+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
				q++;
			}
			for(i=a1-1,j=b1;i>=0;i--)
			{
				if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					break;
				}
				else if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					z[q]=i*10+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
				q++;
			}
			for(j=a1,i=b1+1;i<8;i++)
			{
				if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					break;
				}
				else if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}
			for(j=a1,i=b1-1;i>=0;i--)
			{
				if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					break;
				}
				else if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}
		}
		if(c1==-100)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}
		if(c1==-101)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			//System.out.println(q);
			return;
		}

		for(i=0;i<q;i++)
		{
			if(z[i]==c1)
			{
				alreadin=a[c1/10][c1%10];
				
				a[c1/10][c1%10]=a[a1][b1];
				a[a1][b1]=0;
				return;
			}
		}
		ChessBoard.chance--;
	}




	static void knight(int a1,int b1,int c1)
	{
		int i,n,q=0;
		int z[]=new int[100];
	
		if(a[a1][b1]==4)
		{
			if(a1+2<8)
			{
				if(b1-1<8 && b1-1>-1)
				{
					if(a[a1+2][b1-1]==11||a[a1+2][b1-1]==12||a[a1+2][b1-1]==13||a[a1+2][b1-1]==14||a[a1+2][b1-1]==15||a[a1+2][b1-1]==16||a[a1+2][b1-1]==0)
					{
						z[q]=(a1+2)*10+(b1-1);
						
						q++;
					}
				}
				if(b1+1<8)
				{
					if(a[a1+2][b1+1]==11||a[a1+2][b1+1]==12||a[a1+2][b1+1]==13||a[a1+2][b1+1]==14||a[a1+2][b1+1]==15||a[a1+2][b1+1]==16||a[a1+2][b1+1]==0)
					{
						z[q]=(a1+2)*10+(b1+1);
						q++;
					}
				}
			}
			if(b1+2<8)
			{
				if(a1-1<8 && a1-1>-1)
				{
					if(a[a1-1][b1+2]==11||a[a1-1][b1+2]==12||a[a1-1][b1+2]==13||a[a1-1][b1+2]==14||a[a1-1][b1+2]==15||a[a1-1][b1+2]==16||a[a1-1][b1+2]==0)
					{	
						z[q]=(a1-1)*10+(b1+2);
						q++;
					}
				}
				if(a1+1<8)
				{
					if(a[a1+1][b1+2]==11||a[a1+1][b1+2]==12||a[a1+1][b1+2]==13||a[a1+1][b1+2]==14||a[a1+1][b1+2]==15||a[a1+1][b1+2]==16||a[a1+1][b1+2]==0)
					{
						z[q]=(a1+1)*10+(b1+2);
						q++;
					}
				}
			}
			if(a1-2<8 && a1-2>-1)
			{
				if(b1-1<8 && b1-1>-1)
				{
					if(a[a1-2][b1-1]==11||a[a1-2][b1-1]==12||a[a1-2][b1-1]==13||a[a1-2][b1-1]==14||a[a1-2][b1-1]==15||a[a1-2][b1-1]==16||a[a1-2][b1-1]==0)
					{
						z[q]=(a1-2)*10+(b1-1);
						q++;
					}
				}
				if(b1+1<8)
				{
					if(a[a1-2][b1+1]==11||a[a1-2][b1+1]==12||a[a1-2][b1+1]==13||a[a1-2][b1+1]==14||a[a1-2][b1+1]==15||a[a1-2][b1+1]==16||a[a1-2][b1+1]==0)
					{
						z[q]=(a1-2)*10+(b1+1);
						q++;
					}
				}	
			}
			if(b1-2<8 && b1-2>-1)
			{
				if(a1-1<8 && a1-1>-1)
				{
					if(a[a1-1][b1-2]==11||a[a1-1][b1-2]==12||a[a1-1][b1-2]==13||a[a1-1][b1-2]==14||a[a1-1][b1-2]==15||a[a1-1][b1-2]==16||a[a1-1][b1-2]==0)
					{
						z[q]=(a1-1)*10+(b1-2);
						q++;
					}
				}
				if(a1+1<8)
				{
					if(a[a1+1][b1-2]==11||a[a1+1][b1-2]==12||a[a1+1][b1-2]==13||a[a1+1][b1-2]==14||a[a1+1][b1-2]==15||a[a1+1][b1-2]==16||a[a1+1][b1-2]==0)
					{
						z[q]=(a1+1)*10+(b1-2);
						q++;
					}
				}
			}
		}	
		if(a[a1][b1]==14)
		{
		if(a1+2<8)
		{
			if(b1-1<8 && b1-1>-1)
			{
				if(a[a1+2][b1-1]==1||a[a1+2][b1-1]==2||a[a1+2][b1-1]==3||a[a1+2][b1-1]==4||a[a1+2][b1-1]==5||a[a1+2][b1-1]==6||a[a1+2][b1-1]==0)
				{
					z[q]=(a1+2)*10+(b1-1);
					
					q++;
				}
			}
			if(b1+1<8)
			{
				if(a[a1+2][b1+1]==1||a[a1+2][b1+1]==2||a[a1+2][b1+1]==3||a[a1+2][b1+1]==4||a[a1+2][b1+1]==5||a[a1+2][b1+1]==6||a[a1+2][b1+1]==0)
				{
					z[q]=(a1+2)*10+(b1+1);
					
					q++;
				}
			}	
		}
		if(b1+2<8)
		{
			if(a1-1<8 && a1-1>-1)
			{
				if(a[a1-1][b1+2]==1||a[a1-1][b1+2]==2||a[a1-1][b1+2]==3||a[a1-1][b1+2]==4||a[a1-1][b1+2]==5||a[a1-1][b1+2]==6||a[a1-1][b1+2]==0)
				{
					z[q]=(a1-1)*10+(b1+2) ;
				
					q++;
				}
			}
			if(a1+1<8)
			{
				if(a[a1+1][b1+2]==1||a[a1+1][b1+2]==2||a[a1+1][b1+2]==3||a[a1+1][b1+2]==4||a[a1+1][b1+2]==5||a[a1+1][b1+2]==6||a[a1+1][b1+2]==0)
				{
					z[q]=(a1+1)*10+(b1+2);
					
					q++;
				}
			}
		}
		if(a1-2<8 && a1-2>-1)
		{
			if(b1-1<8 && b1-1>-1)
			{
				
				if(a[a1-2][b1-1]==1||a[a1-2][b1-1]==2||a[a1-2][b1-1]==3||a[a1-2][b1-1]==4||a[a1-2][b1-1]==5||a[a1-2][b1-1]==6||a[a1-2][b1-1]==0)
				{
					z[q]=(a1-2)*10+(b1-1);
					
					q++;
				}
			}
			if(b1+1<8)
			{	
				if(a[a1-2][b1+1]==1||a[a1-2][b1+1]==2||a[a1-2][b1+1]==3||a[a1-2][b1+1]==4||a[a1-2][b1+1]==5||a[a1-2][b1+1]==6||a[a1-2][b1+1]==0)
				{
					z[q]=(a1-2)*10+(b1+1);
					
					q++;
				}
			}
		}
		if(b1-2<8 && b1-2>-1)
		{
			if(a1-1<8 && a1-1>-1)
			{
				if(a[a1-1][b1-2]==1||a[a1-1][b1-2]==2||a[a1-1][b1-2]==3||a[a1-1][b1-2]==4||a[a1-1][b1-2]==5||a[a1-1][b1-2]==6||a[a1-1][b1-2]==0)
				{
					z[q]=(a1-1)*10+(b1-2) ;
					
					q++;
				}
			}
			if(a1+1<8)
			{
				if(a[a1+1][b1-2]==1||a[a1+1][b1-2]==2||a[a1+1][b1-2]==3||a[a1+1][b1-2]==4||a[a1+1][b1-2]==5||a[a1+1][b1-2]==6||a[a1+1][b1-2]==0)
				{
					z[q]=(a1+1)*10+(b1-2);
					
					q++;
				}
			}
		}
		}
		if(c1==-100)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}
		if(c1==-101)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}

		for(i=0;i<q;i++)
		{
			if(z[i]==c1)
			{
				alreadin=a[c1/10][c1%10];
			
				a[c1/10][c1%10]=a[a1][b1];
				a[a1][b1]=0;
				return;
			}
		}
		ChessBoard.chance--;

	}
								
		

	static void bisaph(int a1,int b1,int c1)
	{
		int i,n,q=0,j;
		int z[]=new int[100];
		if(a[a1][b1]==3)
		{
			for(i=a1+1,j=b1+1;i<8&&j<8;i++,j++)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1-1;i>=0&&j>=0;i--,j--)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1+1,j=b1-1;i<8&&j>=0;i++,j--)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1+1;i>=0&&j<8;i--,j++)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
		}
		if(a[a1][b1]==13)
		{
			for(i=a1+1,j=b1+1;i<8&&j<8;i++,j++)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1-1;i>=0&&j>=0;i--,j--)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1+1,j=b1-1;i<8&&j>=0;i++,j--)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1+1;i>=0&&j<8;i--,j++)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
		}
		if(c1==-100)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}
		if(c1==-101)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}

		for(i=0;i<q;i++)
		{
			if(z[i]==c1)
			{
				alreadin=a[c1/10][c1%10];
				
			
				a[c1/10][c1%10]=a[a1][b1];
				a[a1][b1]=0;
				return;
			}
		}
		ChessBoard.chance--;

	}



	static void queen(int a1,int b1,int c1)
	{
		int i,j,n,q=0;
		int z[]=new int[100];
		if(a[a1][b1]==2)
		{
			for(i=a1+1;i<8;i++)
			{
				if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					break;
				}
				else if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					z[q]=(i*10)+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
				q++;
			}
			for(i=a1-1,j=b1;i>=0;i--)
			{
				if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					break;
				}
				else if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					z[q]=i*10+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
				q++;
			}
			for(j=a1,i=b1+1;i<8;i++)
			{
				if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					break;
				}
				else if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}
			for(j=a1,i=b1-1;i>=0;i--)
			{
				if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					break;
				}
				else if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}
		}
		if(a[a1][b1]==12)
		{
			for(i=a1+1;i<8;i++)
			{
				if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					break;
				}
				else if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					z[q]=(i*10)+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
				q++;
			}
			for(i=a1-1,j=b1;i>=0;i--)
			{
				if(a[i][b1]==11||a[i][b1]==12||a[i][b1]==13||a[i][b1]==14||a[i][b1]==16||a[i][b1]==15)
				{
					break;
				}
				else if(a[i][b1]==1||a[i][b1]==2||a[i][b1]==3||a[i][b1]==4||a[i][b1]==6||a[i][b1]==5)
				{
					z[q]=i*10+b1;
					q++;
					break;
				}
				z[q]=i*10+b1;
				q++;
			}
			for(j=a1,i=b1+1;i<8;i++)
			{
				if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					break;
				}
				else if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}	
			for(j=a1,i=b1-1;i>=0;i--)
			{
				if(a[a1][i]==11||a[a1][i]==12||a[a1][i]==13||a[a1][i]==14||a[a1][i]==16||a[a1][i]==15)
				{
					break;
				}
				else if(a[a1][i]==1||a[a1][i]==2||a[a1][i]==3||a[a1][i]==4||a[a1][i]==6||a[a1][i]==5)
				{
					z[q]=a1*10+i;
					q++;
					break;
				}
				z[q]=a1*10+i;
				q++;
			}
		}
		if(a[a1][b1]==2)
		{
			for(i=a1+1,j=b1+1;i<8&&j<8;i++,j++)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1-1;i>=0&&j>=0;i--,j--)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1+1,j=b1-1;i<8&&j>=0;i++,j--)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1+1;i>=0&&j<8;i--,j++)
			{
				if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					break;
				}
				else if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
		}
		if(a[a1][b1]==12)
		{
			for(i=a1+1,j=b1+1;i<8&&j<8;i++,j++)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1-1;i>=0&&j>=0;i--,j--)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1+1,j=b1-1;i<8&&j>=0;i++,j--)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
			for(i=a1-1,j=b1+1;i>=0&&j<8;i--,j++)
			{
				if(a[i][j]==11||a[i][j]==12||a[i][j]==13||a[i][j]==14||a[i][j]==16||a[i][j]==15)
				{
					break;
				}
				else if(a[i][j]==1||a[i][j]==2||a[i][j]==3||a[i][j]==4||a[i][j]==6||a[i][j]==5)
				{
					z[q]=(i*10)+j;
					q++;
					break;
				}
				z[q]=i*10+j;
				q++;
			}
		}
		if(c1==-100)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			
			}
			return;
		}
		if(c1==-101)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}

		for(i=0;i<q;i++)
		{
			if(z[i]==c1)
			{
				alreadin=a[c1/10][c1%10];
				
				a[c1/10][c1%10]=a[a1][b1];
				a[a1][b1]=0;
				return;
			}
		}
		ChessBoard.chance--;
	}


	static void king(int a1,int b1,int c1)
	{
		int i,n,q=0;
		int z[]=new int[100];
		if(a[a1][b1]==11)
		{
		if(b1+1<8)
		{
			if(a[a1][b1+1]==1||a[a1][b1+1]==2|| a[a1][b1+1]==3|| a[a1][b1+1]==4||a[a1][b1+1]==5||a[a1][b1+1]==6||a[a1][b1+1]==0)
			{
				z[q]=(a1*10)+b1+1;
				q++;
			}
		}
		if(b1-1<8 && b1-1>-1)
		{
			if(a[a1][b1-1]==1||a[a1][b1-1]==2|| a[a1][b1-1]==3|| a[a1][b1-1]==4||a[a1][b1-1]==5||a[a1][b1-1]==6||a[a1][b1-1]==0)
			{
				z[q]=(a1*10)+b1-1;
				q++;
			}
		}
		if(a1+1<8)
		{
			if(a[a1+1][b1]==1||a[a1+1][b1]==2|| a[a1+1][b1]==3|| a[a1+1][b1]==4||a[a1+1][b1]==5||a[a1+1][b1]==6||a[a1+1][b1]==0)
			{
				z[q]=(a1+1)*10+b1;
				q++;
			}
		}	
		if(a1-1<8 && a1-1>-1)
		{
			if(a[a1-1][b1]==1||a[a1-1][b1]==2|| a[a1-1][b1]==3|| a[a1-1][b1]==4||a[a1-1][b1]==5||a[a1-1][b1]==6||a[a1-1][b1]==0)
			{
				z[q]=(a1-1)*10+b1;
				q++;
			}
		}
		if(a1+1<8 &&b1+1<8)
		{
			if(a[a1+1][b1+1]==1||a[a1+1][b1+1]==2|| a[a1+1][b1+1]==3|| a[a1+1][b1+1]==4||a[a1+1][b1+1]==5||a[a1+1][b1+1]==6||a[a1+1][b1+1]==0)
			{
				z[q]=(a1+1)*10+b1+1;
				q++;
			}
		}
		if(a1+1<8 &&b1-1>=0)
		{
			if(a[a1+1][b1-1]==1||a[a1+1][b1-1]==2|| a[a1+1][b1-1]==3|| a[a1+1][b1-1]==4||a[a1+1][b1-1]==5||a[a1+1][b1-1]==6||a[a1+1][b1-1]==0)
			{
				z[q]=(a1+1)*10+b1-1;
				q++;
			}
		}
		if(a1-1>=0 && b1+1<8)
		{
			if(a[a1-1][b1+1]==1||a[a1-1][b1+1]==2|| a[a1-1][b1+1]==3|| a[a1-1][b1+1]==4||a[a1-1][b1+1]==5||a[a1-1][b1+1]==6||a[a1-1][b1+1]==0)
			{
				z[q]=(a1-1)*10+b1+1;
				q++;
			}
		}
		if(a1-1>=0 && b1-1>0)
		{
			if(a[a1-1][b1-1]==1||a[a1-1][b1-1]==2|| a[a1-1][b1-1]==3|| a[a1-1][b1-1]==4||a[a1-1][b1-1]==5||a[a1-1][b1-1]==6||a[a1-1][b1-1]==0)
			{
				z[q]=(a1-1)*10+b1-1;
				q++;
			}
		}	

		}
		if(a[a1][b1]==1)
		{
		if(b1+1<8)
		{
			if(a[a1][b1+1]==11||a[a1][b1+1]==12|| a[a1][b1+1]==13|| a[a1][b1+1]==14||a[a1][b1+1]==15||a[a1][b1+1]==16||a[a1][b1+1]==0)
			{
				z[q]=(a1*10)+b1+1;
				q++;
			}
		}
		if(b1-1<8 && b1-1>-1)
		{
			if(a[a1][b1-1]==11||a[a1][b1-1]==12|| a[a1][b1-1]==13|| a[a1][b1-1]==14||a[a1][b1-1]==15||a[a1][b1-1]==16||a[a1][b1-1]==0)
			{
				z[q]=(a1*10)+b1-1;
				q++;
			}
		}
		if(a1+1<8)
		{
			if(a[a1+1][b1]==1||a[a1+1][b1]==12|| a[a1+1][b1]==13|| a[a1+1][b1]==14||a[a1+1][b1]==15||a[a1+1][b1]==16||a[a1+1][b1]==0)
			{
				z[q]=(a1+1)*10+b1;
				q++;
			}
		}
		if(a1-1<8 && a1-1>-1)
		{
			if(a[a1-1][b1]==11||a[a1-1][b1]==12|| a[a1-1][b1]==13|| a[a1-1][b1]==14||a[a1-1][b1]==15||a[a1-1][b1]==16||a[a1-1][b1]==0)
			{
				z[q]=(a1-1)*10+b1;
				q++;
			}
		}
		if(a1+1<8 &&b1+1<8)
		{
			if(a[a1+1][b1+1]==11||a[a1+1][b1+1]==12|| a[a1+1][b1+1]==13|| a[a1+1][b1+1]==14||a[a1+1][b1+1]==15||a[a1+1][b1+1]==16||a[a1+1][b1+1]==0)
			{
				z[q]=(a1+1)*10+b1+1;
				q++;
			}
		}
		if(a1+1<8 &&b1-1>=0)
		{
			if(a[a1+1][b1-1]==11||a[a1+1][b1-1]==12|| a[a1+1][b1-1]==13|| a[a1+1][b1-1]==14||a[a1+1][b1-1]==15||a[a1+1][b1-1]==16||a[a1+1][b1-1]==0)
			{
				z[q]=(a1+1)*10+b1-1;
				q++;
			}
		}
		if(a1-1>=0 && b1+1<8)
		{
			if(a[a1-1][b1+1]==11||a[a1-1][b1+1]==12|| a[a1-1][b1+1]==13|| a[a1-1][b1+1]==14||a[a1-1][b1+1]==15||a[a1-1][b1+1]==16||a[a1-1][b1+1]==0)
			{
				z[q]=(a1-1)*10+b1+1;
				q++;
			}
		}
		if(a1-1>=0 && b1-1>=0)
		{
			if(a[a1-1][b1-1]==11||a[a1-1][b1-1]==12|| a[a1-1][b1-1]==13|| a[a1-1][b1-1]==14||a[a1-1][b1-1]==15||a[a1-1][b1-1]==16||a[a1-1][b1-1]==0)
			{
				z[q]=(a1-1)*10+b1-1;
				q++;
			}
		}

	
		}
		if(c1==-99)
		{
			for(i=0;i<q;i++)
			{
				findking[noof++]=z[i];
			}
			return;
		}
		if(c1==-101)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}
	
		if(c1==-100)
		{
			for( i=0;i<q;i++)
			{
				search[peakvalue++]=z[i];
			}
			return;
		}

		for(i=0;i<q;i++)
		{
			if(z[i]==c1)
			{
				alreadin=a[c1/10][c1%10];
				
				a[c1/10][c1%10]=a[a1][b1];
				a[a1][b1]=0;
				return;
			}
		}
		ChessBoard.chance--;
	}
	static int checkwhite()
	{
		int i,j,r=0;	
		peakvalue=0;
		
		l1:for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(a[i][j]==1)
				{
					king(i,j,-99);
					r=(i*10)+j;
					break l1;
				}
			}
		}
		
		peak=1;
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(a[i][j]==11)
				{
					king(i,j,-100);
				}
				if(a[i][j]==12)
				{
					queen(i,j,-100);
				}
				if(a[i][j]==13)
				{
					bisaph(i,j,-100);
				}
				if(a[i][j]==14)
				{
					knight(i,j,-100);
				}
				if(a[i][j]==15)
				{
					rook(i,j,-100);
				}
				if(a[i][j]==16)
				{
					chip(i,j,-100);
				}
			}
		}
	
		j=0;
		for(i=0;i<peakvalue;i++)
		{
			if(search[i]==r)  //search - The positions occupied by the block coins
			{
				j=1;
				break;	
			}
		}
		if(j==0)
		{
			peak=0;
			o= 0;
			noof=0;
			return 0;	
		}
		//return 1;
		int g;
		for(i=0;i<noof;i++)
		{
			g=0;
			for(j=0;j<peakvalue;j++)
			{
				
				if(search[j]==findking[i])  //findking - the place we have chance to move the king
				{
				
					g=1;
					break;
				}
			}
			if(g==0)
			{
				peak=0;
				noof=0;
				return 1;
			}
		}
		peak=0;
		noof=0;
		return 2;
	}
	static int checkwhite1()
	{
		int t,w,i,j,peakvalue1,o=-99;
		int search1[]=new int[100];
		peakvalue=0;
		for(t=0;t<8;t++)
		{
			for(w=0;w<8;w++)
			{		
				o=-99;
				peakvalue=0;
				if(a[t][w]==1)
				{
					king(t,w,-100);
					peakvalue1=peakvalue;
					System.out.println("The peak value is "+peakvalue);
					for(i=0;i<peakvalue1;i++)
					{
					       search1[i]=search[i];
					}
					for(i=0;i<peakvalue1;i++)
					{
						a[t][w]=0;
						j=a[search1[i]/10][search1[i]%10];
						a[search1[i]/10][search1[i]%10]=1;
						o=checkwhite();
						a[search1[i]/10][search1[i]%10]=j;
						a[t][w]=1;
						if(o==0 )
						{
							peak=0;			
							return 1;
						}
					}
				}
				if(a[t][w]==2)
				{
					queen(t,w,-100);
					peakvalue1=peakvalue;
					for(i=0;i<peakvalue1;i++)
					{
					       search1[i]=search[i];
					}
					for(i=0;i<peakvalue1;i++)
					{
						a[t][w]=0;
						j=a[search1[i]/10][search1[i]%10];
						a[search1[i]/10][search1[i]%10]=2;
						o=checkwhite();
						a[search1[i]/10][search1[i]%10]=j;
						a[t][w]=2;
						if(o==0 )
						{
							peak=0;			
							return 1;
						}
					}
				}
				if(a[t][w]==3)
				{				
					bisaph(t,w,-100);
					peakvalue1=peakvalue;
					for(i=0;i<peakvalue1;i++)
					{
					       search1[i]=search[i];
					}
					for(i=0;i<peakvalue1;i++)
					{
						a[t][w]=0;		
						j=a[search1[i]/10][search1[i]%10];
						a[search1[i]/10][search1[i]%10]=3;
						o=checkwhite();
						a[search1[i]/10][search1[i]%10]=j;
						a[t][w]=3;
						if(o==0 )
						{
							o=-99;
							peak=0;
						
							return 1;
						}

					}
				}
				if(a[t][w]==4)
				{		
					knight(t,w,-100);
					peakvalue1=peakvalue;
					for(i=0;i<peakvalue1;i++)
					{
					       search1[i]=search[i];
					}
					for(i=0;i<peakvalue1;i++)
					{
						a[t][w]=0;
						j=a[search1[i]/10][search1[i]%10];
						a[search1[i]/10][search1[i]%10]=4;
						o=checkwhite();
						a[search1[i]/10][search1[i]%10]=j;
						a[t][w]=4;
						if(o==0 )
						{
							o=-99;					
							peak=0;
							return 1;
						}
					}
				}
				if(a[t][w]==5)
				{
				
					rook(t,w,-100);
					peakvalue1=peakvalue;
					for(i=0;i<peakvalue1;i++)
					{
					       search1[i]=search[i];
					}
					for(i=0;i<peakvalue1;i++)
					{
						a[t][w]=0;
						j=a[search1[i]/10][search1[i]%10];
						a[search1[i]/10][search1[i]%10]=5;
						o=checkwhite();
						a[search1[i]/10][search1[i]%10]=j;
						a[t][w]=5;
						if(o==0 )
						{
							o=-99;				
							peak=0;
							return 1;
						}
					}
				}
				if(a[t][w]==6)
				{			
					chip(t,w,-100);
					peakvalue1=peakvalue;
					for(i=0;i<peakvalue1;i++)
					{
					       search1[i]=search[i];
					}
					for(i=0;i<peakvalue1;i++)
					{
						a[t][w]=0;		
						j=a[search1[i]/10][search1[i]%10];
						a[search1[i]/10][search1[i]%10]=6;
						o=checkwhite();
						a[search1[i]/10][search1[i]%10]=j;
						a[t][w]=6;
						if(o==0 )
						{
							o=-99;
							peak=0;				
							return 1;
						}
					}
				}
				if(o==0 )
				{
					o=-99;
					peak=0;	
					return 1;
				}
			}
		}
		peak=0;
		return 2;
	}
	static int checkblack()
	{
		int i,j,r=0;	
		peakvalue=0;
		l1:for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(a[i][j]==11)
				{
					king(i,j,-99);
					r=(i*10)+j;
					break l1;
				}
			}
		}
		
		peak=1;
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(a[i][j]==1)
				{
					king(i,j,-100);
				}
				if(a[i][j]==2)
				{
					queen(i,j,-100);
				}
				if(a[i][j]==3)
				{
					bisaph(i,j,-100);
				}
				if(a[i][j]==4)
				{
					knight(i,j,-100);
				}
				if(a[i][j]==5)
				{
					rook(i,j,-100);
				}
				if(a[i][j]==6)
				{
					chip(i,j,-100);
				}
			}
		}
		
		j=0;
		for(i=0;i<peakvalue;i++)
		{
			if(search[i]==r)  //search - The positions occupied by the block coins
			{
				j=1;
				break;	
			}
		}
		if(j==0)
		{
			peak=0;
			o= 0;
			noof=0;
			return 0;	
		}
		//return 1;
		int g;
		for(i=0;i<noof;i++)
		{
			g=0;
			for(j=0;j<peakvalue;j++)
			{
				if(search[j]==findking[i])  //findking - the place we have chance to move the king
				{
					g=1;
					break;
				}
			}
			if(g==0)
			{
				System.out.println("this is the place"+findking[i]);
				peak=0;
				noof=0;
				return 1;
			}
		}
		peak=0;
		noof=0;
		return 2;
	}
	static int checkblack1()
	{
	int t,w,i,j,peakvalue1,o=-99;
	int search1[]=new int[100];
	peakvalue=0;
	for(t=0;t<8;t++)
	{
		for(w=0;w<8;w++)
		{
			o=-99;
			peakvalue=0;
			if(a[t][w]==11)
			{
				king(t,w,-100);
				peakvalue1=peakvalue;
				System.out.println("the peak value is "+peakvalue1);
				for(i=0;i<peakvalue1;i++)
				{
				       search1[i]=search[i];
				}
				for(i=0;i<peakvalue1;i++)
				{
					a[t][w]=0;
					j=a[search1[i]/10][search1[i]%10];
					a[search1[i]/10][search1[i]%10]=11;
					o=checkblack();
					a[search1[i]/10][search1[i]%10]=j;
					a[t][w]=11;
					if(o==0 )
					{							
						peak=0;
						return 1;
					}
				}
			}
			if(a[t][w]==12)
			{
				queen(t,w,-100);
				peakvalue1=peakvalue;
				for(i=0;i<peakvalue1;i++)
				{
				       search1[i]=search[i];
				}
				for(i=0;i<peakvalue1;i++)
				{
					a[t][w]=0;
					j=a[search1[i]/10][search1[i]%10];
					a[search1[i]/10][search1[i]%10]=12;
					o=checkblack();
					a[search1[i]/10][search1[i]%10]=j;
					a[t][w]=12;
					if(o==0 )
					{							
						peak=0;
						return 1;
					}
				}
			}
			if(a[t][w]==13)
			{
				bisaph(t,w,-100);
				peakvalue1=peakvalue;
				for(i=0;i<peakvalue1;i++)
				{
				       search1[i]=search[i];
				}
				for(i=0;i<peakvalue1;i++)
				{
					a[t][w]=0;
					j=a[search1[i]/10][search1[i]%10];
					a[search1[i]/10][search1[i]%10]=13;
					o=checkblack();
					a[search1[i]/10][search1[i]%10]=j;
					a[t][w]=13;
					if(o==0 )
					{
						
						o=-99;
						peak=0;
						return 1;
					}

				}
			}
			if(a[t][w]==14)
			{
				knight(t,w,-100);
				peakvalue1=peakvalue;
				for(i=0;i<peakvalue1;i++)
				{
				       search1[i]=search[i];
				}
				for(i=0;i<peakvalue1;i++)
				{
					a[t][w]=0;
					j=a[search1[i]/10][search1[i]%10];
					a[search1[i]/10][search1[i]%10]=14;
					o=checkblack();
					a[search1[i]/10][search1[i]%10]=j;
					a[t][w]=14;
					if(o==0)
					{
						o=-99;
						peak=0;
						return 1;
					}

				}
			}
			if(a[t][w]==15)
			{
				rook(t,w,-100);
				peakvalue1=peakvalue;
				for(i=0;i<peakvalue1;i++)
				{
				       search1[i]=search[i];
				}
				for(i=0;i<peakvalue1;i++)
				{
					a[t][w]=0;
					j=a[search1[i]/10][search1[i]%10];
					a[search1[i]/10][search1[i]%10]=15;
					o=checkblack();
					a[search1[i]/10][search1[i]%10]=j;
					a[t][w]=15;
					if(o==0 )
					{
						
						o=-99;
						peak=0;
						return 1;
					}

				}
			}
			if(a[t][w]==16)
			{
				chip(t,w,-100);
				peakvalue1=peakvalue;
				for(i=0;i<peakvalue1;i++)
				{
				       search1[i]=search[i];
				  
				}
				for(i=0;i<peakvalue1;i++)
				{
					a[t][w]=0;
					j=a[search1[i]/10][search1[i]%10];
					a[search1[i]/10][search1[i]%10]=16;
					o=checkblack();
					a[search1[i]/10][search1[i]%10]=j;
					a[t][w]=16;
					if(o==0 )
					{
						o=-99;
						peak=0;
						return 1;
					}

				}
			}
			if(o==0 )
			{
				o=-99;
				peak=0;
				return 1;
			}
		}
	}
	peak=0;
	return 2;
	}	

}	
