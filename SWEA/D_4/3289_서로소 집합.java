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
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			
			sb.append("#").append(test_cast).append(" ");
			
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
				if (command == 0) {
					union(a, b);
				} else {
					sb.append(check(a, b));
				}
			}
			
			sb.append("\n");
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
	
	static int check(int x, int y) {
		return ((x = find(x)) == (y = find(y))) ? 1 : 0;
	}
}
