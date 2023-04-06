import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cur = "";
		
		check : while (!(cur = br.readLine()).equals("0")) {
			char[] now = cur.toCharArray();
			int len = now.length;
			
			for (int i = 0; i < len / 2; i++) {
				if (now[i] != now[len - 1 - i]) {
					System.out.println("no");
					continue check;
				}
			}
			
			System.out.println("yes");
		}
	}
}
