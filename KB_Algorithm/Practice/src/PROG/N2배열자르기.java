package PROG;

import java.util.ArrayList;

public class N2배열자르기 {


	class Solution {
	    public int[] solution(int n, long left, long right) {
	        int[] answer = {};
			long row = left / n;
			long col = left % n;
			long cnt = right - left + 1;
			answer = new int[(int) cnt];
			int idx = 0;
			while (cnt-- > 0) {
				if (col == n) {
					col = 0;
					row++;
				}
				answer[idx++] = (int) Math.max(row + 1, ++col); // col 이 문제
			}
	        return answer;
	    }
	}//

}
