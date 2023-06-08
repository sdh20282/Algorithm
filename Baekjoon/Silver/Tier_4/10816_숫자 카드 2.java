import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int key = sc.nextInt();
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}

		System.out.println(sb);
		sc.close();
	}

	private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (key <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}

		}

		return lo;
	}

	private static int upperBound(int[] arr, int key) {
		int lo = 0, hi = arr.length;

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (key < arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}

		}

		return lo;
	}
}
