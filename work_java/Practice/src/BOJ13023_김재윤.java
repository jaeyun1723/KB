import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int N, M;
	static boolean[] isVisited;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N];
		isVisited = new boolean[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			isVisited[i] = true;
			isFriends(i, isVisited, 1);
			if (flag) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}// etc

	static void isFriends(int start, boolean[] visited, int cnt) {
		if (cnt == 5) {
			flag = true;
			return;
		}
		for (int i = 0; i < graph[start].size(); i++) {
			if (!visited[graph[start].get(i)]) {
				visited[graph[start].get(i)] = true;
				isFriends(graph[start].get(i), visited, cnt + 1);
				visited[graph[start].get(i)] = false;
			}
		}
	}
}// etc