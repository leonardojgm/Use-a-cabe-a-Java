import java.util.* ;
import java.awt.event.* ;
import javax.swing.* ;
import java.awt.* ;
import java.io.* ;

public class QuizCardBuilder {

	private JTextArea question ;
	private JTextArea answer ;
	private ArrayList < QuizCard > cardList ;
	private JFrame frame ;

	public static void main ( String [] args ) {
		
		QuizCardBuilder builder = new QuizCardBuilder () ;
		builder.go () ;

	}

	public void go () {
		
		// constroi e exibe a GUI

		frame = new JFrame ( "Quiz Card Builder" ) ;
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;
		JPanel mainPanel = new JPanel () ;

		Font bigFont = new Font ( "sanserif" , Font.BOLD , 24 ) ;

		question = new JTextArea ( 6 , 20 ) ;
		question.setLineWrap ( true ) ;
		question.setWrapStyleWord ( true ) ;
		question.setFont ( bigFont ) ;
		
		JScrollPane qScroller = new JScrollPane ( question ) ;
		qScroller.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ) ;
		qScroller.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ) ;
		
		answer = new JTextArea ( 6 , 20 ) ;
		answer.setLineWrap ( true ) ;
		answer.setWrapStyleWord ( true ) ;
		answer.setFont ( bigFont ) ;
		
		JScrollPane aScroller = new JScrollPane ( answer ) ;
		aScroller.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ) ;
		aScroller.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ) ;

		JButton nextButton = new JButton ( "Next Card") ;

		cardList = new ArrayList < QuizCard > () ;
		
		JLabel qLabel = new JLabel ( "Question:" ) ;
		JLabel aLabel = new JLabel ( "Answer:" ) ;
		
		mainPanel.add( qLabel ) ;
		mainPanel.add( qScroller ) ;
		mainPanel.add( aLabel ) ;
		mainPanel.add( aScroller ) ;
		mainPanel.add( nextButton ) ;
		
		nextButton.addActionListener ( new NextCardListener () ) ;
		
		JMenuBar menuBar = new JMenuBar () ;
		JMenu fileMenu = new JMenu ( "File" ) ;
		JMenuItem newMenuItem = new JMenuItem ( "New" ) ;
		JMenuItem saveMenuItem = new JMenuItem ( "Save" ) ;

		newMenuItem.addActionListener ( new NewMenuListener () ) ;
		saveMenuItem.addActionListener ( new SaveMenuListener () ) ;

		fileMenu.add ( newMenuItem ) ;
		fileMenu.add ( saveMenuItem ) ;
		menuBar.add ( fileMenu ) ;

		frame.setJMenuBar ( menuBar ) ;
		frame.getContentPane().add ( BorderLayout.CENTER , mainPanel ) ;
		frame.setSize ( 500 , 600 ) ;
		frame.setVisible ( true ) ;

	}

	private class NextCardListener implements ActionListener {

		public void actionPerformed ( ActionEvent ev ) {

			// adiciona o cartão atual à lista e limpa as áreas de texto
		
			QuizCard card = new QuizCard ( question.getText () , answer.getText () ) ;
			cardList.add ( card ) ;
			clearCard () ;

		}
		
	}
	
	private class SaveMenuListener implements ActionListener {

		public void actionPerformed ( ActionEvent ev ) {
			
			// abre a caixa de diálogo de um arquivo
			// permite que o usuário nomeie e salve o conjunto

			QuizCard card = new QuizCard ( question.getText () , answer.getText () ) ;
			cardList.add ( card ) ;
			clearCard () ;
			
			JFileChooser fileSave = new JFileChooser () ;
			fileSave.showSaveDialog ( frame ) ;
			saveFile ( fileSave.getSelectedFile () ) ;		
	
		}
		
	}

	private class NewMenuListener implements ActionListener {

		public void actionPerformed ( ActionEvent ev ) {

			// Limpa a lista de cartões e as áreas de texto

			cardList.clear () ;
			clearCard () ;

		}
		
	}

	private void clearCard () {

		question.setText ( "" ) ;
		answer.setText ( "" ) ;
		question.requestFocus () ;

	}

	private void saveFile ( File file ) {

		// itera pela lista de cartões e grava cada um em um arquivo de texto
		// de uma maneira analisável ( em outras palavras, com separações claras entre as partes )

		try {

			BufferedWriter writer = new BufferedWriter ( new FileWriter ( file ) ) ;
			
			for ( QuizCard card:cardList ) {
				
				writer.write ( card.getQuestion () + "/" ) ;
				writer.write ( card.getAnswer () + "\r" ) ;
			
			}

			writer.close () ;
		
		} catch ( IOException ex ) {
		
			System.out.println ( "couldn't write the cardList out" ) ;
			ex.printStackTrace () ;

		}

	}

}