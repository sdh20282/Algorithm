import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
			int[] pos = {};
			String[][] map = new String[h][w];

			for (int i = 0; i < h; i++) {
				String[] now = br.readLine().split("");

				for (int j = 0; j < w; j++) {
					map[i][j] = now[j];

					if (now[j].equals("^") || now[j].equals("v") || now[j].equals("<") || now[j].equals(">")) {
						pos = new int[] { i, j };
					}
				}
			}

			br.readLine();
			String[] commands = br.readLine().split("");

			for (String command : commands) {
				switch (command) {
				case "U":
					map[pos[0]][pos[1]] = "^";

					if (pos[0] - 1 < 0 || pos[0] - 1 >= h) {
						continue;
					}

					if (map[pos[0] - 1][pos[1]].equals(".")) {
						map[pos[0] - 1][pos[1]] = "^";
						map[pos[0]][pos[1]] = ".";
						pos[0] -= 1;
					}

					break;
				case "D":
					map[pos[0]][pos[1]] = "v";

					if (pos[0] + 1 < 0 || pos[0] + 1 >= h) {
						continue;
					}

					if (map[pos[0] + 1][pos[1]].equals(".")) {
						map[pos[0] + 1][pos[1]] = "v";
						map[pos[0]][pos[1]] = ".";
						pos[0] += 1;
					}

					break;
				case "L":
					map[pos[0]][pos[1]] = "<";

					if (pos[1] - 1 < 0 || pos[1] - 1 >= w) {
						continue;
					}

					if (map[pos[0]][pos[1] - 1].equals(".")) {
						map[pos[0]][pos[1] - 1] = "<";
						map[pos[0]][pos[1]] = ".";
						pos[1] -= 1;
					}

					break;
				case "R":
					map[pos[0]][pos[1]] = ">";

					if (pos[1] + 1 < 0 || pos[1] + 1 >= w) {
						continue;
					}

					if (map[pos[0]][pos[1] + 1].equals(".")) {
						map[pos[0]][pos[1] + 1] = ">";
						map[pos[0]][pos[1]] = ".";
						pos[1] += 1;
					}

					break;
				case "S":
					int now = -1;

					switch (map[pos[0]][pos[1]]) {
					case "^":
						now = pos[0];
						
						while(now > 0 && (map[now][pos[1]].equals("-") || map[now][pos[1]].equals(".") || map[now][pos[1]].equals("^") || map[now][pos[1]].equals("v") || map[now][pos[1]].equals("<") || map[now][pos[1]].equals(">"))) {
							now -= 1;
						}
						
						if (map[now][pos[1]].equals("*")) {
							map[now][pos[1]] = ".";
						}

						break;
					case "v":
						now = pos[0];
						
						while(now < h - 1 && (map[now][pos[1]].equals("-") || map[now][pos[1]].equals(".") || map[now][pos[1]].equals("^") || map[now][pos[1]].equals("v") || map[now][pos[1]].equals("<") || map[now][pos[1]].equals(">"))) {
							now += 1;
						}
						
						if (map[now][pos[1]].equals("*")) {
							map[now][pos[1]] = ".";
						}

						break;
					case "<":
						now = pos[1];
						
						while(now > 0 && (map[pos[0]][now].equals("-") || map[pos[0]][now].equals(".") || map[pos[0]][now].equals("^") || map[pos[0]][now].equals("v") || map[pos[0]][now].equals("<") || map[pos[0]][now].equals(">"))) {
							now -= 1;
						}
						
						if (map[pos[0]][now].equals("*")) {
							map[pos[0]][now] = ".";
						}

						break;
					case ">":
						now = pos[1];
						
						while(now < w - 1 && (map[pos[0]][now].equals("-") || map[pos[0]][now].equals(".") || map[pos[0]][now].equals("^") || map[pos[0]][now].equals("v") || map[pos[0]][now].equals("<") || map[pos[0]][now].equals(">"))) {
							now += 1;
						}
						
						if (map[pos[0]][now].equals("*")) {
							map[pos[0]][now] = ".";
						}

						break;
					}
				}
			}
			
			System.out.print("#" + test_case + " ");
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				
				System.out.println();
			}
		}
	}
}
