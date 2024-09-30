import java.io.* ;
import java.util.* ;

public class GameHelper {
	
	private static final String alphabet = "abcdefg" ;
	private int gridLength = 7 ;
	private int gridSize = 49 ;
	private int [] grid = new int [ gridSize ] ;
	private int comCount = 0 ;	

	public String getUserInput ( String prompt ) {

		String inputLine = null ;

		System.out.print ( prompt + " " ) ;

		try {

			BufferedReader is = new BufferedReader ( new InputStreamReader ( System.in ) ) ;
			inputLine = is.readLine () ;

			if ( inputLine.length () == 0 ) return null ;

		} catch ( IOException e ) {

			System.out.println ( "IOException: " + e ) ;
		
		} 

		return inputLine.toLowerCase () ;

	}

	public ArrayList < String > placeDotCom ( int comSize ) {

		ArrayList < String > alphaCells = new ArrayList < String > () ;
		String [] alphacoords = new String [ comSize ] ; // contém as coordenadas de tipo 'f6'
		String temp = null ; // String temporária para concatenação
		int [] coords = new int [ comSize ] ; // coordenada dos candidatos atuais
		int attempts = 0 ; // contador das tentativas atuais
		boolean success = false ; // flag = encontrou um bom local ?
		int location = 0 ; // local inicial atual
		comCount ++ ; // enésima dot com a inserir
		int incr = 1 ; // configura o incremento horizontal
		
		if ( ( comCount % 2 ) == 1 ) { // se dot com ímpar ( inserir verticalmente )
			
			incr = gridLength ; // configura o incremento vertical
		}

		while ( ! success & attempts ++ < 200 ) { // loop de pesquisa principal (32)

			location = ( int ) ( Math.random () * gridSize ) ; // captura ponto inicila aleatório
			// System.out.print ( " try " + location ) ; 
			int x = 0 ; // enésima posição de dot com a inserir
			success = true ; // presume sucesso
			
			while  ( success && x < comSize ) { // procura locais adjacentes não utilizados

				if ( grid [ location ] == 0 ) { // se ainda não tiverem sendo usados

					coords [ x ++ ] = location ; // salva o local
					location += incr ; // tenta o 'próximo' local adjacente
					
					if ( location >= gridSize ) { // fora dos limites - 'embaixo'

						success = false ; // falha 
					
					}

					if ( x > 0 && ( location % gridLength == 0 ) ) { // fora dos limites - canto direito

						success = false ; // falha
			
					}
			
				} else { // encontrou local já utilizado

					// System.out.print ( " used " + location ) ;
					success = false ; // falha

				}
			
			}
		
		} // fim de while

		int x = 0 ;
		int row = 0 ;
		int column = 0 ;
		// System.out.println ( "\n" ) ;
		
		while ( x < comSize ) {
			
			grid [ coords [x] ] = 1 ; // marca os pontos da grade como 'usados'
			row = ( int ) ( coords [ x ] / gridLength ) ; // captura o valor da linha
			column = coords [ x ] % gridLength ; // captura o valor numérico da coluna
			temp = String.valueOf ( alphabet.charAt ( column ) ) ; // converte em alfabético5
			alphaCells.add ( temp.concat ( Integer.toString ( row ) ) ) ;
			x ++ ;
			// System.out.print ( " coord " + x + " = " + alphaCells.get ( x - 1 ) ) ;
		
		}
		
		// System.out.println ( "\n" ) ;
		return alphaCells ;

	}

}
		