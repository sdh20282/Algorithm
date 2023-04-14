import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int K;
	public final static long P = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			long number = factorial(N);
			long demon = (factorial(K) * factorial(N - K)) % P;
			
			System.out.println("#" + t + " " + (number * pow(demon, P - 2)) % P);
		}
	}
	
	public static long factorial(int n) {
		long rst = 1;
		
		for (int i = n; i > 1; i--) {
			rst = (n * rst) % P;
			n -= 1;
		}
		
		return rst;
	}
	
	public static long pow(long base, long exponent) {
		long rst = 1;
		
		while (exponent > 0) {
			if (exponent % 2 == 1) {
				rst *= base;
				rst %= P;
			}
			
			base = (base * base) % P;
			exponent /= 2;
		}
		
		return rst;
	}
}
