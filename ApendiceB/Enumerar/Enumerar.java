public class Enumerar {
		
	// #1 - Enumeração

	public static final int JERRY = 1 ;
	public static final int BOBBY = 2 ;
	public static final int PHIL = 3 ;

	public enum Members { JERRY , BOBBY , PHIL } ;
	public static Members selectedBandMember2 ;

	public static void main ( String [] args ) {
		// posteriormente no código
		
		int selectedBandMember = 1 ;

		if (selectedBandMember == JERRY ) {

			// faz algo relativo a Jerry
			System.out.println ( "1 = Jerry" ) ;

		}

		// posteriormente no código

		selectedBandMember2 = Members.JERRY ;

		if ( selectedBandMember2 == Members.JERRY ) {

			// faz algo relativo a Jerry
			System.out.println ( "JERRY" ) ;

		}

		Members n = Members.BOBBY ;
		
		if ( n.equals ( Members.JERRY ) ) System.out.println ( " Jerrrry!" ) ;
		if ( n == Members.BOBBY ) System.out.println ( "Rat Dog" ) ;

		Members ifName = Members.PHIL ;

		switch ( ifName ) {

			case JERRY: System.out.print ( "make it sing " ) ;
			case PHIL: System.out.print ( "go deep " ) ;
			case BOBBY: System.out.println ( "Cassidy!" ) ;

		}

	}

}