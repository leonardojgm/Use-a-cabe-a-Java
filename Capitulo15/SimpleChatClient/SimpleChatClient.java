import java.io.* ;
import java.net.* ;
import java.util.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class SimpleChatClient {

	JTextArea incoming ;
	JTextField outgoing ;
	BufferedReader reader ;
	PrintWriter writer ;
	Socket sock ;

	public static void main ( String [] args ) {

		SimpleChatClient client = new SimpleChatClient () ;
		client.go () ;

	}

	public void go () {

		// cria a gui e registra um ouvinte no botão send
		// chama o método setUpNetworking ()

		JFrame frame = new JFrame ( "Ludicrosly Simple Chat Client" ) ;
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;
		JPanel mainPanel = new JPanel () ;
		incoming = new JTextArea ( 15 , 50 ) ;
		incoming.setLineWrap ( true ) ;
		incoming.setWrapStyleWord ( true ) ;
		incoming.setEditable ( false ) ;
		JScrollPane qScroller = new JScrollPane ( incoming ) ;
		qScroller.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ) ;
		qScroller.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ) ;
		outgoing = new JTextField ( 20 ) ;
		JButton sendButton = new JButton ( "Send" ) ;
		sendButton.addActionListener ( new SendButtonListener () ) ;
		mainPanel.add ( qScroller ) ;
		mainPanel.add ( outgoing ) ;
		mainPanel.add ( sendButton ) ;
		
		setUpNetworking () ;

		Thread readerThread = new Thread ( new IncomingReader () ) ;
		readerThread.start () ;

		frame.getContentPane ().add ( BorderLayout.CENTER , mainPanel ) ;
		frame.setSize ( 600 , 500 ) ;
		frame.setVisible ( true ) ;

	} // fecha go

	private void setUpNetworking () {

		try {

			sock = new Socket ( "127.0.0.1" , 5000 ) ;
			InputStreamReader streamReader = new InputStreamReader ( sock.getInputStream () ) ;
			reader = new BufferedReader ( streamReader ) ;
			writer = new PrintWriter ( sock.getOutputStream () ) ;
			System.out.println ( "networking established" ) ;
		
		} catch ( IOException ex ) {

			ex.printStackTrace () ;

		}

	} // fecha setUpNetworking

	public class SendButtonListener implements ActionListener {

		public void actionPerformed ( ActionEvent ev ) {

			try {

				writer.println ( outgoing.getText () ) ;
				writer.flush () ;
	
			} catch ( Exception ex ) {

				ex.printStackTrace () ;

			}

			outgoing.setText ( "" ) ;
			outgoing.requestFocus () ;

		}

	} // fecha a classe interna SendButtonListener

	public class IncomingReader implements Runnable {

		public void run () {

			String message ;

			try {

				while ( ( message = reader.readLine () ) != null ) {

					System.out.println ( "read " + message ) ;
					incoming.append ( message + "\n" ) ;

				} // fecha while

			} catch ( Exception ex ) { ex.printStackTrace () ; }
		
		} // fecha run

	} // fecha a classe interna IncomingReader

} // fecha a classe externa