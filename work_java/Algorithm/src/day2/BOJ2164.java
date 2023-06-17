package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long[] cnt = new long[4];
		cnt[0]=1;
		cnt[1]=13;
		cnt[2]=16;
		cnt[3]=11;
		Arrays.sort(cnt);
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			que.add(i);
		if (N == 1)
			System.out.println(que.peek());
		else {
			while (!que.isEmpty()) {
				que.remove();
				que.add(que.remove());
				if (que.size() == 1) {
					System.out.println(que.peek());
					return;
				}
			}
		}
	}

}
