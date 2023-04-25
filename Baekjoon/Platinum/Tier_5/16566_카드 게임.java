import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[] has, put;
	static boolean[] used;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		has = new int[M];
		put = new int[K];
		used = new boolean[M];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			has[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			put[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(has);
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < K; t++) {
			int left = 0, right = M - 1, now = put[t];
			
			while (left < right) {
				int mid = (left + right) / 2;
				
				if (has[mid] <= now) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			
			while (used[left]) {
				left += 1;
			}
			
			used[left] = true;
			sb.append(has[left]).append("\n");
		}
		
		System.out.println(sb);
	}
}
