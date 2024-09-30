import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.* ;
import java.awt.event.* ;

public class List1 implements ListSelectionListener {

	String [] listEntries = { "alpha" , "beta" , "gama" , "delta" , "delta" , "epsilon" , "zeta" , "eta" , "theta" } ;
	JList list ;

	public static void main ( String [] args ) {

		List1 gui = new List1 () ;
		gui.go () ;

	}

	public void go () {

		JFrame frame = new JFrame () ;	
		JPanel panel = new JPanel () ;

		list = new JList < String > ( listEntries ) ;
		list.setVisibleRowCount ( 4 ) ;
		list.setSelectionMode ( ListSelectionModel.SINGLE_SELECTION ) ;
		list.addListSelectionListener ( this ) ;

		JScrollPane scroller = new JScrollPane ( list ) ;
		scroller.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ) ;
		scroller.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ) ;
		
		panel.add ( scroller ) ;

		frame.getContentPane().add ( BorderLayout.CENTER, panel ) ;

		frame.setSize ( 350 , 300 ) ;
		frame.setVisible ( true ) ;

	}

	public void valueChanged ( ListSelectionEvent ev ) {

		if ( !list.getValueIsAdjusting () ) {

			String selection = ( String  ) list.getSelectedValue () ;
			System.out.println ( selection ) ;

		}
	
	}

}