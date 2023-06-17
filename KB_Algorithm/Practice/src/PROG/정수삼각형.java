package PROG;

public class 정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int answer = 0;
		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = 7;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					dp[i][0] = dp[i - 1][0] + triangle[i][0];
				else if (j == i)
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
			}
		}
		answer = 0;
		for (int i = 0; i < dp.length; i++) {
			answer = Math.max(answer, dp[dp.length - 1][i]);
		}

		System.out.println(answer);
		
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++)
				System.out.print(triangle[i][j] + " ");
			System.out.println();
		}
		System.out.println("----------------------");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}

	}
}
