package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day7BOJ20061 {

	static int n;
	static int[][] blue = new int[6][4];
	static int[][] green = new int[6][4];
	static int totalScore;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			moveInMap(t, y, x, green);
			if(t==1) {
				moveInMap(1, x, y, blue);
			}else if(t==2) {
				moveInMap(3, x, y, blue);
			}else {
				moveInMap(2, x, y, blue);
			}
			gravity2(green);
			gravity2(blue);
		}
		
		System.out.println(totalScore);
		System.out.println(count());
	}
	
	private static void moveInMap(int t, int y, int x, int[][] map) {
		if(t==1) { // 1칸짜리인 경우
			// x좌표 고정, 최대한 내려본다.
			int yy = 0;
			while(true) {
				if(yy+1 > 5 || map[yy+1][x]==1) { break;}
				yy++;
			}
			map[yy][x]=1;
		}else if(t==2) { // 가로 2칸
			// x좌표 2개 고정 y,x  && y,x+1
			int yy=0;
			while(true) {
				if(yy+1 > 5 || map[yy+1][x]==1 || map[yy+1][x+1]==1 ){ break;} // 둘중 하나라도 다음좌표때 만나면
				yy++;
			}
			map[yy][x]=1;
			map[yy][x+1]=1;
		}else { // 세로로 두칸
			// x좌표 2개 고정 y,x  && y+1,x
			int yy = 0;
			while(true) {
				if(yy+1 > 5 || map[yy+1][x]==1) { break;}
				yy++;
			}
			map[yy-1][x]=1;
			map[yy][x]=1;
		}
		// 전부 놓고 나서, 4개인 열 있는지 체크
		for(int i=5; i>=2; i--) {
			int cnt=0;
			for(int j=0; j<4; j++) {
				if(map[i][j]==0) {
					break;
				}else {
					cnt++;
				}
			}
			if(cnt==4) {
				totalScore++;
				gravity(i,map);
				i++;
			}
		}
	}
	
	private static void gravity(int lineNum, int[][] map) {
		for(int i = lineNum; i > 0; i--) {
            for(int j = 0; j < 4; j++) {
            	map[i][j] = map[i-1][j];
            }
        }
	}
	
	private static void gravity2(int[][] map) {
		int count = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 4; j++) {
            	if(map[i][j] == 1) {
                    count++;
                    break;
                }
            }
        }
        
        for(int i = 5; i >= 2; i--) {
            for(int j = 0; j < 4; j++) {
            	map[i][j] = map[i-count][j];	
            }
        }
        
        for(int i = 0; i < 2; i++) {
        	for(int j = 0; j < 4; j++) {
        		map[i][j] = 0;
        	}
        }
    }
	
	private static int count() {
        int count = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j++) {
                if(blue[j][i] == 1)
                    count++;
                if(green[j][i] == 1)
                    count++;
            }
        }
    
        return count;
    }
	

}
