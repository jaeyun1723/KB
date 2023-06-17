package PROG;
import java.util.*;
import java.io.*;

class Solution {
	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int MOD = 1000000007;
		int[][] dp = new int[n + 1][m + 1];
		dp[1][1] = 1;
		for (int i = 0; i < puddles.length; i++)
			dp[puddles[i][1]][puddles[i][0]] = -1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i][j] == -1)
					continue;
				else {
					if (dp[i - 1][j] > 0)
						dp[i][j] += dp[i - 1][j] % MOD;
					if (dp[i][j - 1] > 0)
						dp[i][j] += dp[i][j - 1] % MOD;
				}
			}

		}
		answer = dp[n][m] % MOD;
		return answer;

	}//
}//