import java.io.* ;

class FileTest {

	public static void main ( String [] args ) {

		try {

			File dir = new File ( "Directory" ) ;
			dir.mkdir () ;

			File f = new File ( "Directory/MyCode.txt" ) ;

			FileWriter writer = new FileWriter ( f ) ;
			writer.write ( "hello foo!" ) ;
			writer.close () ;


			if ( dir.isDirectory () ) {

				String [] dirContents = dir.list () ;

				for ( int i = 0 ; i < dirContents.length ; i ++ ) {
	
					System.out.println ( dirContents [ i ] ) ;

				}

			}

			System.out.println ( dir.getAbsolutePath () ) ;

			boolean isDeleted = f.delete () ;

			if ( isDeleted ) {
				
				System.out.println ( "Arquivo Deletado" ) ;
			
			}
		
		} catch ( IOException ex ) {

			ex.printStackTrace () ;
		
		}

	}

}