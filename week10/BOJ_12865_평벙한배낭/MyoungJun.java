import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<int[]> arr1 = new ArrayList<int[]>();
		
		int W=0,V=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			arr1.add(new int[] {W,V});
		}
		
		Collections.sort(arr1,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int[][] map = new int[N][K+1];
		
		int fw = arr1.get(0)[0]; //제일 가벼운 무게
		int fv = arr1.get(0)[1]; // 그때의 가치
		for(int i=1; i<K+1;i++) {   //첫줄만 따로 넣어두자 밑에 계산 편하게
			if(i>=fw) {
				map[0][i] = fv;
			}
		}
		
		int temp =0;
		for(int i=1;i<N;i++) {
			for(int j=1;j<K+1;j++) {
				if(j >= arr1.get(i)[0]) {  // 배낭에 넣을 수 있을 때
					temp = arr1.get(i)[1] + map[i-1][j-arr1.get(i)[0]];  //해당 무게 가치값 + 해당 무게 빼고남은 무게에서 가치값

					temp = Math.max(temp, Math.max(map[i][j-1],map[i-1][j]));
					map[i][j] = temp;
				}
				else {
					map[i][j] = Math.max(map[i][j-1],map[i-1][j]);
				}
			}
		}
		System.out.println(map[N-1][K]);
	}
}