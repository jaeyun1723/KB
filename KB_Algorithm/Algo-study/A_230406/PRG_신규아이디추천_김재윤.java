package A_230406;

public class PRG_신규아이디추천_김재윤 {

	class Solution {
		public String solution(String new_id) {
			String answer = "";
			answer = new_id.toLowerCase(); // step1
			answer = answer.replaceAll("[^a-z0-9-_.]", ""); // step2
			answer = answer.replaceAll("[.]{2,}", "."); // step3
			answer = answer.replaceAll("^[.]|[.]$", ""); // step4
			if (answer.equals(""))
				answer += "a"; // step5
			if (answer.length() >= 16) {
				answer = answer.substring(0, 15);
				answer = answer.replaceAll("[.]$", "");
			}
			if (answer.length() <= 2)
				while (answer.length() != 3) {
					answer += answer.charAt(answer.length() - 1);
				}
			return answer;
		}
	}

}//
