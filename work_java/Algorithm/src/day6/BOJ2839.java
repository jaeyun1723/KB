package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		boolean flag = false;
		while (N > 0) {
			if (N % 5 == 0) {
				cnt += N / 5;
				flag = true;
				break;
			} else {
				N -= 3;
				cnt++;
			}
			if (N < 3)
				break;

		}
		if (flag || N == 0)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}//

}//
