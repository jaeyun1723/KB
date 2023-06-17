package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 2주차 과제
// https://www.acmicpc.net/problem/10986
// 나머지 합(골드3)
public class HW1_BOJ10986_김재윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N + 1];
		long[] dp = new long[N + 1];
		long[] remain = new long[M];
		long cnt = 0;
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = (Integer.parseInt(st.nextToken())) % M;
			dp[i] = (dp[i - 1] + arr[i]) % M;
			if (dp[i] == 0)
				cnt++;
			remain[(int)dp[i]]++;
		}
		
		for (int i = 0; i < M; i++) {
			if (remain[i] >= 2)
				cnt += remain[i] * (remain[i] - 1) / 2;
		}
		System.out.println(cnt);
//	1 2 3 1 2
//	1 2 0 1 2
		
		
	}// etc

}// etc
