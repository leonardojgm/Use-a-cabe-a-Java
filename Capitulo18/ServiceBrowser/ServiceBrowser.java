import java.awt.* ;
import javax.swing.* ;
import java.rmi.* ;
import java.awt.event.* ;

public class ServiceBrowser {

	JPanel mainPanel ;
	JComboBox < Object > serviceList ;
	ServiceServer server ;

	public void buildGUI () {

		JFrame frame = new JFrame ( "RMI Browser" ) ;
		mainPanel = new JPanel () ;
		frame.getContentPane().add ( BorderLayout.CENTER , mainPanel ) ;
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;

		Object [] services = getServicesList () ;

		serviceList = new JComboBox < Object > ( services ) ;
		
		frame.getContentPane().add ( BorderLayout.NORTH , serviceList ) ;

		serviceList.addActionListener ( new MyListListener () ) ;

		frame.setSize ( 500 , 500 ) ;
		frame.setVisible ( true ) ;

	}

	void loadService ( Object serviceSelection ) {

		try {

			Service svc = server.getService ( serviceSelection ) ;
			
			mainPanel.removeAll () ;
			mainPanel.add ( svc.getGuiPanel () ) ;
			mainPanel.validate () ;
			mainPanel.repaint () ;

		} catch ( Exception ex ) {
	
			ex.printStackTrace () ;

		}

	}

	Object [] getServicesList () {

		Object obj = null ;
		Object [] services = null ;
	
		try {

			obj = Naming.lookup ( "rmi://127.0.0.1/ServiceServer" ) ;
		
		} catch ( Exception ex ) {

			ex.printStackTrace () ;

		}

		server = ( ServiceServer ) obj ;
	
		try {

			services = server.getServiceList () ;
		
		} catch ( Exception ex ) {

			ex.printStackTrace () ;

		}

		return services ;

	}

	class MyListListener implements ActionListener {

		public void actionPerformed ( ActionEvent ev ) {

			Object selection = serviceList.getSelectedItem () ;
			loadService ( selection ) ;

		}

	}

	public static void main ( String [] args ) {

		new ServiceBrowser().buildGUI () ;

	}

} 