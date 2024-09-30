class SimUnit {
	
	String botType ;
	
	SimUnit ( String type ) {

		botType = type;
		System.out.println ( "SimUnit Criada para " + type ) ;

	}

	int powerUse () {

		if ( "Retention".equals ( botType ) ) {

			return 2 ;

		} else {

			return 4 ;

		}

	}

}