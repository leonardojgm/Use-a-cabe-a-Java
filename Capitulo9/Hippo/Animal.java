public class Animal {
	
	private String name ;

	public Animal () {

		System.out.println ( "Criando um objeto Animal" ) ;

	}

	public Animal ( String theName ) {

		name = theName ;

	}
	
	public String getName () {

		return name ;	

	}

}