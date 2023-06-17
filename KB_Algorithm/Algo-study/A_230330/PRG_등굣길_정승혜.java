package A_230330;

import java.util.Arrays;

public class PRG_등굣길_정승혜 {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] mat = new int[n][m];
        for (int[] puddle : puddles) // 못지나가면 mat -1
            mat[puddle[1] - 1][puddle[0] - 1] = -1;
        mat[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == -1) continue;
                if (j - 1 >= 0 && mat[i][j - 1] != -1) mat[i][j] += mat[i][j - 1] % 1_000_000_007;
                if (i - 1 >= 0 && mat[i - 1][j] != -1) mat[i][j] += mat[i - 1][j] % 1_000_000_007;
            }
        }
        return (int) mat[n - 1][m - 1] % 1_000_000_007;
    }
// 시간초과
    /*
    public static void DFS(int r, int c) {
        if (r == row - 1 && c == col - 1) {
            count++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            int nrow = r + dy[i];
            int ncol = c + dx[i];
            if (nrow >= row || ncol >= col || mat[nrow][ncol] == -1) continue;
            DFS(nrow, ncol);
        }

    }
*/

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }
}
