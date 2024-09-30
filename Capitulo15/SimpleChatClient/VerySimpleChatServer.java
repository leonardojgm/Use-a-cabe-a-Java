import java.io.* ;
import java.net.* ;
import java.util.* ;

public class VerySimpleChatServer {

	ArrayList < PrintWriter > clientOutputStreams ;

	public class ClientHandler implements Runnable {

		BufferedReader reader ;
		Socket sock ;

		public ClientHandler ( Socket clientSocket ) {

			try {
	
				sock = clientSocket ;
				InputStreamReader isReader = new InputStreamReader ( sock.getInputStream () ) ;
				reader = new BufferedReader ( isReader ) ;

			} catch ( Exception ex ) { ex.printStackTrace () ; }

		} // fecha o construtor

		public void run () {

			String message ;

			try {

				while ( ( message = reader.readLine () ) != null ) {

					System.out.println ( "read " + message ) ;
					tellEveryone ( message ) ;

				} // fecha while

			} catch ( Exception ex ) { ex.printStackTrace () ; }
		
		} // fecha run

	} // fecha a classe interna

	public static void main ( String [] args ) {

		new VerySimpleChatServer().go () ;

	}

	public void go () {

		clientOutputStreams = new ArrayList < PrintWriter > () ;

		try {

			ServerSocket serverSock = new ServerSocket ( 5000 ) ;
			while ( true ) {
				
				Socket clientSocket = serverSock.accept () ;
				PrintWriter writer = new PrintWriter ( clientSocket.getOutputStream () ) ;
				clientOutputStreams.add ( writer ) ;
				Thread t = new Thread ( new ClientHandler ( clientSocket ) ) ;
				t.start () ;
				System.out.println ( "got a connection" ) ;

			}
		
		} catch ( Exception ex ) { ex.printStackTrace () ; }

	} // fecha go

	public void tellEveryone ( String message ) {

		Iterator it = clientOutputStreams.iterator () ;

		while ( it.hasNext () ) {

			try {

				PrintWriter writer = ( PrintWriter ) it.next () ;
				writer.println ( message ) ;
				writer.flush () ;

			} catch ( Exception ex ) { ex.printStackTrace () ; }

		} // end while

	} // fecha tellEveryone

} // fecha class