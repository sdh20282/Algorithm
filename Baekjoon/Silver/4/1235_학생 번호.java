import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		int length = arr[0].length();
		
		len : for (int i = 1; i <= length; i++) {
			map.clear();
			
			for (int j = 0; j < n; j++) {
				if (map.containsKey(arr[j].substring(length - i))) {
					continue len;
				}
				
				map.put(arr[j].substring(length - i), 1);
			}
			
			System.out.println(i);
			break;
		}
	}
}
