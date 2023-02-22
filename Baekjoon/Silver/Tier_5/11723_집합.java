import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int result = 0, now = 0;
		String operation;
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			operation = st.nextToken();

			if (operation.equals("add")) {
				now = Integer.parseInt(st.nextToken());
				result = result | 1 << now - 1;
			} else if (operation.equals("remove")) {
				now = Integer.parseInt(st.nextToken());
				result = result & ~(1 << now - 1);
			} else if (operation.equals("check")) {
				now = Integer.parseInt(st.nextToken());
				sb.append((result & 1 << now - 1) > 0 ? 1 : 0);
				sb.append("\n");
			} else if (operation.equals("toggle")) {
				now = Integer.parseInt(st.nextToken());
				result = result ^ 1 << now - 1;
			} else if (operation.equals("all")) {
				result = 2097151;
			} else if (operation.equals("empty")) {
				result = 0;
			}
		}
		
		System.out.print(sb.toString());
	}
}
