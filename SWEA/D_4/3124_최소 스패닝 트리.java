import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Data implements Comparable<Data> {
		int index;
		int w;
		
		public Data(int index, int w) {
			this.index = index;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Data [index=" + index + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Data o) {
			return w - o.w;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	        int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), count = 0;
	        ArrayList<Data>[] edges = new ArrayList[v];
	        boolean[] visited = new boolean[v];
	        PriorityQueue<Data> pq = new PriorityQueue<>();
	        long sum = 0;
	        
	        for (int i = 0; i < v; i++) {
				edges[i] = new ArrayList<>();
			}

	        for (int i = 0; i < e; i++) {
	            st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());

	            edges[a - 1].add(new Data(b - 1, w));
	            edges[b - 1].add(new Data(a - 1, w));
	        }

	        pq.offer(new Data(0, 0));

	        while (!pq.isEmpty()) {
	            Data cur = pq.poll();

	            if (visited[cur.index]) {
	                continue;
	            }

	            count += 1;
	            sum += cur.w;
	            visited[cur.index] = true;

	            if (count == v) {
	                break;
	            }
	            
	            for (Data data : edges[cur.index]) {
					if (visited[data.index]) {
						continue;
					}
					
					pq.offer(data);
				}
	        }

			System.out.println("#" + test_case + " " + sum);
		}
	}	
}
