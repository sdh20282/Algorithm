import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken());
			int[][] moves = new int[m + 1][2];
			int[][] aps = new int[a][];
			int[][] dirs = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
			int[] userA = { 1, 1 }, userB = { 10, 10 };
			int sumA = 0, sumB = 0;

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++)
					moves[j][i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				aps[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			}

			Arrays.sort(aps, (e1, e2) -> e2[3] - e1[3]);

			for (int[] move : moves) {
				userA[0] += dirs[move[0]][0];
				userA[1] += dirs[move[0]][1];

				userB[0] += dirs[move[1]][0];
				userB[1] += dirs[move[1]][1];

				ArrayList<String> nearA = new ArrayList<>();
				ArrayList<String> nearB = new ArrayList<>();

				for (int[] ap : aps) {
					if (Math.abs(userA[0] - ap[0]) + Math.abs(userA[1] - ap[1]) <= ap[2]) {
						nearA.add("" + ap[0] + "," + ap[1] + "," + ap[2] + "," + ap[3]);
					}

					if (Math.abs(userB[0] - ap[0]) + Math.abs(userB[1] - ap[1]) <= ap[2]) {
						nearB.add("" + ap[0] + "," + ap[1] + "," + ap[2] + "," + ap[3]);
					}
				}
				
				if (nearA.size() == 0 && nearB.size() == 0) {
					continue;
				}
				
				if (nearA.size() == 0 || nearB.size() == 0) {
					if (nearA.size() == 0) {
						sumB += Integer.parseInt(nearB.get(0).split(",")[3]);
					} else {
						sumA += Integer.parseInt(nearA.get(0).split(",")[3]);
					}
					
					continue;
				}
				
				if (nearA.size() == 1 && nearB.size() == 1) {
					if (!nearA.get(0).equals(nearB.get(0))) {
						sumB += Integer.parseInt(nearB.get(0).split(",")[3]);
					}
					
					sumA += Integer.parseInt(nearA.get(0).split(",")[3]);
					
					continue;
				}
				
				if (nearA.size() == 1 || nearB.size() == 1) {
					if (nearA.size() == 1) {
						if (nearA.get(0).equals(nearB.get(0))) {
							sumA += Integer.parseInt(nearA.get(0).split(",")[3]);
							sumB += Integer.parseInt(nearB.get(1).split(",")[3]);
						} else {
							sumA += Integer.parseInt(nearA.get(0).split(",")[3]);
							sumB += Integer.parseInt(nearB.get(0).split(",")[3]);
						}
					} else {
						if (nearB.get(0).equals(nearA.get(0))) {
							sumA += Integer.parseInt(nearA.get(1).split(",")[3]);
							sumB += Integer.parseInt(nearB.get(0).split(",")[3]);
						} else {
							sumA += Integer.parseInt(nearA.get(0).split(",")[3]);
							sumB += Integer.parseInt(nearB.get(0).split(",")[3]);
						}
					}
					
					continue;
				}
				
				if (nearA.get(0).equals(nearB.get(0))) {
					if (Integer.parseInt(nearA.get(1).split(",")[3]) > Integer.parseInt(nearB.get(1).split(",")[3])) {
						sumA += Integer.parseInt(nearA.get(1).split(",")[3]);
						sumB += Integer.parseInt(nearB.get(0).split(",")[3]);
					} else {
						sumA += Integer.parseInt(nearA.get(0).split(",")[3]);
						sumB += Integer.parseInt(nearB.get(1).split(",")[3]);
					}
				} else {
					sumA += Integer.parseInt(nearA.get(0).split(",")[3]);
					sumB += Integer.parseInt(nearB.get(0).split(",")[3]);
				}
			}

			System.out.println("#" + test_case + " " + (sumA + sumB));
		}
	}
}
