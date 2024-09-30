class SimpleDotComGame {

	public static void main ( String[] args ) {

		int numOfGuesses = 0 ;
		
		GameHelper helper = new GameHelper () ;
		
		SimpleDotCom theDotCom = new SimpleDotCom () ;

		int randomNum = ( int ) ( Math.random () * 5 ) ;

		int[] locations = { randomNum, randomNum + 1, randomNum + 2 } ;

		theDotCom.setLocationCells ( locations ) ;

		boolean isAlive = true ;

		while ( isAlive == true ) {

			String guess = helper.getUserInput ( "insira um número" ) ;

			String result = theDotCom.checkYourself ( guess ) ;

			numOfGuesses++ ;
		
			if ( result.equals ( "kill" ) ) {

				isAlive = false ;

				System.out.println ( "Você usou " + numOfGuesses + " palpites" ) ;
			
			} // encerra a instrução if

		} // encerra while

	} // encerra main

} // encerra class