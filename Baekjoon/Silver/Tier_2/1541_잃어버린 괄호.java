import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String operation = br.readLine();
		
		ArrayList<String> operations = new ArrayList<>();
		int min = 0, part = 0, i, p;
		
		for (i = 0, p = 0; i < operation.length(); i++) {
			if (operation.charAt(i) == '-') {
				operations.add(operation.substring(p, i));
				operations.add(operation.substring(i, i + 1));
				p = i + 1;
			} else if (operation.charAt(i) == '+') {
				operations.add(operation.substring(p, i));
				p = i + 1;
			}
		}
		
		operations.add(operation.substring(p, i));
		
		for (i = operations.size() - 1; i >= 0; i--) {
			if (operations.get(i).equals("-")) {
				min -= part;
				part = 0;
			} else {
				part += Integer.parseInt(operations.get(i));
			}
		}
		
		min += part;
		System.out.println(min);
	}
}
