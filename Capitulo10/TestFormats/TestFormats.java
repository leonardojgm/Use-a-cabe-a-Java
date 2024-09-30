import java.util.Date ;

public class TestFormats {

	public static void main ( String [] args ) {

		String s = String.format ( "Tenho %,.2f erros a corrigir.", 476578.09876 ) ;
		System.out.println ( s ) ;

		Date today = new Date () ;
		System.out.println ( String.format ( "%tA , %<tB %<td" , today ) ) ;

	}

}