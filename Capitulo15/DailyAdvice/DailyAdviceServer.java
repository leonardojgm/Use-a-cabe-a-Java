import java.io.* ;
import java.net.* ;

public class DailyAdviceServer {

	String [] adviceList = { "Morda peda�os menores." , "Use o jeans apertado. N�o, ele N�o faz voce parecer gorda." , "S� vou dizer uma palavra: inapropriado." , "Pelo menos hoje, seja honesta. Diga a seu chefe o que realmente pensa." , "Reconsidere esse corte de cabelo." } ;

	public void go () {

		try {

			ServerSocket serverSock = new ServerSocket (4242) ;

			while ( true ) {

				Socket sock = serverSock.accept () ;
				PrintWriter writer = new PrintWriter ( sock.getOutputStream () ) ;	 
				String advice = getAdvice () ;
				writer.println ( advice ) ;
				writer.close () ;
				System.out.println ( advice ) ;

			}

		} catch ( IOException ex ) {

			ex.printStackTrace () ;

		}

	} // fecha go

	private String getAdvice () {

		int random = ( int ) ( Math.random () * adviceList.length ) ;
		return ( adviceList [ random ] ) ;

	}

	public static void main ( String [] args ) {

		DailyAdviceServer server = new DailyAdviceServer () ;
		server.go () ;

	}

}