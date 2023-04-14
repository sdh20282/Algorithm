import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10];
		int len, x, y, now;
		LinkedList<Integer> list;

		for (int test_case = 1; test_case <= 10; test_case++) {
			list = new LinkedList<>();
			len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < len; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < len; i++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < y; j++) {
					now = Integer.parseInt(st.nextToken());
					list.add(x + j, now);
				}
				
			}
			
			sb.append('#').append(test_case).append(' ');
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
