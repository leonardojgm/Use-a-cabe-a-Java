import java.util.* ;
import java.awt.event.* ;
import javax.swing.* ;
import java.awt.* ;
import java.io.* ;

public class QuizCardPlayer {

	private JTextArea display ;
	private JTextArea answer ;
	private ArrayList < QuizCard > cardList ;
	private QuizCard currentCard ;
	private int currentCardIndex ;
	private JFrame frame ;
	private JButton nextButton ;
	private boolean isShowAnswer ;

	public static void main ( String [] args ) {

		QuizCardPlayer reader = new QuizCardPlayer () ;
		reader.go () ;

	}

	public void go () {

		// constr�i e exibe a gui

		frame = new JFrame ( "Quiz Card Player" ) ;
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;
		JPanel mainPanel = new JPanel () ;
		Font bigFont = new Font ( "sanserif" , Font.BOLD , 24 ) ;
		
		display = new JTextArea ( 10 , 20 ) ;
		display.setFont ( bigFont ) ;
		
		display.setLineWrap ( true ) ;
		display.setEditable ( false ) ; 

		JScrollPane qScroller = new JScrollPane ( display ) ;
		qScroller.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ) ;
		qScroller.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ) ;

		nextButton = new JButton ( "Show Question" ) ;

		mainPanel.add ( qScroller ) ;
		mainPanel.add ( nextButton ) ;

		nextButton.addActionListener ( new NextCardListener () ) ;
		
		JMenuBar menuBar = new JMenuBar () ;
		JMenu fileMenu = new JMenu ( "File" ) ;
		JMenuItem loadMenuItem = new JMenuItem ( "Load card set" ) ;
		loadMenuItem.addActionListener ( new OpenMenuListener () ) ;
		fileMenu.add ( loadMenuItem ) ;
		menuBar.add ( fileMenu ) ;
		
		frame.setJMenuBar ( menuBar ) ;
		frame.getContentPane().add ( BorderLayout.CENTER , mainPanel ) ;
		frame.setSize ( 640 , 500 ) ;
		frame.setVisible ( true ) ;	

	} // fecha go

	class NextCardListener implements ActionListener {

		public void actionPerformed ( ActionEvent ev ) {

			// se essa for uma pergunta, mostre a resposta, caso contr�rio exiba a pr�xima pergunta
			// configura um flag que indicar� se estamos visualizando uma pergunta ou resposta

			if ( isShowAnswer ) {

				// exibe a resposta porque a pergunta j� foi vista
				
				display.setText ( currentCard.getAnswer () ) ;
				nextButton.setText ( "Next Card" ) ;
				isShowAnswer = false ;
			} else {

				// exibe pr�xima pergunta
			
				if ( currentCardIndex < cardList.size () ) {

					showNextCard () ;

				} else {

					// n�o h� mais cart�es!
	
					display.setText ( "Thats was last card" ) ;
					nextButton.setEnabled ( false ) ;

				}

			}

		}

	}

	class OpenMenuListener implements ActionListener {

		public void actionPerformed ( ActionEvent ev ) {

			// abre a caixa de di�logo de um arquivo
			// permite que o usu�rio navegue e selecione um conjunto de cart�es a ser aberto

			JFileChooser fileOpen = new JFileChooser () ;
			fileOpen.showOpenDialog ( frame ) ;
			loadFile ( fileOpen.getSelectedFile () ) ;
		
		}

	}

	private void loadFile ( File file ) {

		// deve construir um ArrayList de cart�es, lendo-os em um arquivo de texto
		// chamado pelo manipulador de eventos de OpenMenuListener, l� o arquivo uma linha de cada vez
		// e solicita ao m�todo makeCard () que crie um novo cart�o a partir da linha
		// ( uma linha do campo conter� tanto a pergunta quanto a resposta, separadas por um s�mbolo "/" )

		cardList = new ArrayList < QuizCard > () ;
		
		try {

			currentCardIndex = 0 ;
			cardList.clear () ;
			nextButton.setEnabled ( true ) ;

			BufferedReader reader = new BufferedReader ( new FileReader ( file ) ) ;
			String line = null ;
			
			while ( ( line = reader.readLine () ) != null ) {
				System.out.println ( line ) ;
				makeCard ( line ) ;
			
			}
			
			reader.close () ;

		} catch ( Exception ex ) {
			
			System.out.println ( "couldn't read the card file" ) ;
			ex.printStackTrace () ;

		}

		// agora � hora de iniciar exibindo a primeira carta

		showNextCard () ;

	}

	private void makeCard ( String lineToParse ) {

		// chamado pelo m�todo loadFile, pega uma linha do arquivo de texto,
		// a divide em duas partes - pergunta e respo - cria um novo QuizCard
		// e o adiciona � ArrayList chamada CardList

		String [] result = lineToParse.split ( "/" ) ;
		QuizCard card = new QuizCard ( result [0] , result [1] ) ;
		cardList.add ( card ) ;
		System.out.println ( "made a card" ) ;
		
	}

	private void showNextCard () {
		
		currentCard = cardList.get ( currentCardIndex ) ;
		currentCardIndex ++ ;
		display.setText ( currentCard.getQuestion () ) ;
		nextButton.setText ( "Show Answer" ) ;
		isShowAnswer = true ;
	
	}

} // fecha class