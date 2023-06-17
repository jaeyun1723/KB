package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreeDFS {

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
		DFS(1);
	}//

	static void DFS(int currIndex) {
		if (currIndex * 2 <= LastIndex)
			DFS(currIndex * 2);
		if (currIndex * 2 + 1 <= LastIndex)
			DFS(currIndex * 2 + 1);
		System.out.print(nodes[currIndex]+" ");
	}

}//
