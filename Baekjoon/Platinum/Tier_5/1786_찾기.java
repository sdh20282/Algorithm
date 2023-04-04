import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();
		
		int np = P.length(), index = 0, nt = T.length();
		int[] table = new int[np];
		
		for (int i = 1; i < np; i++) {
			while (index > 0 && P.charAt(i) != P.charAt(index)) {
				index = table[index - 1];
			}
			
			if (P.charAt(i) == P.charAt(index)) {
				table[i] = ++index;
			}
		}
		
		int count = 0, j = 0;
		ArrayList<Integer> location = new ArrayList<>();
		
		for (int i = 0; i < nt; i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = table[j - 1];
			}
			
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					count += 1;
					location.add(i - j + 1);
					j = table[j];
				} else {
					j++;
				}
			}
		}
		
		sb.append(count).append('\n');
		
		for (int i = 0; i < location.size(); i++) {
			sb.append(location.get(i)).append(' ');
		}
		
		System.out.println(sb.toString());
	}
}
