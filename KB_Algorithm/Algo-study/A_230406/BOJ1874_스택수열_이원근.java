package A_230406;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1874_스택수열_이원근 {

	//필드 선언
	static int n;	//입력 받을 수의 개수
	static int[] arrTarget;  //만들어야 할 배열
 	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		arrTarget = new int[n];
		
		for (int i = 0; i < n; i++) {
			arrTarget[i] = sc.nextInt();
		}
		
		int curr = 1;	//자연수. 1부터 시작
		for (int i = 0; i < n; i++) {	//1부터 n까지 반복
			int target = arrTarget[i];	//목표값
			if(target>= curr) {	//목표값이 자연수와 값이 같아질 때 까지 스택에 자연수 삽입
				while(target >= curr) {
					stack.push(curr);
					curr++;		//자연수 증가
					System.out.println("+");
				}
				stack.pop();	//자연수와 값이 같아졌다면 top값 반환
				System.out.println("-");
			} else {	//목표값이 자연수보다 크다면 스택의 값을 빼줘야함
				int top = stack.pop();
				if (top > target) {	//스택의 top값이 자연수보다 크면 출력 불가
					System.out.println("NO");
					break;
				} else {	//스택의 top값을 뺀다.
					System.out.println("-");
				}
				
			}
			
		}
		
	}

}
