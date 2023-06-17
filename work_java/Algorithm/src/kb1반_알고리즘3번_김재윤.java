import java.util.*;
import java.io.*;

public class kb1반_알고리즘3번_김재윤 {

	static class dot {
		int x;
		int y;

		dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, min, yidx = 1;
	static Character[][] dot;
	static int[] xidx = { 0, -1, 1 };
	static int[] visitCol;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		dot = new Character[R + 1][C + 1];
		isVisited = new boolean[R + 1][C + 1];
		visitCol = new int[C + 1];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++)
				dot[i][j + 1] = str.charAt(j);
		}
//		for (int i = 1; i <= R; i++) {
//			for (int j = 1; j <= C; j++)
//				System.out.print(dot[i][j]+" ");
//			System.out.println();
//		}
		for (int i = 1; i <= R; i++) {
			isVisited[i][1] = true;
		}
		isAvailable(1);
	
		int ant = 2000000;
		for (int i = 2; i <= C; i++)
			ant = Math.min(ant, visitCol[i]);
		System.out.println(ant);
	}// etc

	static void isAvailable(int start_col) { // 2줄씩 검사
		Queue<dot> queue = new LinkedList<>();
		for (int i = 1; i <= R; i++) {
			if (isVisited[i][start_col] && dot[i][start_col] == '.')
				queue.add(new dot(i, start_col));
		}
		while (!queue.isEmpty()) {
			dot now = queue.poll();
			for (int i = 0; i < 3; i++) {
				int x = now.x + xidx[i];
				int y = now.y + yidx;
				if (x > R || x < 1 || y > C || y < 1 || dot[x][y] == 'x' || isVisited[x][y])
					continue;
				if (dot[x][y] == '.') {
					isVisited[x][y] = true;
					visitCol[y]++;
					queue.add(new dot(x, y));
				}
			}
		}
	}
}// etc
