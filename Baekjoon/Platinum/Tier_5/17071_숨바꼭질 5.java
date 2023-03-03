import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt(), time = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[500001][2];
		sc.close();
		
		q.offer(n);
		visited[n][time % 2] = true;

		while (q.size() > 0) {
			if (k > 500000) {
				System.out.println(-1);
				return;
			}
			
			if (visited[k][time % 2]) {
				System.out.println(time);
				return;
			}
			
			time += 1;
			k += time;
			
			for (int i = 0, size = q.size(); i < size; i++) {
				int now = q.poll();
				
				if ((now - 1) >= 0 && !visited[now - 1][time % 2]) {
					visited[now - 1][time % 2] = true;
					q.offer(now - 1);
				}
				
				if ((now + 1) < 500001 && ! visited[now + 1][time % 2]) {
					visited[now + 1][time % 2] = true;
					q.offer(now + 1);
				}
				
				if ((now * 2) < 500001 && ! visited[now * 2][time % 2]) {
					visited[now * 2][time % 2] = true;
					q.offer(now * 2);
				}
			}
		}
	}
}
