package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToe {

	Integer[][] board = {{0,1,1},
			{1,1,0},
			{1,0,0}};
	int move = 0;

	public void initBoard()
	{
		for(int i = 0 ;i<board.length;i++)
		{
			for(int j = 0;j<board[i].length;j++)
			{
				board[i][j]=-1;
			}
		}



	}



	public int winner()
	{

		//Determine if the row wins
		for(int i =0 ;i<board.length;i++)
		{
			int prev = board[i][0];
			int count=0;
			for(int j = 0 ;j<board[i].length;j++)
			{

				if(prev==board[i][j])
				{
					count++;
					prev = board[i][j];
				}
				else
				{
					break;
				}
			}
			if(count==3)
			{
				if(prev!=-1)
					return prev;
			}
		}

		//Determine if column wins
		for(int i =0 ;i<3;i++)
		{
			int prev = board[0][i];
			int count=0;
			for(int j = 0 ;j<3;j++)
			{

				if(prev==board[j][i])
				{
					count++;
					prev = board[j][i];
				}
				else
				{
					break;
				}
			}
			if(count==3)
			{
				if(prev!=-1)
					return prev;
			}
		}

		if(board[0][0]==board[1][1]&& board[1][1]==board[2][2])
		{
			if(board[0][0]!=-1)
			{
				return board[0][0];
			}
		}


		if(board[2][0]==board[1][1]&& board[1][1]==board[0][2])
		{
			if(board[2][0]!=-1)
			{
				return board[2][0];
			}
		}
		return -1;
	}
	//This is the move Generator for the main game
	public List<Integer> moveGeneratorMain(boolean enable,int userX,int userY)
	{

		//System.out.println(move);


		Random rx = new Random();
		Random ry = new Random();
		int x=0,y=0;
		int falseCount=0;
		boolean complete = false;
		if(findEmpty(this))
		{
			if(userX!=-1)
			{
				board[userX][userY]=1;
			}
			else
			{



				while(complete==false)
				{

					x = rx.nextInt(3);
					y = ry.nextInt(3);

					if(board[x][y]!=-1)
					{
						continue;
					}
					else
					{

						if(move%2==0)
						{

							if(movePredictor(x,y))
							{
								board[x][y]=move%2;				
								complete=true;
								System.out.println("movePredictorTrue");
							}
							else
							{

								falseCount++;
								if(falseCount>1000)
								{
									board[x][y]=move%2;				
									complete=true;
								}
								else
									//							System.out.println("movePredictorFalse");
									complete=false;
							}

						}
						else
						{
							board[x][y]=move%2;				
							complete=true;
						}




					}
				}
			}
		}

		if(true)
		{

			for(int i = 0;i<3;i++)
			{
				for(int j =0 ;j<3;j++)
				{
					System.out.print("\t"+board[i][j]);
				}
				System.out.println("");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
		List<Integer> coord = new ArrayList<>();
		coord.add(x);
		coord.add(y);
		move++;
		return coord;


	}

	public List<Integer> moveGeneratorSimulate(boolean enable)
	{

		Random rx = new Random();
		Random ry = new Random();
		int x=0,y=0;
		boolean complete = false;
		int ctr = 0;
		if(findEmpty(this))
		{
			while(complete==false)
			{


				x = rx.nextInt(3);
				y = ry.nextInt(3);


				if(board[x][y]!=-1)
				{
					//System.out.println("Move Generate");

					continue;
				}
				else
				{

					board[x][y]=move%2;				
					complete=true;




				}
			}
		}

		move++;

		List<Integer> coord = new ArrayList<>();
		coord.add(x);
		coord.add(y);
		return coord;


	}

	public boolean findEmpty(TicTacToe ttt)
	{
		for(int i = 0 ;i<3;i++)
		{
			for(int j = 0 ;j<3;j++)
			{
				if(ttt.board[i][j]==-1)
				{
					return true;
				}
			}
		}
		return false;
	}

	public int simulateGame(TicTacToe ttt)
	{



		int count = 0 ;
		if(findEmpty(ttt))
		{
			while(ttt.winner()==-1&&count<9)
			{

				ttt.moveGeneratorSimulate(false);
				if(!findEmpty(ttt))
					break;

				//			System.out.println("Simulation");
				count++;
			}
		}

		return ttt.winner();
	}

	public boolean movePredictor(int x,int  y)
	{
		TicTacToe predictTTT = new TicTacToe();

		if(move%2==0)
		{
			predictTTT.initBoard();

			for(int i=0; i<predictTTT.board.length; i++)
				for(int j=0; j<predictTTT.board[i].length; j++)
					predictTTT.board[i][j]=board[i][j];
			predictTTT.move = move;
			predictTTT.board[x][y]=move%2;
			predictTTT.move++;


			if(move==9)
				return true;

			int sum =0;			
			for(int  i = 0 ;i<10;i++)
			{
				TicTacToe tt = new TicTacToe();
				for(int i1=0; i1<predictTTT.board.length; i1++)
					for(int j=0; j<predictTTT.board[i1].length; j++)
						tt.board[i1][j]=predictTTT.board[i1][j];
				tt.move = predictTTT.move;
				//System.out.println("Counting wins");
				if(simulateGame(tt)==0)
				{
					sum++;
				}
			}



			if((float)sum/10>=(float)(0.8))
			{
				System.out.println("Win probability"+ String.format("%.2f", (float)sum/10));
				return true;
			}




		}

		return false;



	}

}
