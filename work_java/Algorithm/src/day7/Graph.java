package day7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	static int[][] adjMatrix;
	static boolean[] isVisited;
	static int N, E;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjMatrix = new int[N][N];
		isVisited = new boolean[N];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = 1;
		}

		BFS(0);
		System.out.println();
		isVisited=new boolean[N];
		DFS(0);

	}//

	static void DFS(int curr) {
		System.out.print(curr + " ");

		for (int i = 0; i < N; i++) {
			if (adjMatrix[curr][i] != 0 && !isVisited[i]) {
				isVisited[i] = true;
				DFS(i);
			}
		}
	}

	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();

		// 시작 정점
		queue.offer(start);
		isVisited[start] = true;
		while (!queue.isEmpty()) {

			int curr = queue.poll();
			System.out.print(curr + " ");

			for (int i = 0; i < N; i++)
				if (adjMatrix[curr][i] != 0 && !isVisited[i]) {
					isVisited[i] = true;
					queue.offer(i);
				}
		}
	}

}//

//7
//8
//0 1
//0 2
//1 3
//1 4
//3 5
//4 5
//5 6
//2 6
