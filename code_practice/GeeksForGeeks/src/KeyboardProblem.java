
public class KeyboardProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char keypad[][] = {{'1','2','3'},
		        {'4','5','6'},
		        {'7','8','9'},
		        {'*','0','#'}
		    };
		System.out.println(PossibleNumbers(1, keypad));
		System.out.println(PossibleNumbers(2, keypad));
		System.out.println(PossibleNumbers(3, keypad));
		System.out.println(PossibleNumbers(4, keypad));
		System.out.println(PossibleNumbers(5, keypad));
	}

	public static int PossibleNumbers(int N, char keypad[][])
	{
	    if(N==1)
	        return 10;
	    int count = 0;
	    for(int r = 0; r <4; r++)
	    {
	        for(int c = 0; c<3; c++)
	        {
	            if(keypad[r][c] != '*' && keypad[r][c] != '#')
	                count += countPossible(N, r, c, keypad);
	        }
	    }
	    return count;    
	}

	public static int moveX[] = {1, -1, 0, 0, 0};
	public static int moveY[] = {0,  0, 1, -1, 0};
	public static int countPossible(int N, int r, int c, char kb[][])
	{
	     if(N == 1)
	         return 1;
	     if(N<0)
	         return 0;
	     int count = 0;
	     for(int i = 0; i < 5; i++)
	     {
	         if(isSafe(kb,r+moveX[i], c + moveY[i]))
	             count+= countPossible(N-1, r+moveX[i], c+moveY[i], kb);
	     }    
	     return count;
	}

	public static boolean isSafe(char kb[][], int r, int c)
	{
	    if(r < 0 || c < 0 || r >3 || c > 2 || kb[r][c] == '*' || kb[r][c] == '#')
	        return false;
	    return true;    
	}
	
}
