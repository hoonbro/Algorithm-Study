package week_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day1BOJ11404 {

	static int[][] map;
	static int n,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			 map[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], c); // 도시간 노선이 한개가 아니므로
		}

		solution();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]==Integer.MAX_VALUE) {
					sb.append(0).append(" ");
				}else {
					sb.append(map[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// floydWarshall	
	private static void solution() {
		// 순서 의미 o
		for(int k=1; k<=n; k++) { // 거쳐
			for(int i=1; i<=n; i++) { // 출발
				for(int j=1; j<=n; j++) { // 도착
					if(map[i][k]==Integer.MAX_VALUE || map[k][j]==Integer.MAX_VALUE) continue;
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]); // 바로가는것,거쳐가는것
				}
			}
		}
	}

}
