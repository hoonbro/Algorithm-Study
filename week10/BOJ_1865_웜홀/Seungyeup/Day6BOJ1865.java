package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day6BOJ1865 {

	static final int INF = Integer.MAX_VALUE>>1;
	static int n,m,w;
	static int s,e,t;
	static int[] nodes;
	static ArrayList<Road> list;
	
	static class Road{
		int from,to,time;
		public Road(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		while(TC-- >0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<Road>();
			// 일반 도로
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				list.add(new Road(s,e,t));
				list.add(new Road(e,s,t));
			}
			// 웜홀
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				list.add(new Road(s,e,t*-1));
			}
			
			nodes = new int[n+1];
			Arrays.fill(nodes,INF);
			
			System.out.println( bellman_ford() ? "YES" : "NO" );
		}
	}
	
	private static boolean bellman_ford() {
		boolean isUpdated = false;
		nodes[1]=0;
		for(int i = 1; i <= n; i++) {
			isUpdated = false;
			for(Road r : list) {
				if(nodes[r.to] > nodes[r.from] + r.time) {
					nodes[r.to] = nodes[r.from] + r.time;
					isUpdated = true;
					// Negative Cycle
					if (i == n) {
						isUpdated = true;
						return isUpdated;
					}
				}
			}
			if(!isUpdated) break;
		}
		return isUpdated;
	}

}
