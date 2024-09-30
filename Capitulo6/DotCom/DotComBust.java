import java.util.* ;

class DotComBust{

	private	GameHelper helper = new GameHelper () ;

	private ArrayList < DotCom > dotComsList = new ArrayList < DotCom > () ;

	private int numOfGuesses = 0 ;

	private void setUpGame () {

		// primeiro cria alguns objetos DotCom e fornece seus locais

		DotCom one = new DotCom () ;
		one.setName ( "Pets.com" ) ;
		DotCom two = new DotCom () ;
		two.setName ( "eToys.com" ) ;
		DotCom three = new DotCom () ;
		three.setName ( "Go2.com" ) ;
		dotComsList.add( one ) ;
		dotComsList.add( two ) ;
		dotComsList.add( three ) ;
		
		System.out.println ( "Seu objetivo é eliminar três dot coms." ) ;
		System.out.println ( "Pets.com, eToys.com, Go2.com" ) ;
		System.out.println ( "Tente eliminar com o menor número de palpites" ) ;

		for ( DotCom dotComToSet : dotComsList ) {

			ArrayList < String > newLocation = helper.placeDotCom ( 3 ) ;
			dotComToSet.setLocationCells ( newLocation ) ;

		} // encerra o loop for

	} // encerra metodo setUpGame

	private void startPlaying () {

		while ( ! dotComsList.isEmpty () ) {
			
			String userGuess = helper.getUserInput ( "Insira um palpite" ) ;
			checkUserGuess ( userGuess ) ;

		} // encerra while

		finishGame () ;

	} // encerra metodo startPlaying

	private void checkUserGuess ( String userGuess ) {

		numOfGuesses ++ ; 
		String result = "errado" ;
	
		for ( DotCom dotComToTest : dotComsList ) {
			
			result = dotComToTest.checkYourself ( userGuess ) ;
			
			if ( result.equals ( "correto" ) ) {
				
				break ;

			}

			if ( result.equals ( "eliminar" ) ) {

				dotComsList.remove ( dotComToTest ) ;
				break ;
		
			}
		
		} // encerra for

		System.out.println ( result ) ;

	} // encerra metodo checkUserGuess

	private void finishGame () {

		System.out.println ( "Todas as Dot Coms foram eliminadas! Agora seu conjunto está vazio." ) ;
	
		if ( numOfGuesses <= 18 ) {
			
			System.out.println ( "Você só usou " + numOfGuesses + " palpites." ) ;
			System.out.println ( "Você saiu ant-es de eliminar suas opções." ) ;
		
		} else {

			System.out.println ( "Demorou demais. " + numOfGuesses + " palpites." ) ;
			System.out.println ( "Não haverá pesca com essas opções." ) ;

		}

	} // encerra metodo finishGame

	public static void main ( String [] args ) {

		DotComBust game = new DotComBust () ;
		game.setUpGame () ;
		game.startPlaying () ;

	} // encerra metodo main

} // encerra class