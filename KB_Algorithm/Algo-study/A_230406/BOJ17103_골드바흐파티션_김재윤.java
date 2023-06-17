package A_230406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17103_골드바흐파티션_김재윤 {

	static boolean[] primeNum;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		primeNum = new boolean[1_000_001];

		isPrime();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int j = 2; j <= num / 2; j++) {
				if (!primeNum[j] && !primeNum[num - j])
					cnt++;
			}
			System.out.println(cnt);
		}


	}//

	static void isPrime() {
		for (int i = 2; i * i <= 1_000_000; i++)
			if (!primeNum[i]) {
				for (int j = i * 2; j <= 1_000_000; j += i)
					primeNum[j] = true;
			}
	}

}//