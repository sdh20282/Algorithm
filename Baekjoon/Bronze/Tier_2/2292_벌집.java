import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 1, range = 2;

		if (N == 1) {
			System.out.print(1);
		} else {
			while (range <= N) {
				range = range + (6 * count);
				count++;
			}
			
			System.out.print(count);
		}
		
		sc.close();
	}
}
