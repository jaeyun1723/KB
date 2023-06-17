package A_230412;

import java.util.Arrays;

public class PRG_구명보트_김재윤 {

	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int start=0,end=people.length-1;
	        while(start<=end){
	            if(people[start]+people[end]<=limit)
	            {
	                start++; end--;
	            }
	            else
	                end--;
	            answer++;
	        }
	        return answer;
	    }
	}

}
