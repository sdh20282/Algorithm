import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static final int M = 1, W = 2, D = 3, C = 4;

	static class Person implements Comparable<Person> {
		int r, c, arrivalTime, downCnt, status;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public void init() {
			this.arrivalTime = this.downCnt = 0;
			this.status = M;
		}

		@Override
		public int compareTo(Person person) {
			return Integer.compare(this.arrivalTime, person.arrivalTime);
		}
	}

	static int N, personCount, min;
	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] stairSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<>();
			sList = new int[2][];

			StringTokenizer st = null;

			for (int i = 0, stairIndex = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					int cur = Integer.parseInt(st.nextToken());

					if (cur == 1) {
						pList.add(new Person(i, j));
					}

					else if (cur > 1) {
						sList[stairIndex++] = new int[] { i, j, cur };
					}
				}
			}

			personCount = pList.size();
			stairSelected = new int[personCount];
			min = Integer.MAX_VALUE;
			
			dfs(0);

			System.out.println("#" + test_case + " " + min);
		}
	}

	static void dfs(int cur) {
		if (cur == personCount) {
			int now = calculate();
			
			if (now < min) {
				min = now;
			}

			return;
		}

		stairSelected[cur] = 0;
		dfs(cur + 1);

		stairSelected[cur] = 1;
		dfs(cur + 1);
	}

	static int calculate() {
		@SuppressWarnings("unchecked")
		ArrayList<Person>[] list = new ArrayList[] { new ArrayList<>(), new ArrayList<>() };
		
		for (int i = 0; i < personCount; i++) {
			Person person = pList.get(i);
			person.init();
			person.arrivalTime = Math.abs(person.r - sList[stairSelected[i]][0]) +  Math.abs(person.c - sList[stairSelected[i]][1]);
			
			list[stairSelected[i]].add(person);
		}
		
		int max = 0;
		
		for (int i = 0; i < 2; i++) {
			if (list[i].size() > 0) {
				int now = processDown(list[i], sList[i][2]);
				
				if (now > max) {
					max = now;
				}
			}
		}
		
		return max;
	}
	
	static int processDown(ArrayList<Person> list, int height) {
		Collections.sort(list);
		
		int size = list.size() + 3;
		int[] D = new int[size];
		
		for (int i = 3; i < size; i++) {
			Person person = list.get(i - 3);
			
			if (D[i - 3] <= person.arrivalTime + 1) {
				D[i] = person.arrivalTime + height + 1;
			} else {
				D[i] = D[i - 3] + height;
			}
		}
		
		return D[size - 1];
	}
}
