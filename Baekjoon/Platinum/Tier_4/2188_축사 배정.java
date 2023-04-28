import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] list;
	static boolean[] check;
	static int[] connect;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		check = new boolean[M + 1];
		connect = new int[M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < s; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(check, false);
			
			if (dfs(i)) {
				count += 1;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean dfs(int now) {
		for (int next : list[now]) {
			if (!check[next]) {
				check[next] = true;
				
				if (connect[next] == 0 || dfs(connect[next])) {
					connect[next] = now;
					return true;
				}
			}
		}
		
		return false;
	}
}
