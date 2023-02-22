import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Character> chars = (List<Character>) Arrays.asList('A', 'C', 'G', 'T');
		int[] count = new int[4], appeared = new int[4];
		int result = 0;
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String target = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < count.length; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < p; i++) {
			int now = chars.indexOf(target.charAt(i));
			
			if (now == -1) {
				continue;
			}
			
			appeared[now] += 1;
		}
		
		for (int i = 0; i < 4; i++) {
			if (appeared[i] < count[i]) {
				break;
			}
			
			if (i == 3) {
				result += 1;
			}
		}
		
		for (int i = p; i < s; i++) {
			int now = chars.indexOf(target.charAt(i));
			
			if (now != -1) {
				appeared[now] += 1;
			}
			
			now = chars.indexOf(target.charAt(i - p));
			
			if (now != -1) {
				appeared[now] -= 1;
			}
			
			for (int j = 0; j < 4; j++) {
				if (appeared[j] < count[j]) {
					break;
				}
				
				if (j == 3) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
}
