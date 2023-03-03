import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int r, c, m;
	static HashMap<String, int[]> sharks, next;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sharks = new HashMap<>();
		int answer = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int ss = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int sz = Integer.parseInt(st.nextToken());

			if ((sd == 1 || sd == 2) && ss >= (r - 1) * 2) {
				while (ss >= (r - 1) * 2) {					
					ss -= (r - 1) * 2;
				}
			}

			if ((sd == 3 || sd == 4) && ss >= (c - 1) * 2) {
				while (ss >= (c - 1) * 2) {
					ss -= (c - 1) * 2;
				}
			}

			sharks.put("" + sr + "-" + sc, new int[] { ss, sd, sz });
		}
		
		for (int f = 1; f <= c; f++) {
			for (int g = 1; g <= r; g++) {
				int[] target = sharks.get("" + g + "-" + f);

				if (target != null) {
					answer += target[2];
					sharks.remove("" + g + "-" + f);
					break;
				}
			}

			String[] keys = new String[sharks.keySet().size()];
			sharks.keySet().toArray(keys);
			next = new HashMap<>();

			for (int i = 0; i < keys.length; i++) {
				String pos = keys[i];
				String[] nowString = pos.split("-");
				int[] nowPos = { Integer.parseInt(nowString[0]), Integer.parseInt(nowString[1]) };
				int[] nowInfo = sharks.get(pos);
				sharks.remove(pos);

				if (nowInfo[1] == 1) {
					nowPos[0] -= nowInfo[0];

					if (nowPos[0] < 1) {
						nowPos[0] = 2 - nowPos[0];
						nowInfo[1] = 2;
					}

					if (nowPos[0] > r) {
						nowPos[0] = r + r - nowPos[0];
						nowInfo[1] = 1;
					}
				} else if (nowInfo[1] == 2) {
					nowPos[0] += nowInfo[0];

					if (nowPos[0] > r) {
						nowPos[0] = r + r - nowPos[0];
						nowInfo[1] = 1;
					}

					if (nowPos[0] < 1) {
						nowPos[0] = 2 - nowPos[0];
						nowInfo[1] = 2;
					}
				} else if (nowInfo[1] == 3) {
					nowPos[1] += nowInfo[0];

					if (nowPos[1] > c) {
						nowPos[1] = c + c - nowPos[1];
						nowInfo[1] = 4;
					}

					if (nowPos[1] < 1) {
						nowPos[1] = 2 - nowPos[1];
						nowInfo[1] = 3;
					}
				} else if (nowInfo[1] == 4) {
					nowPos[1] -= nowInfo[0];
					
					if (nowPos[1] < 1) {
						nowPos[1] = 2 - nowPos[1];
						nowInfo[1] = 3;
					}

					if (nowPos[1] > c) {
						nowPos[1] = c + c - nowPos[1];
						nowInfo[1] = 4;
					}
				}

				int[] exist = next.get("" + nowPos[0] + "-" + nowPos[1]);

				if (exist == null || (exist != null && nowInfo[2] > exist[2])) {
					next.put("" + nowPos[0] + "-" + nowPos[1], nowInfo);
				}
			}

			sharks = next;
		}

		System.out.println(answer);
	}
}
