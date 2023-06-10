import java.util.Stack;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int K = sc.nextInt();
		
		for(int i = 0; i < K; i++) {
			int number = sc.nextInt();
            
			if(number == 0) {
				stack.pop();
			} else {
				stack.push(number);
			}
		}
        
		int sum = 0;
		
		for(int o : stack) {
			sum += o;
		}
 
		System.out.println(sum);
        sc.close();
	}
}
