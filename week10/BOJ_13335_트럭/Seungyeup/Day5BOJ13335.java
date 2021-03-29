package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day5BOJ13335 {

	static int n,w,l,time,sum;
	static Queue<Integer> q = new LinkedList<Integer>();
	static ArrayList<Integer> bridge = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(true) {
			if(!bridge.isEmpty() && bridge.size() >= w) {
				sum-=bridge.get(0);
				bridge.remove(0);
			}
			if(!q.isEmpty() && sum + q.peek() <= l) {
				int truck = q.poll();
				bridge.add(truck);
				sum+=truck;
			}else {
				bridge.add(0);
			}
			time++;
//			System.out.println(bridge.toString());
			if(sum==0) break;
		}
		
		System.out.println(time);
	}
	
//	private static int bridgeSum() {
//		int sum=0;
//		for(int i=0; i<bridge.size(); i++) {
//			sum += bridge.get(i);
//		}
//		return sum;
//	}

}
