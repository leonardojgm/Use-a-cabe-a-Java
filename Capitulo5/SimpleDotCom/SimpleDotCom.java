public class SimpleDotCom {

	int[] locationCells ;
	int numOfHits = 0 ;

	public void setLocationCells ( int[] locs ) {

		locationCells = locs ;

	}

	public String checkYourself ( String stringGuess ) {

		int guess = Integer.parseInt ( stringGuess ) ;

		String result = "miss" ;

		for ( int cell : locationCells ) {

			if ( guess == cell ) {

				result = "hit" ;

				numOfHits++ ;

				break ;

			} // fim do teste if

		} // fora do loop for

		if ( numOfHits == locationCells.length ) {
			
			result = "kill" ;

		} // fim do teste if

		System.out.println ( result ) ;
		
		return result ;
	
	} // fecha o m�todo

} // fecha a classe