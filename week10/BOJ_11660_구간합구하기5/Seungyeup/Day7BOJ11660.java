package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day7BOJ11660 {

	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st =  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1]+Integer.parseInt(st.nextToken())-map[i-1][j-1];
			}
		}
		
//		for(int[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		for(int k=0; k<m; k++) {
			st =  new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			System.out.println(map[y2][x2]+map[y1-1][x1-1]-map[y1-1][x2]-map[y2][x1-1]);
		}
		
		
	}

}
