import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		
		Deque<int[]> dq = new ArrayDeque<int[]>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while (!dq.isEmpty() && dq.peekLast()[0] > now) {
				dq.pollLast();
			}
			
			dq.offer(new int[] {now, i});
			
			if (dq.peek()[1] < i - L + 1) {
				dq.poll();
			}
			
			sb.append(dq.peek()[0]).append(" ");
		}
		
		System.out.println(sb);
	}
}
