import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] res = new int[6][3];
	static int[][] com = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
	static int ans;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 0 ; t < 4; t++) {
			cnt = 0;
			ans = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					res[i][j] = Integer.parseInt(st.nextToken());
					cnt += res[i][j];
				}
			}			
			
			if(cnt == 30) {
				count(0);
			}
			
			System.out.print(ans + " ");
		}
		
		System.out.println();
	}
	
	private static void count(int cur) {
		if (cur == 15) {
			check();
			return;
		}
		
		int[] now = com[cur];
		
		if (res[now[0]][0] > 0 && res[now[1]][2] > 0) {
			res[now[0]][0] -= 1;
			res[now[1]][2] -= 1;
			count(cur + 1);
			res[now[0]][0] += 1;
			res[now[1]][2] += 1;
		}
		
		if (res[now[0]][1] > 0 && res[now[1]][1] > 0) {
			res[now[0]][1] -= 1;
			res[now[1]][1] -= 1;
			count(cur + 1);
			res[now[0]][1] += 1;
			res[now[1]][1] += 1;
		}
		
		if (res[now[0]][2] > 0 && res[now[1]][0] > 0) {
			res[now[0]][2] -= 1;
			res[now[1]][0] -= 1;
			count(cur + 1);
			res[now[0]][2] += 1;
			res[now[1]][0] += 1;
		}
	}
	
	private static void check() {
		int total = 0;
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				total += res[i][j];
			}
		}
		
		if (total == 0) {
			ans = 1;
		}
	}
}
