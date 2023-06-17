import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		String s = "Dsf";
		int[] arr = new int[3];
		stk.peek();
		sb.append(s);
		sb.append(sb.charAt(0));
		System.out.println(sb.toString());
		sb.append(sb.charAt(0));
		sb.deleteCharAt(sb.length() - 1);
	}// etc

}// etc