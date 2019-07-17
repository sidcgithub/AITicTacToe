package TicTacToe;

import java.util.Scanner;

public class GameRun {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wins = 0 ;
		
		
		Scanner scn = new Scanner(System.in);
		
		
		runGame(true);
		
		//To test AI vs random
		
//		for(int i =0 ;i<100;i++)
//		{
//			if(runGame()==0)
//			{
//				wins++;
//			}
//		   
//		}
		
		System.out.println("Wins: "+wins);
		
		

	}
	
	public static int runGame()
	{
		TicTacToe ttt = new TicTacToe();
		
		ttt.initBoard();
		
		int count = 0 ;
		while(ttt.winner()==-1&&count<9)
		{
			ttt.moveGeneratorMain(true,-1,-1);
			count++;
		}
		 return ttt.winner();
	}
	public static int runGame(boolean user)
	{
		TicTacToe ttt = new TicTacToe();
		
		ttt.initBoard();
		Scanner scn = new Scanner(System.in);
		int ux=0, uy=0;
		
		int count = 0 ;
		while(ttt.winner()==-1&&count<9)
		{
			if(count%2!=0)
			{
			
			System.out.println("Enter x");
			ux = scn.nextInt();
			System.out.println("Enter y");
			uy = scn.nextInt();
			
			ttt.moveGeneratorMain(true,ux,uy);
			}
			else
			{
				ttt.moveGeneratorMain(true,-1,-1);
			}
			count++;
		}
		 return ttt.winner();
	}

}


