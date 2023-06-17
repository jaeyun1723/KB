package com.edu.exception.test2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * CompileException
 * 1. 컴파일 X :: 컴파일러가 인식
 * 2. 반드시 명시적으로 예외처리해서 사용해야하는 일종의 문법구조
 */
class FileReading {
	// 발생한 예외를 즉각적으로 잡지않고 던졌다... 호출한 지점으로 예외가 날라간다.
	public void readFile(String fileName) throws FileNotFoundException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("1. 파일을 찾을 수 없습니다.");
		} finally {

			reader.close();

		}
		System.out.println("2. FileReader API Creating");
	}
}

public class CompileExceptionTest2 {

	public static void main(String[] args) throws Exception{
		FileReading fr = new FileReading();
		try {
			fr.readFile("C:\\KB\\workshop_homwork\\java_r_01\\java_r1_Workshop.pdf");
		} catch (Exception e) {

		}

		System.out.println("3. 파일을 잘 읽어들였습니다.");
	}

}
