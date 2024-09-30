import java.util.* ;

class V3Radiator extends V2Radiator {

	V3Radiator ( ArrayList lglist ) {

		super ( lglist ) ;

		for ( int x = 0 ; x < 10 ; x ++ ) {

			lglist.add ( new SimUnit ( "V3 Radiator" ) )  ;

		}

	}

}