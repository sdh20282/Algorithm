import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int count = 0, sum = 0, len = str.length;
		
		for (int i = 0; i < len; i++) {
			count += 1;

            if (str[i] == ')') {
                count -= 2;
                sum += (str[i - 1] == '(') ? count : 1;
            }
		}
        
		System.out.println(sum);
	}
}
