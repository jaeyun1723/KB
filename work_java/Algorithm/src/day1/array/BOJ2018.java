package day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합(실버5)
public class BOJ2018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
//------------------------------------------------------------------
		int start = 1, end = 1;	// 투 포인터
		int count = 0, sum = 1;

		while (end <= N) {
			if (sum == N) {	// 개수++, start++, end++, 합 변경
				count++; start++; end++;
				sum -= start - 1;
				sum += end;
			} else if (sum < N) {	// end++, 합 변경
				end++;
				sum += end;
			} else if (sum > N) {	// start++, 합 변경
				start++;
				sum -= start - 1;
			}
		}
			System.out.println(count);
//------------------------------------------------------------------
//		int sum = 0;
//		int cnt = 0;
//		for (int i = 1; i <= N; i++) {	// 1 부터 N 까지
//			int k = i;	// 시작점
//			sum = 0;
//			while (sum < N) {	// 연속하는 숫자 계산
//				sum += k;
//				k++;
//			}
//			if (sum == N)
//				cnt++;
//		}
//		System.out.println(cnt);

	}// etc

}// etc
