import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>(), answer = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			q.offer(i + 1);
		}
		
		while (q.size() > 0) {
			for (int i = 0; i < k - 1; i++) {
				q.offer(q.poll());
			}
			
			answer.offer(q.poll());
		}
		
		System.out.print("<");
		while (answer.size() > 1) {
			System.out.print(answer.poll() + ", ");
		}
		System.out.print(answer.poll() + ">");
	}
}
