public class TestExceptions {

	public static void main ( String [] args ) {

		String test = "yes" ;

		try {

			System.out.println ( "Start try" ) ;
			doRisky ( test ) ;
			System.out.println ( "End try" ) ;

		} catch ( ScaryException ex ) {

			System.out.println ( "scary exception" ) ;

		} finally {

			System.out.println ( "finally" ) ;
		
		}

		System.out.println ( "end of main" ) ;
	
	}

	static void doRisky ( String test ) throws ScaryException {

		System.out.println ( "Start risky" ) ;
		
		if ( "yes".equals ( test ) ) {
		
			throw new ScaryException () ;

		}

		System.out.println ( "End risky" ) ;
		return ;
	
	}

}



