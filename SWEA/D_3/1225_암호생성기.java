import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();
		int count, now;

		for (int test_case = 1; test_case <= 10; test_case++) {
			Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			count = 1;
			
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			while (true) {
				now = q.poll() - count;
				
				if (now <= 0) {
					q.offer(0);
					break;
				}
				
				q.offer(now);
				
				count = count % 5 + 1;
			}
			
			System.out.print("#" + test_case);
			
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + q.poll());
			}
			
			System.out.println();
		}
	}
}
