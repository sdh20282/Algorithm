import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = sc.nextInt();
            int[] sequence = new int[num];
            ArrayList<Integer> checked = new ArrayList<Integer>();
            
            for (int i = 0; i < sequence.length; i++) {
				sequence[i] = sc.nextInt();
			}
            
            for (int element : sequence) {
				if (checked.isEmpty() || checked.get(checked.size() - 1) < element) {
					checked.add(element);
				}
				else {
					for (int i = 0; i < checked.size(); i++) {
						
						if (checked.get(i) > element) {
							checked.set(i, element);
							break;
						}
					}
				}
			}
            
            System.out.println("#" + test_case + " " + checked.size());
        }
        
        sc.close();
	}
}
