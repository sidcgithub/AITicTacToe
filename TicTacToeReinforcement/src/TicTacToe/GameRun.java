package TicTacToe;

public class GameRun {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TicTacToe ttt = new TicTacToe();
		
		ttt.initBoard();
		
		int count = 0 ;
		while(ttt.winner()==-1||count==8)
		{
			ttt.moveGeneratorMain(true);
			count++;
		}
		
		

	}

}
