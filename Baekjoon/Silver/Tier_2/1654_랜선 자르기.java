import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K, N, max;
	static long[] lines;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lines = new long[K];
		
		for (int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}
		
		long left = 0, right = (long)Integer.MAX_VALUE + 1;
		
		while (left < right) {
			long mid = (left + right) / 2, count = 0;
			
			for (int i = 0; i < K; i++) {
				count += lines[i] / mid;
			}
			
			if (count < N) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left - 1);
	}
} 
