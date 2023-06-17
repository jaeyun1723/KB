package Baekjoon.B2018_자연수의합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2018_수들의합5_김재윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int sum = 0;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {	// 1 부터 N 까지
			int k = i;	// 시작점
			sum = 0;
			while (sum < N) {	// 연속하는 숫자 계산
				sum += k;
				k++;
			}
			if (sum == N)
				cnt++;
		}
		System.out.println(cnt);
	}

}
