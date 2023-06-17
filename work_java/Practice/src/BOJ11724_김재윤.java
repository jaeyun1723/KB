
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int N, M;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		// 2개 간선 정보 담는
		System.out.println(ConnectedComponent(0));
	}// etc

	static int ConnectedComponent(int count) {
		for (int i = 1; i <= N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				count++;
				dfs(i);
			}
		}
		return count;
	}

	static void dfs(int startNode) {
		for (int node : graph[startNode]) {
			if (!isVisited[node]) {
				isVisited[node] = true;
				dfs(node);
			}
		}
	}
}// etc
