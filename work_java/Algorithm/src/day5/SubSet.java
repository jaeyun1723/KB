package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubSet {

	static int N, totalCnt;
	static int[] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		isSelected = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		subset(0);
		System.out.println(totalCnt);
	}//

	static void subset(int cnt) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(isSelected));
			for(int i=0;i<N;i++) {
				if(isSelected[i]) System.out.print(arr[i]+ " ");
			}
			System.out.println();
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1);

		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}//
