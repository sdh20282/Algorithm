import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), rst = Integer.MAX_VALUE;
		char[][] map = new char[N][N];
		int[][] starts = new int[3][];
		int[][] ends = new int[3][];

		int startIndex = 0, endIndex = 0;

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B') {
					starts[startIndex++] = new int[] { i, j };
					map[i][j] = '0';
				}

				if (map[i][j] == 'E') {
					ends[endIndex++] = new int[] { i, j };
					map[i][j] = '0';
				}
			}
		}

		int[] start = { starts[1][0], starts[1][1], (starts[0][0] == starts[1][0]) ? 1 : 0 };
		String end = "[" + ends[1][0] + ", " + ends[1][1] + ", " + ((ends[0][0] == ends[1][0]) ? 1 : 0) + "]";
		
		Queue<int[]> q = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		
		q.offer(start);
		set.add(Arrays.toString(start));
		
		int count = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();
				
				if (Arrays.toString(now).equals(end)) {
					rst = Math.min(rst, count);
				}
				
				if (now[2] == 0) {
					if (now[0] - 1 > 0 && map[now[0] - 2][now[1]] != '1') {
						now[0] -= 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[0] += 1;
					}
					
					if (now[0] + 1 < N - 1 && map[now[0] + 2][now[1]] != '1') {
						now[0] += 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[0] -= 1;
					}
					
					if (now[1] - 1 >= 0 && map[now[0] - 1][now[1] - 1] != '1' && map[now[0]][now[1] - 1] != '1' && map[now[0] + 1][now[1] - 1] != '1') {
						now[1] -= 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[1] += 1;
					}
					
					if (now[1] + 1 <= N - 1 && map[now[0] - 1][now[1] + 1] != '1' && map[now[0]][now[1] + 1] != '1' && map[now[0] + 1][now[1] + 1] != '1') {
						now[1] += 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[1] -= 1;
					}
					
					if (now[1] - 1 >= 0 && map[now[0] - 1][now[1] - 1] != '1' && map[now[0]][now[1] - 1] != '1' && map[now[0] + 1][now[1] - 1] != '1' && now[1] + 1 <= N - 1 && map[now[0] - 1][now[1] + 1] != '1' && map[now[0]][now[1] + 1] != '1' && map[now[0] + 1][now[1] + 1] != '1') {
						now[2] = 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[2] = 0;
					}
				} else {
					if (now[1] - 1 > 0 && map[now[0]][now[1] - 2] != '1') {
						now[1] -= 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[1] += 1;
					}
					
					if (now[1] + 1 < N - 1 && map[now[0]][now[1] + 2] != '1') {
						now[1] += 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[1] -= 1;
					}
					
					if (now[0] - 1 >= 0 && map[now[0] - 1][now[1] - 1] != '1' && map[now[0] - 1][now[1]] != '1' && map[now[0] - 1][now[1] + 1] != '1') {
						now[0] -= 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[0] += 1;
					}
					
					if (now[0] + 1 <= N - 1 && map[now[0] + 1][now[1] - 1] != '1' && map[now[0] + 1][now[1]] != '1' && map[now[0] + 1][now[1] + 1] != '1') {
						now[0] += 1;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[0] -= 1;
					}
					
					if (now[0] - 1 >= 0 && map[now[0] - 1][now[1] - 1] != '1' && map[now[0] - 1][now[1]] != '1' && map[now[0] - 1][now[1] + 1] != '1' && now[0] + 1 <= N - 1 && map[now[0] + 1][now[1] - 1] != '1' && map[now[0] + 1][now[1]] != '1' && map[now[0] + 1][now[1] + 1] != '1') {
						now[2] = 0;
						
						if (!set.contains(Arrays.toString(now))) {
							set.add(Arrays.toString(now));
							q.offer(now.clone());
						}
						
						now[2] = 1;
					}
				}
			}
			
			count += 1;
		}
		
		System.out.println(rst == Integer.MAX_VALUE ? 0 : rst);
	}
}
