package PROG;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

public class 프린터 {

	public int solution(int[] priorities, int location) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < priorities.length; i++)
			pq.add(priorities[i]);

		while (!pq.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (pq.peek() == priorities[i]) {
					if (i == location) {
						answer++;
						return answer;
					}
					pq.poll();
					answer++;
				}
			}
		}
		return -1;

	}

}
