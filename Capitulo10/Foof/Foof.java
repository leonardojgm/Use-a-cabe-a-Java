class Foof {

	final int size = 3 ; 
	final int whuffie ;

	Foof () {

		whuffie = 42 ;

	}

	void doStuff ( final int x ) {

		// voc� n�o pode alterar x

	}

	void doMore () {

		final int z = 7 ;
		// voc� n�o pode alterar z

	}

	final void calcWhuffie () {

		//coisas importantes
		// que nunca devem ser sobrepostas

	}

}