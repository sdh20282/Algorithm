import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		int K = sc.nextInt();

		int div = S / K;
		int mod = S % K;
		
		long max = 1;
		
		for (int i = 1; i <= K; i++) {
			if (i <= mod) {
				max *= (div + 1);
			} else {
				max *= div;
			}
		}
		
		System.out.println(max);
		sc.close();
	}
}