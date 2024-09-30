import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class TextField1 implements ActionListener {

	JTextField field ;
	JTextField field2 ;

	public static void main ( String [] args ) {

		TextField1 gui = new TextField1 () ;
		gui.go () ;

	}

	public void go () {

		JFrame frame = new JFrame () ;
		JPanel panel = new JPanel () ;

		JLabel label = new JLabel ( "Dog's first name: " ) ;

		field = new JTextField ( 20 ) ;
		field.addActionListener ( this ) ;
		field2 = new JTextField ( "Your name" ) ;
		
		panel.add ( label ) ;
		panel.add ( field ) ;

		frame.getContentPane().add ( BorderLayout.NORTH , panel ) ;
		frame.getContentPane().add ( BorderLayout.SOUTH , field2 ) ;

		frame.setSize ( 350 , 300 ) ;
		frame.setVisible ( true ) ;

	}
	
	public void actionPerformed ( ActionEvent ev ) {
		
		System.out.println ( field.getText () ) ;
		field2.setText ( "Whatever" ) ;
		field.setText ( "" ) ;
		field2.requestFocus () ;
		field2.selectAll () ;
	
	}

}