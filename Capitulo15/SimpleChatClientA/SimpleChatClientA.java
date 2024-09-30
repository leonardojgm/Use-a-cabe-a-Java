import java.io.* ;
import java.net.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class SimpleChatClientA {

	JTextField outgoing ;
	PrintWriter writer ;
	Socket sock ;

	public void go () {

		// cria a gui e registra um ouvinte no botão send
		// chama o método setUpNetworking ()

		JFrame frame = new JFrame ( "Ludicrosly Simple Chat Client" ) ;
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;
		JPanel mainPanel = new JPanel () ;
		outgoing = new JTextField ( 20 ) ;
		JButton sendButton = new JButton ( "Send" ) ;
		sendButton.addActionListener ( new SendButtonListener () ) ;
		mainPanel.add ( outgoing ) ;
		mainPanel.add ( sendButton ) ;
		frame.getContentPane ().add ( BorderLayout.CENTER , mainPanel ) ;
		setUpNetworking () ;
		frame.setSize ( 400 , 500 ) ;
		frame.setVisible ( true ) ;

	} // fecha go

	private void setUpNetworking () {

		try {

			sock = new Socket ( "127.0.0.1" , 5000 ) ;
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

	public static void main ( String [] args ) {

		new SimpleChatClientA().go () ;

	}

} // fecha a classe externa	