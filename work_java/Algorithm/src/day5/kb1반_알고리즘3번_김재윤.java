package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class kb1반_알고리즘3번_김재윤 {

	static int[][] arr;
	static int ridx, cidx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		ridx = -1;
		cidx = -1;
		// 검은알 1 , 흰알 2
		boolean flag = false;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++)
				if (arr[i][j] != 0 && isCorrect(i, j, arr[i][j])) {
					System.out.println(arr[i][j]);
					System.out.println((ridx + 1) + " " + (cidx + 1));
					flag = true;
					break;
				}
			if (flag)
				break;
		}
		if (!flag)
			System.out.println(0);
	}//

	static boolean isCorrect(int i, int j, int color) {
		int row = i;
		int col = j;
		int cnt = 0;
		// 1. 가로
		while (arr[row][col++] == color) {
			cnt++;
			if (col > 18)
				break;
		}
		col = j;
		while (arr[row][col--] == color) {
			cnt++;
			if (col < 0)
				break;
		}
		if (--cnt == 5) {
			ridx = i;
			cidx = j;
			return true;
		} else
			cnt = 0;
		// 2. 세로
		row = i;
		col = j;
		while (arr[row--][col] == color) {
			cnt++;
			if (row < 0)
				break;
		}

		row = i;
		while (arr[row++][col] == color) {
			cnt++;
			if (row > 18)
				break;
		}
		if (--cnt == 5) {
			ridx = i;
			cidx = j;
			return true;
		} else
			cnt = 0;
		// 3. 왼쪽 밑 대각선 -> 오른쪽 위 대각선 ( / 방향)
		row = i;
		col = j;
		while (arr[row++][col--] == color) {
			cnt++;
			if (row > 18 || col < 0)
				break;
		}
		ridx=row-2;
		cidx=col+2;
		row = i;
		col = j;
		while (arr[row--][col++] == color) {
			cnt++;
			if (row < 0 || col > 18)
				break;
		}
		if (--cnt == 5) {
			return true;
		} else
			cnt = 0;
		// 4. 왼쪽 위 대각선 -> 오른쪽 아래 대각선 ( \ 방향)
		row = i;
		col = j;
		while (arr[row--][col--] == color) {
			cnt++;
			if (row < 0 || col < 0)
				break;
		}
		row = i;
		col = j;
		while (arr[row++][col++] == color) {
			cnt++;
			if (row > 18 || col > 18)
				break;
		}
		if (--cnt == 5) {
			ridx = i;
			cidx = j;
			return true;
		} else
			return false;
	}
}//
