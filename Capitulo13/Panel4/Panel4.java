import javax.swing.* ;
import java.awt.* ;

public class Panel4 {

	public static void main ( String [] args ) {

		Panel4 gui = new Panel4 () ;
		gui.go () ;

	}

	public void go () {

		JFrame frame = new JFrame () ;
		JPanel panel = new JPanel () ;
		panel.setBackground ( Color.darkGray ) ;

		JButton  button = new JButton ( "shock me" ) ;
		JButton  buttonTwo = new JButton ( "bliss" ) ;
		JButton  buttonThree = new JButton ( "huh?" ) ;

		panel.add ( button ) ;
		panel.add ( buttonTwo ) ;
		panel.add ( buttonThree ) ;

		frame.getContentPane().add ( BorderLayout.EAST , panel ) ;
		frame.setSize ( 250 , 200 ) ;
		frame.setVisible ( true ) ;

	}

}