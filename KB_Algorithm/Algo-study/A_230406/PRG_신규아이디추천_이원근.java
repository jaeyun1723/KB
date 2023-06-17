//단계
// 1. 대문자 -> 소문자로
// 2. 소문자,숫자, -, _, .만 남기고 다 제거
// 3. ..은 .으로 치환
// 4. .이 처음이나 끝에 있으면 제거
// 5. id가 빈 문자열이면 a 대입
// 6. 16자 이상이면 앞에서 15글자까지만 자름
// 7. .이 끝에 위치하면 . 제거
// 8. id가 2자 이하라면 마지막 문자를 길이가 3이 될 때 까지 반복
package A_230406;

class PRG_신규아이디추천_이원근 {
    public String solution(String new_id) {
        
	String answer = new_id;
		
		
	// 1. 대문자 -> 소문자로
        answer = answer.toLowerCase();
        
        //2. 소문자,숫자, -, _, .만 남기고 다 제거
        //^는 not을 의미함. 대괄호 안의 문자들만 남기고 나머지는 다 치환의 대상이 됨.
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        
        //3. ..은 .으로 치환
        //contains() : 지정한 문자열을 포함하고 있는지 확인함
        while(answer.contains("..")) {
        	answer = answer.replace("..", ".");        	
        }
        
        //4. .이 처음이나 끝에 있으면 제거
        //charAt() : 문자열의 특정 인덱스에 해당하는 글자를 추출함
        //문자열의 첫글자나 마지막 글자에 . 이 존재하는 한 삭제를 계속 반복함.
        while(answer.charAt(0) == '.' || answer.charAt(answer.length()-1) == '.') {
        	if (answer.length() > 1) {
        		if (answer.charAt(0) == '.') {	//첫번째 글자에 .이 존재한다면
        			answer = answer.substring(1,answer.length());
        		}
        		if (answer.charAt(answer.length()-1) == '.') {	//마지막 글자에 . 이 존재한다면
        			answer = answer.substring(0,answer.length()-1);
        		}
        	} else answer = "a";
        }
        
        //5. id가 빈 문자열이면 a 대입
        if(answer.length() == 0) {
        	answer = "a";
        }
        
        //6. 16자 이상이면 앞에서 15글자까지만 자름
        if(answer.length() >15) {
        	answer = answer.substring(0, 15);
        }
        
        //7. .이 끝에 위치하면 . 제거
        while(answer.charAt(answer.length()-1) == '.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        
        //8. id가 2자 이하라면 마지막 문자를 길이가 3이 될 때 까지 반복
        while(answer.length() <= 2) {
        	answer = answer + answer.charAt(answer.length()-1);
        }
	
        
        return answer;
    }
}
