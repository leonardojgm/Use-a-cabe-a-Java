class MyOuter {

	private int x ;

	MyInner inner = new MyInner () ;
	
	public void doStuff () {
		inner.go () ;
	}

	class MyInner {

		void go () {

			x = 42 ;

		}

	} // fecha a classe interna

} // fecha a classe externa