import java.awt.* ;
import javax.swing.* ;

public class SimpleGui2 {

	JFrame frame ;

	public static void main ( String [] args ) {

		SimpleGui2 gui = new SimpleGui2 () ;
		gui.go () ;
	
	}

	public void go () {

		frame = new JFrame () ;
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;

		MyDrawPanel drawPanel = new MyDrawPanel () ;

		frame.getContentPane().add ( drawPanel ) ;

		frame.setSize ( 300 , 300 ) ;
		frame.setVisible ( true ) ;
	
	}

}