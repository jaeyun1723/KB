package com.edu.exception.test;
/*
 * 컴파일 o (
 * 실행시 x
 */
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str = { "Hello", "No, I mean it", "Nice to meet you" };
		int i = 0;
		while (i <= 3) {
			try {
			System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				// 예외 잡혔을때의 코드
				System.out.println("Nice Catch");
			}
			i++;
		}
		
		System.out.println("while looping end....");
	}

}
