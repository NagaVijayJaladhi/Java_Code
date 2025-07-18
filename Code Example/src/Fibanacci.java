
public class Fibanacci {

	public static void main(String [] args) {
		int a = 0, b = 1, c = 1; 
		System.out.print(a + " " + b + " ");
		for(int i = 0; i <= 10; i++) {
			c = a + b;
			a = b;
			b = c;
			if(c%2 != 0) {
				System.out.print(c + " ");
			}
		}
	}
}