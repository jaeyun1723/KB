package day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// 1차원 배열 구간 합
public class BOJ11659 {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] input = br.readLine().split(" ");
//		System.out.println(Arrays.toString(input));
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[M + 1];
		int[] dp = new int[M + 1];
		for (int i = 0; i < M; i++)
			arr[i + 1] = sc.nextInt();
		dp[0] = 0;
		for (int i = 1; i <= M; i++)
			dp[i] = dp[i - 1] + arr[i];
		int sum = 0;
		while (N-- > 0) {
			int i, j;
			sum = 0;
			i = sc.nextInt();
			j = sc.nextInt();
			System.out.println(dp[j] - dp[i-1]);
		}
	}//etc
}//etc
