package TicTacToe;

import java.util.List;

public class AIHelper {
	
	public ConstExp moveProbabilityMapper(ConstExp oldExp,float prob, int x, int y)
	{
		
		ConstExp exp = new ConstExp();
		
		int xProd = 1;
		for(int i = 0;i<exp.b;i++)
		{
			xProd*=x;
		}
		
		int yProd = 1;
		for(int i = 0;i<exp.d;i++)
		{
			yProd*=y;
		}
		
		float probExpected =  exp.a*xProd+exp.c*yProd + exp.e;
		
		return exp;
		
		
	}

}
