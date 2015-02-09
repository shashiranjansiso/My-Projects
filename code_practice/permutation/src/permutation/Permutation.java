package permutation;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permute("hat");
	}
	
	static void permute( String str ){
		int length = str.length(); 
		boolean[] used = new boolean[ length ]; 
		StringBuffer out = new StringBuffer(); 
		char[] in = str.toCharArray();
		doPermute( in, out, used); 
	}
	
	static void doPermute( char[] in, StringBuffer out,
		boolean[] used)
	{
		if( out.length() == in.length ){
			System.out.println( out.toString() ); return;
		}
		for( int i = 0; i < in.length; i++ ){ 
			if( used[i] ) 
				continue;
		out.append( in[i]);
		used[i] = true;
		doPermute( in, out, used); used[i] = false;
		out.setLength( out.length() - 1 );
		} 
	}

}
