import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, w, h, minxBreak, nowBlocks;
	static int[][] blocks;
	static int[] permutations;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			minxBreak = 100000;
			nowBlocks = 0;
			
			blocks = new int [h][w];
			permutations = new int[n];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < w; j++) {
					blocks[i][j] = Integer.parseInt(st.nextToken());
					
					if (blocks[i][j] != 0) {
						nowBlocks += 1;
					}
				}
			}
			
			getPermutations(0);
			
			System.out.println("#" + test_case + " " + minxBreak);
		}
	}
	
	static void getPermutations(int cur) {
		if (cur == n) {
			dropMarble();
			return;
		}
		
		for (int i = 0; i < w; i++) {
			permutations[cur] = i;
			getPermutations(cur + 1);
		}
	}
	
	static void dropMarble() {
		int[][] simulateBoom = new int[h][w];
		int count = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				simulateBoom[i][j] = blocks[i][j];
			}
		}
		
		for (int marble : permutations) {
			int start = -1;
			
			for (int i = 0; i < h; i++) {
				if (simulateBoom[i][marble] != 0) {
					start = i;
					break;
				}
			}
			
			if (start == -1) {
				continue;
			}
			
			count += boom(simulateBoom, start, marble);
			
			for (int i = 0; i < w; i++) {
				int s = h - 1, e = h - 1;
				
				while (s >= 0 && e >= 0) {
					if (simulateBoom[s][i] != 0) {
						while (simulateBoom[s][i] != 0) {
							s -= 1;
							
							if (s < 0) {
								break;
							}
						}
					} else if (s <= e) {
						e = s - 1;
					} else if (simulateBoom[e][i] == 0) {
						while (simulateBoom[e][i] == 0) {
							e -= 1;
							
							if (e < 0) {
								break;
							}
						}
					} else {
						simulateBoom[s][i] = simulateBoom[e][i];
						simulateBoom[e][i] = 0;
						s -= 1;
						e -= 1;
					}
				}
			}
		}
		
		if (nowBlocks - count < minxBreak) {
			minxBreak = nowBlocks - count;
		}
	}
	
	static int boom(int[][] simulateBoom, int r, int c) {
		int count = 1, range = simulateBoom[r][c];
		simulateBoom[r][c] = 0;
		
		for (int i = r - range + 1; i < r + range; i++) {
			if (i < 0 || i >= h) {
				continue;
			}
			
			if (simulateBoom[i][c] != 0) {
				count += boom(simulateBoom, i, c);
			}
		}
		
		for (int j = c - range + 1; j < c + range; j++) {
			if (j < 0 || j >= w) {
				continue;
			}
			
			if (simulateBoom[r][j] != 0) {
				count += boom(simulateBoom, r, j);
			}
		}
		
		return count;
	}
}
