package week_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day3BOJ16918 {

	static int[][] map;
	static int r,c,n;
	static int[] dy = {0,1,-1,0,0};
	static int[] dx = {0,0,0,-1,1};
	
	static class Pos{
		int y,x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			for(int j=0; j<c; j++) {
				if(s.charAt(j)=='O') {
					map[i][j]=2;
				}
			}
		}
		int time=0;
		while(true) {
			if(++time==n) break;
			timePass();
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]==0) {
					sb.append('.');
				}else {
					sb.append('O');
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void blowBomb(){
		Queue<Pos> target = new LinkedList<Pos>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]==4) {
					for(int d=0; d<5; d++) {
						if(checkBound(i+dy[d],j+dx[d])) {
							target.offer(new Pos(i+dy[d],j+dx[d]));
						}
					}
				}
			}
		}
		while(!target.isEmpty()) {
			Pos cur = target.poll();
			map[cur.y][cur.x] = 0;
		}
	}
	
	private static void timePass(){
//		blowBomb();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j]++;
			}
		}
		blowBomb();// 순서 ㅅㅂ
	}
	
	private static boolean checkBound(int y, int x) {
		return (y>=0 && y<r && x>=0 && x<c) ? true : false;
	}


}
