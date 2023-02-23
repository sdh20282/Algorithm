import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int l, c;
	static String[] words;
	static String[] com;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		words = new String[c];
		com = new String[l];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < c; i++) {
			words[i] = st.nextToken();
		}
		
		Arrays.sort(words);
		
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	static void dfs(int cur, int start) {
		if (cur == l) {
			int vowel = 0, consonant = 0;
			
			for (int i = 0; i < l; i++) {
				if (com[i].equals("a") || com[i].equals("e") || com[i].equals("i") || com[i].equals("o") || com[i].equals("u")) {
					vowel += 1;
				} else {
					consonant += 1;
				}
			}
			
			if (vowel < 1 || consonant < 2) return;
			
			for (int i = 0; i < l; i++) sb.append(com[i]);
			
			sb.append('\n');
			
			return;
		}
		
		for (int i = start; i < c; i++) {
			com[cur] = words[i];
			dfs(cur + 1, i + 1);
		}
	}
}
