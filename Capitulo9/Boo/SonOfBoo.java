class SonOfBoo extends Boo {

	public SonOfBoo () {

		super ( "boo" ) ;

	}

	public SonOfBoo ( int i ) {

		super ( "Fred" ) ;

	}

	public SonOfBoo (String s) {

		super ( 42 ) ;

	}

//erro	public SonOfBoo ( int i , String s ) {

//erro	}

//erro	public SonOfBoo ( String a , String b , String c ) {

//erro		super ( a , b ) ;

//erro	}

	public SonOfBoo ( int i , int j ) {

		super ( "man" , j ) ;

	}

//erro	public SonOfBoo ( int i , int x , int y ) {

//erro		super ( i , "star" ) ;

//erro	}

}