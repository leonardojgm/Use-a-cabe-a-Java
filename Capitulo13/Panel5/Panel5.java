import javax.swing.* ;
import java.awt.* ;

public class Panel5 {

	public static void main ( String [] args ) {

		Panel5 gui = new Panel5 () ;
		gui.go () ;

	}

	public void go () {

		JFrame frame = new JFrame () ;
		JPanel panel = new JPanel () ;
		panel.setBackground ( Color.darkGray ) ;

		panel.setLayout ( new BoxLayout ( panel , BoxLayout.Y_AXIS ) ) ;

		JButton  button = new JButton ( "shock me" ) ;
		JButton  buttonTwo = new JButton ( "bliss" ) ;

		panel.add ( button ) ;
		panel.add ( buttonTwo ) ;

		frame.getContentPane().add ( BorderLayout.EAST , panel ) ;
		frame.setSize ( 250 , 200 ) ;
		frame.setVisible ( true ) ;

	}

}