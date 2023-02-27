import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int test_cast = 1; test_cast <= t; test_cast++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()), count = 0;
			arr = new int[n + 1];
			
			sb.append("#").append(test_cast).append(" ");
			
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
				union(a, b);
			}
			
			for (int i = 1; i <= n; i++) {
				if (arr[i] == i) {
					count += 1;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int find(int x) {
		if (arr[x] == x) {
			return x;
		}
		
		return (arr[x] = find(arr[x]));
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		arr[x] = y;
	}
}
