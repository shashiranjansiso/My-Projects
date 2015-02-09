package permutation;

public class AllCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combine("wxyz");
	}
	
	static void combine(String str ){
		int length = str.length();
		char[] instr = str.toCharArray(); 
		StringBuilder outstr = new StringBuilder();
		doCombine( instr, outstr, length, 0 ); 
	}
	
	static void doCombine( char[] instr, StringBuilder outstr, int length, int start ){
		for( int i = start; i < length; i++ ){ 
			outstr.append( instr[i] ); 
			System.out.println(outstr);
			if( i < length - 1 ){
				doCombine( instr, outstr, length, i + 1 );
			}
			outstr.setLength(outstr.length() - 1);
		}
	}

}
