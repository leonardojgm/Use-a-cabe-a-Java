class TestSync implements Runnable {

	private int balance ;

	public void run () {

		for ( int i = 0 ; i < 50 ; i ++ ) {

			increment () ;

		}

	}

	public synchronized void increment () {

		int i = balance ;
		balance = i + 1 ;
		System.out.println ( "balance is " + balance ) ;
	}

}
