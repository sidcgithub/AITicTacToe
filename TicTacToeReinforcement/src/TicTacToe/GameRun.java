package TicTacToe;

public class GameRun {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wins = 0 ;
		
		for(int i =0 ;i<100;i++)
		{
		
			TicTacToe ttt = new TicTacToe();
			
			ttt.initBoard();
			
			int count = 0 ;
			while(ttt.winner()==-1&&count<9)
			{
				ttt.moveGeneratorMain(true);
				count++;
			}
			if(ttt.winner()==0)
			{
				wins++;
			}
		}
		
		System.out.println("Wins: "+wins);
		
		

	}

}
