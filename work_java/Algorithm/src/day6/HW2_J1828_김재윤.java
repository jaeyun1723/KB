package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class HW2_J1828_김재윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] temp = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(temp, (o1, o2) -> (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1]);
		int cnt = 0;
		int max = -300;
		for (int i = 0; i < N; i++) {
			if (max < temp[i][0]) {
				max = temp[i][1];
				cnt++;
			}

		}
		System.out.println(cnt);

	}//

}//
