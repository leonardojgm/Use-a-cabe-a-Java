public class GC {

	public static GC doStuff () {

		GC newGC = new GC () ;
		doStuff2 ( newGC ) ;
		return newGC ;

	}

	public static void main ( String [] args ) {

		GC gc1 ;
		GC gc2 = new GC () ;
		GC gc3 = new GC () ;
		GC gc4 = gc3 ;
		gc1 = doStuff () ;

//errado	copyGC = null ;
//certo 	gc2 = null ;
//errado 	newGC = gc3 ;
//certo 	gc1 = null ;
//errado 	newGC = null ;
//errado	gc4 = null ;
//errado 	gc3 = gc2 ;
//certo		gc1 = gc4 ;
//errado	gc3 = null ;

		// chama mais métodos
	}

	public static void doStuff2 ( GC copyGC ) {

		GC localGC = copyGC ;
	
	}

}		