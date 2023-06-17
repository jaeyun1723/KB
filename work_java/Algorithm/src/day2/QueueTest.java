package day2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<Integer> que = new LinkedList<>();

		que.add(100);
		que.add(200);
		que.add(300);
		que.add(400);
		que.add(500);

		int front = que.remove();
		System.out.println(front + " " + que.toString());
		System.out.println(que.peek());
		while (!que.isEmpty()) {
			que.remove();
			System.out.println(que.toString());
		}
	}

}
