import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, total, min;
	static ArrayList<Integer>[] cities;
	static int[] populations;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		total = 0;
		min = Integer.MAX_VALUE;
		cities = new ArrayList[n + 1];
		populations = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < n + 1; i++) {
			cities[i] = new ArrayList<>();
			populations[i] = Integer.parseInt(st.nextToken());
			total += populations[i];
		}
		
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < repeat; j++) {
				cities[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		visited = new boolean[n + 1];
		
		for (int i = 1; i <= n / 2; i++) {
			dfs(0, 1, i, 0);
		}
		
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}
	
	static void dfs(int cur, int start, int end, int sum) {
		if (cur == end) {
			if (!connected(true)) {
				return;
			}
			
			if (!connected(false)) {
				return;
			}
			
			if (Math.abs(total - sum - sum) < min) {
				min = Math.abs(total - sum - sum);
			}
			
			return;
		}
		
		for (int i = start; i < n + 1; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			dfs(cur + 1, i + 1, end, sum + populations[i]);
			visited[i] = false;
		}
	}
	
	static boolean connected(boolean flag) {
		ArrayList<Integer> linkedCities = new ArrayList<>();
		
		for (int i = 1; i < n + 1; i++) {
			if (visited[i] == flag) {
				linkedCities.add(i);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(linkedCities.remove(0));
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int next : cities[now]) {
				if (!linkedCities.contains(next)) {
					continue;
				}
				
				q.offer(next);
				linkedCities.remove(linkedCities.indexOf(next));
			}
		}
		
		if (linkedCities.size() == 0) {
			return true;
		}
		
		return false;
	}
}
