package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day4BOJ9251 {

	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = " "+br.readLine();
		String b = " "+br.readLine();
		
		map = new int[a.length()][b.length()];
		
		for(int i=1; i<a.length(); i++) {
			for(int j=1; j<b.length(); j++) {
				if(a.charAt(i)==b.charAt(j)) {
					map[i][j] = map[i-1][j-1] + 1;
				}else {
					map[i][j] = Math.max(map[i][j-1], map[i-1][j]);
				}
			}
		}
		
//		for(int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
//		System.out.println();
		
		System.out.println(map[a.length()-1][b.length()-1]);
		
	}

}
