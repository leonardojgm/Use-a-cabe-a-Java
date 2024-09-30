import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class CheckBox1 implements ItemListener {

	JCheckBox check ;
	JCheckBox check2 ;

	public static void main ( String [] args ) {

		CheckBox1 gui = new CheckBox1 () ;
		gui.go () ;

	}

	public void go () {

		JFrame frame = new JFrame () ;
		JPanel panel = new JPanel () ;

		check = new JCheckBox ( "Goes to 11" ) ;
		check2 = new JCheckBox ( "Goes to 12" ) ;
		check.addItemListener ( this ) ;
		
		panel.add ( check ) ;
		panel.add ( check2 ) ;

		frame.getContentPane().add ( BorderLayout.NORTH , panel ) ;

		frame.setSize ( 350 , 300 ) ;
		frame.setVisible ( true ) ;

	}

	public void itemStateChanged ( ItemEvent ev ) {
		
		String onOrOff = "off" ;

		if ( check.isSelected () ) {

			onOrOff = "on" ;
			check2.setSelected ( true ) ;

		} else {

			check2.setSelected ( false ) ;

		}

		System.out.println ( " Check box is " + onOrOff ) ;
	
	}

}