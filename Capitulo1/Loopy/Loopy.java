public class Loopy {
	public static void main (String[] args) {
		int x =  1;
		System.out.println ("Antes do Loop");
		while (x < 4) {
			System.out.println("No loop");
			System.out.println("O valor de x � " + x);
			x = x + 1;
		}
		while (x == 4) {
			System.out.println("No loop");
			System.out.println("O valor de x � " + x);
			x = x + 1;
		}
		System.out.println("Esse � o fim do loop");
	}
}	
			