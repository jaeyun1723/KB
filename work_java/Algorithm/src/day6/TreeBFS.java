package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreeBFS {

	static char[] nodes;
	static int SIZE, LastIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		SIZE = Integer.parseInt(st.nextToken());
		LastIndex = SIZE;
		nodes = new char[SIZE + 1];
		for (int i = 0; i < SIZE; i++)
			nodes[i + 1] = (char) ('A' + i);
		System.out.println(Arrays.toString(nodes));
		BFS();
	}//

	static void BFS() {
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		while (!que.isEmpty()) {;
			int currIndex = que.poll();
			System.out.print(nodes[currIndex]);
			if (currIndex * 2 <= LastIndex)
				que.add(currIndex * 2);
			if (currIndex * 2 + 1 <= LastIndex)
				que.add(currIndex * 2 + 1);
		}

	}
}//
