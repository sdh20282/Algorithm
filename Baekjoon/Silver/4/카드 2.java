import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		// 규칙 : (2 * n) - (n보다 같거나 큰 2의 배수)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = 1;
		
		while (k < n) {
			k <<= 1;
		}
		
		System.out.println(2 * n - k);
	}
}
