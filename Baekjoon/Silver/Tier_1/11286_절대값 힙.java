import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (Math.abs(a) < Math.abs(b)) ? -1 : (Math.abs(a) == Math.abs(b)) ? a - b : 1);
		
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			
			if (now == 0) {
				sb.append((pq.size() == 0) ? 0 : pq.poll()).append('\n');
			} else {
				pq.offer(now);
			}
		}
		
		System.out.println(sb);
	}
}
