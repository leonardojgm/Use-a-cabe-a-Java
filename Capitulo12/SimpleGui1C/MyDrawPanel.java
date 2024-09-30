import java.awt.* ;
import javax.swing.* ;

class MyDrawPanel extends JPanel {
 
	public void paintComponent ( Graphics g ) {

		Image image = new ImageIcon( "catzilla.jpg" ).getImage () ;
		g.drawImage ( image , 3 , 4 , this ) ;

	}

}