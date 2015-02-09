package backtracking;

public class StringSearchInMatrix {

	static int r[]={1,1, 1,-1,-1,-1,0, 0};
	static int c[]={1,0,-1, 1, 0,-1,1,-1};
	static int rowMax = 10;
	static int colMax = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char P[][]={{'A','C','P','R','C'},
					{'X','S','O','P','C'},
					{'V','O','V','N','I'},
					{'W','G','F','M','N'},
					{'Q','A','T','I','T'}};
		String str  = new String("MICROSOFT");*/
		char P[][]={
				{'A','C','P','R','C','A','T','L','A','B'},
				{'X','A','O','P','C','B','E','A','A','B'},
				{'V','T','V','N','I','G','E','A','S','E'},
				{'W','G','B','M','N','S','G','B','D','E'},
				{'Q','A','T','A','T','F','R','A','U','D'},
				{'L','A','B','I','L','F','C','L','U','D'},
				{'W','A','F','A','T','S','G','A','D','E'},
				{'V','T','B','N','A','G','E','B','T','E'},
				{'X','A','O','P','C','B','L','A','A','B'},
				{'A','C','P','R','C','A','T','L','A','B'}
			};
			String str  = new String("shashi");
			
			char c[]= str.toCharArray();
			boolean found = false;
			for(int i = 0; i < rowMax; i++)
			{
				for(int j = 0; j < colMax; j++)
				{
					if(findString(P, i, j, c, 0))
						found = true;
				}
			}
			System.out.println(found);
	}
	
	public static boolean findString(char[][] matrix, int i,int j,char str[], int index)
	{
		if(i>rowMax || j>colMax)
			return false;
		if(index==str.length)
			return true;
		if(i >=rowMax || j>=colMax || i< 0 || j<0)
			return false;
		//System.out.println("i is : " + i + "   and j is : " + j);
		if(matrix[i][j]==str[index])
		{
			if(!findString(matrix, i,j+1,str, index+1))
			{
				if(!findString(matrix, i+1,j,str, index+1))
				{
					if(!findString(matrix, i-1,j,str, index+1))
					{
						if(!findString(matrix, i,j-1,str, index+1))
						{
							if(!findString(matrix, i-1,j+1,str, index+1))
							{
								if(!findString(matrix, i-1,j-1,str, index+1))
								{
									if(!findString(matrix, i+1,j-1,str, index+1))
									{
										if(!findString(matrix, i+1,j+1,str, index+1))
											return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}	
}
