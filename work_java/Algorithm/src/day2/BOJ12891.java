package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int S=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		
		String dna= new StringTokenizer(br.readLine()).nextToken();
		
		st= new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int g=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		
	}

}
