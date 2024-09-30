class Foo {

	// #4 - N�veis de acesso e modificadores de acesso

	public static void main ( String [] args ) {

		new Foo().go () ;
	
	}
		
	void go () {

		// nesse local estar� o que REALMENTE queremos...

		// #10 - Manipula��o de bits

		int x = 10 ; // os bits s�o 00001010
		x = ~x ; // agora os bits s�o 11110101 
		System.out.println ( "x = " + x ) ;

		x = 10 ; // os bits s�o 00001010
		int y = 6 ; // os bits s�o 00000110
		
		int a = x & y ; // os bits s�o 00000010
		System.out.println ( "y = " + y + ", x = " + x + ", a = " + a ) ;

		a = x ^ y ; // is buts s�o 00001100
		System.out.println ( "y = " + y + ", x = " + x + ", a = " + a ) ;

		x = -11 ; // os bits s�o 11110101
		y = x >> 2 ; // os bits s�o 11111101
		System.out.println ( "y = " + y + ", x = " + x ) ;

		y = x >>> 2 ; // os bits s�o 00111101
		System.out.println ( "y = " + y + ", x = " + x ) ;

		y = x << 2 ; // os bits s�o 11010100
		System.out.println ( "y = " + y + ", x = " + x ) ;

		// #9 - Imutabilidade - String e Empacotadores

		Integer iWrap = new Integer (42) ;
		String s = "0" ;

		// #8 - Asser��es

		assert ( true ) : "x = " + x ;
		assert ( x > y ) : "y = " + y + ", x = " + x + ", a = " + a ;

		// #7 - Escopo de bloco {}

		for ( int i = 1 ; i < 10 ; i ++ ) {

			s = s + i ;
			System.out.println ( "s = " + s + ", i = " + i ) ;

		}

 		// #6 - Chamadas encadeadas
		// #3 - Metodos de String e String Buffer/String Builder 

		StringBuffer sb = new StringBuffer ( "spring" ) ;
		sb = sb.delete ( 3 , 6 ) .insert ( 2 , "umme" ) .deleteCharAt ( 1 ) ;
		System.out.println ( "sb = " + sb ) ;
		// o resultado � sb = summer

		StringBuffer sb2 = new StringBuffer ( "spring" ) ;
		sb2 = sb2.delete ( 3 , 6 ) ;
		sb2 = sb2.insert ( 2 , "umme" ) ; 
		sb2 = sb2.deleteCharAt ( 1 ) ;
		System.out.println ( "sb2 = " + sb2 ) ;
		// o resultado � sb = summer
		
		// #2 - Matrizes multidimensionais
		
		int [] [] a2d = new int [ 4 ] [ 2 ] ;

		int q = a2d [ 2 ] [ 1 ] ; // lembre-se, come�ando em 0!

		int [] [] w =  { { 2 , 3 , 4 } , { 7 , 8 , 9 } } ;

		int [] [] z = new int [ 2 ] [] ; // cria somente a primeira matriz, com tamanho igual a 2
		z [ 0 ] = new int [ 3 ] ; // faz a primeira submatriz ter 3 elementos de dimens�o
		z [ 1 ] = new int [ 5 ] ; // faz a primeira submatriz ter 5 elementos de dimens�o 


	}

}