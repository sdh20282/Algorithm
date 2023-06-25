import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(), count = 0;

		for (int i = 0; i < N; i++) {
			boolean isPrime = true;

			int num = sc.nextInt();

			if (num == 1) {
				continue;
			}
			
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					isPrime = false;
					
					break;
				}
			}
			
			if (isPrime) {
				count++;
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}
