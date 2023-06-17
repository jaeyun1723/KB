package day2;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stk= new Stack<>();
		
		stk.push(100);
		stk.push(200);
		stk.push(300);
		stk.push(400);
		stk.push(500);
		
		
		System.out.println(stk.toString());
		int top=stk.pop();
		System.out.println(top + " " + stk.toString());
		System.out.println(stk.peek());
		while(!stk.isEmpty()) {
			System.out.println(stk.toString());
			stk.pop();
		}
	}

}
