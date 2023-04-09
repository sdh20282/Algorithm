import java.io.*;
import java.util.*;
public class Main {
	public static int [] dist;
	public static int []in;
	public static int N,M;
	public static boolean visited[];
	public static class Node{
		int dest;
		int cost;
		public Node(){}
		public Node(int a,int b){
			dest = a;
			cost = b;
		}
	}
	public static ArrayList<Node> adj[];
	public static ArrayList<Node> inverse[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		in = new int[N+1];
		dist = new int[N+1];
		adj = new ArrayList[N+1];
		inverse = new ArrayList[N+1];
		for(int i=1;i<=N;i++){
			adj[i] = new ArrayList<Node>();
			inverse[i] = new ArrayList<Node>();
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end,cost));
			inverse[end].add(new Node(start,cost));
			in[end]++;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e= Integer.parseInt(st.nextToken());
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(s,0));
		exit:while(!q.isEmpty()){
			Node cur = q.poll();
			for(int i=0;i<adj[cur.dest].size();i++){
				Node next = adj[cur.dest].get(i);
				if(cur.cost + next.cost > dist[next.dest]){
					dist[next.dest] = cur.cost + next.cost;
				}
				in[next.dest]--;
				if(in[next.dest]==0){
					q.offer(new Node(next.dest,dist[next.dest]));
					if(next.dest == e) break exit;
				}
			}
		}
		System.out.println(dist[e]);
        
		visited = new boolean[N+1];
		q = new LinkedList<Node>();
		q.offer(new Node(e,dist[e]));
		int ans = 0;
		while(!q.isEmpty()){
			Node cur = q.poll();
			if(visited[cur.dest])continue;
			visited[cur.dest] = true;
			if(cur.dest == s)break;
			for(int i=0;i<inverse[cur.dest].size();i++){
				Node next = inverse[cur.dest].get(i);
				if(cur.cost - next.cost == dist[next.dest]){
					ans++;
					q.offer(new Node(next.dest,cur.cost-next.cost));
				}
			}
		}
		System.out.println(ans);
	}

}
