import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int prev = 0, sum = 0;

		for (int i = 0; i < N; i++) {
			sum += prev + arr[i];
			prev += arr[i];
		}
		
		System.out.println(sum);
		sc.close();
	}
}
