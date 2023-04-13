import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()), index = 0;
		int[] target = new int[N];
		Stack<Integer> s = new Stack<>();
		Queue<Character> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			target[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			s.push(i);
			q.offer('+');
			
			while (index < N && !s.isEmpty() && target[index] == s.peek()) {
				s.pop();
				q.offer('-');
				index += 1;
			}
		}
		
		if (s.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				sb.append(q.poll()).append('\n');
			}
			
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
