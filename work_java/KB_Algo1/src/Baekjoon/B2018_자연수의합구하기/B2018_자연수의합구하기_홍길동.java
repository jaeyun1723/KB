package Baekjoon.B2018_자연수의합구하기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B2018_자연수의합구하기_홍길동 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int tot = 0;
		int count = 0;
		int idx = 1;
		while(tot < n){
			tot += idx;
			idx += 1;}
			
		for(int i=1; i<n+1; i++) {
			if(i!=1) {
				tot -= (i-1);
				if(tot < n) {
					tot += idx;
					idx += 1;}}
			if(tot == n) count += 1;
		}
		System.out.println(count);
	}}
