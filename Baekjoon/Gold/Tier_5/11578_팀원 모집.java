import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int num_problem, num_student, min;
	static int[] can_solve;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num_problem = Integer.parseInt(st.nextToken());
		num_student = Integer.parseInt(st.nextToken());
		can_solve = new int[num_student];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < num_student; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()), problem = 0;
			
			for (int j = 0; j < n; j++) {
				int solve = Integer.parseInt(st.nextToken());
				
				problem = problem | 1 << solve - 1;
			}
			
			can_solve[i] = problem;
		}
		
		for (int i = 1; i <= num_student; i++) {
			if (min < num_student) {
				System.out.println(min);
				
				break;
			}
			
			comb(i, 0, 0, 0);
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
	}
	
	static void comb(int limit, int step, int selected, int students) {
		if (selected == limit) {
			int result = 0, index = 0;
			
			while (students != 0) {
				int now = students & 1;
				
				if (now == 1) {
					result |= can_solve[index];
				}
				
				students >>= 1;
				index += 1;
			}
			
			if (result == (1 << num_problem) - 1) {
				min = limit;
			}
			
			return;
		}
		
		if (step == num_student) {
			return;
		}
		
		comb(limit, step + 1, selected + 1, students | 1 << step);
		comb(limit, step + 1, selected, students);
	}
}
