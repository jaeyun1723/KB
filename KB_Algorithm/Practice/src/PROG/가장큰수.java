package PROG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;

public class 가장큰수 {

	public static void main(String[] args) {
//		int[] numbers = { 3, 33, 34, 30, 9, 5 };
		String[] numbers= {"asa","asb","aza","ATB","Atb","aTB"};
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i]+" ");
//		String answer="";
//		String[] str = new String[numbers.length];
//		for (int i = 0; i < numbers.length; i++)
//			str[i] = String.valueOf(numbers[i]);
//		Arrays.sort(str);
//		for (int i = 0; i < str.length; i++)
//		System.out.print(str[i]+" ");
	}

}
