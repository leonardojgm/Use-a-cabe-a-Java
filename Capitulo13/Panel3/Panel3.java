import javax.swing.* ;
import java.awt.* ;

public class Panel3 {

	public static void main ( String [] args ) {

		Panel3 gui = new Panel3 () ;
		gui.go () ;

	}

	public void go () {

		JFrame frame = new JFrame () ;
		JPanel panel = new JPanel () ;
		panel.setBackground ( Color.darkGray ) ;

		JButton  button = new JButton ( "shock me" ) ;
		JButton  buttonTwo = new JButton ( "bliss" ) ;

		panel.add ( button ) ;
		panel.add ( buttonTwo ) ;

		frame.getContentPane().add ( BorderLayout.EAST , panel ) ;
		frame.setSize ( 250 , 200 ) ;
		frame.setVisible ( true ) ;

	}

}