package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2BOJ1932 {
	
	static int n;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(checkBound(i-1,j)) {
					dp[i][j] = dp[i][j] + dp[i-1][j];
				}
				if(checkBound(i-1,j-1)) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j] - dp[i-1][j] + dp[i-1][j-1]);
				}
				ans = Math.max(dp[i][j],ans);
			}
		}
		System.out.println(ans);
	}
	
	private static boolean checkBound(int y, int x) {
		return (y>=0 && y<n && x>=0 && x<n) ? true : false;
	}
}
