import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
public class BOJ_13335_트럭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Queue<Integer> queue = new LinkedList<>();
	static int N, W, L;
	static int current, time;// 현재 무게, 현재 시간
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		W = Integer.parseInt(str[1]);
		L = Integer.parseInt(str[2]);
		
		str = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			int weight = Integer.parseInt(str[i]);
			
			while (true) {
				if (queue.size() == W) {
					current -= queue.poll();
				}
				if (current + weight <= L) break;
				queue.offer(0);
				time++;
			}
			
			queue.offer(weight);
			current += weight;
			time++;
		}
		
		System.out.println(time+W);
	}
}


