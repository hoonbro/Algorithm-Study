package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1BOJ12865 {

	static int n, k;
	static int[][] w;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
//		w = new int[k+1];
		w = new int[n+1][k+1];
		
		for(int i=1; i<=n; i++) { // 사용한 최대 물건
			st = new StringTokenizer(br.readLine());
			int pd = Integer.parseInt(st.nextToken());
			int vl = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<=k; j++) { // 최대 무게 까지
				// 못만든다 가정하고 이전값
				w[i][j] = w[i-1][j];
				// 만약에 가방에 남은 공간이 있다면
				if(j-pd >=0) { 
					w[i][j] = Math.max(w[i][j], vl+(w[i-1][j-pd]));
				}
			}
		}
//		System.out.println(Arrays.toString(w));
//		solution();
		
		System.out.println(w[n][k]);
	}
	
//	이러려면 물건 여러개 가능해야함
//	private static void solution() {
//		for(int i=0; i<=k; i++) {
//			for(int j=0; j<=i-1; j++) {
//				if(w[j]!=0 && w[i-j]!=0) {
//					w[i] = Math.max(w[i],w[j]+w[i-j]);
//				}
//			}
//		}
//	}

}
