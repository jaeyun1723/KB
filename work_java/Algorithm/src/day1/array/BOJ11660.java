package day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 2차원 배열 구간 합(실버1)
public class BOJ11660 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				arr[i][j] = Integer.parseInt((st.nextToken()));
		}
		int[][] dp=new int[N+1][N+1];
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++)
				dp[i][j]=dp[i][j-1]+dp[i-1][j]+arr[i][j]-dp[i-1][j-1];
		while(M-->0) {
			int sum=0;
			st = new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			int y1=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			int x2=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			int y2=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
		}

	}// etc

}// etc
