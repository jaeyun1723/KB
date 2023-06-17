package day8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import day1.array.Array;

public class AdjList {

	static ArrayList<Integer>[] adjList;
	static int N, E;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjList = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			// adjList[to].add(from);
		}

		BFS(0);
	}//

	static void DFS(int currNode) {
		System.out.println(currNode);
		for (int node : adjList[currNode]) {
			if (!visited[node]) {
				visited[node] = true;
				DFS(node);
			}
		}
	}

	static void BFS(int startNode) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(startNode);
		visited[startNode] = true;

		while (!queue.isEmpty()) {
			int currNode = queue.poll();
			System.out.print(currNode);

			for (int node : adjList[currNode]) {
				if (!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}
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
