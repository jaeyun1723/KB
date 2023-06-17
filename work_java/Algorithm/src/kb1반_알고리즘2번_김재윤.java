import java.util.*;
import java.io.*;

public class kb1반_알고리즘2번_김재윤 {

	static class dot {
		int row;
		int col;
		int quit;

		dot(int row, int col, int quit) {
			this.row = row;
			this.col = col;
			this.quit = quit;
		}
	}

	static int R, C, student, date;
	static int[][] place;
	static boolean[][] isVisited;
	static int[] xidx = { -1, 1, 0, 0 };
	static int[] yidx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		place = new int[R + 1][C + 1];
		isVisited = new boolean[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				place[i][j + 1] = str.charAt(j) - '0';
				if (place[i][j + 1] == 1)
					student++;
			}
		}
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		corona(row, col);
		System.out.println(date);
		System.out.println(student);
		
	}// etc

	static void corona(int row, int col) {
		Queue<dot> queue = new LinkedList<>();
		isVisited[row][col] = true;
		student--;
		queue.add(new dot(row, col, 3));
		while (!queue.isEmpty()) {
			dot now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = now.row + xidx[i];
				int y = now.col + yidx[i];
				int z = now.quit;
				if (x <= 0 || y <= 0 || x > R || y > C || isVisited[x][y] || place[x][y] == 0)
					continue;
				if (!isVisited[x][y] && place[x][y] == 1) {
					isVisited[x][y] = true;
					date = Math.max(date, now.quit + 1);
					student--;
					queue.add(new dot(x, y, z + 1));
				}
			}
		}
	}
}// etc
