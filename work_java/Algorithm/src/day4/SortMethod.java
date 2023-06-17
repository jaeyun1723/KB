package day4;

import java.util.*;

public class SortMethod {

	public static void main(String[] args) {
		int[] arr1= {5,4,1,3,2};
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		String[] arr2= {"apple","samsung","Lg","google"};
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		ArrayList<Integer> arr3=new ArrayList<>();
		arr3.add(5);
		arr3.add(4);
		arr3.add(1);
		arr3.add(3);
		arr3.add(2);
		Collections.sort(arr3,Collections.reverseOrder());
		System.out.println(arr3.toString());

		ArrayList<String> arr4=new ArrayList<>();
		arr4.add("apple");
		arr4.add("samsung");
		arr4.add("lg");
		arr4.add("google");
		Collections.sort(arr4,Collections.reverseOrder());
		System.out.println(arr4.toString());
		
		Integer[] arr5 = {5,4,1,3,2};
		Arrays.sort(arr5,Collections.reverseOrder());
		System.out.println(Arrays.toString(arr5));
		
		
	}//etc

}//etc
