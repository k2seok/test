import java.util.Arrays;
import java.util.Scanner;

///https://www.acmicpc.net/problem/14503
public class acmicpc_2805 {
	// public class Main {

	/*
	 * 
	 * v 만큼의 자를때.. 자른결과값 r < M 인경우
	 * 더 잘라봐야함 : v--  (r이 더커짐)
	 * r >= M 인 경우 더 적게 잘라봐야함 : v++
	 * 
	 *   
	 */
	
	static int[] arr = null;
	static int N = 0;
	static int M = 0;
	public static void main(String[] args) {

//		System.out.println(Long.MAX_VALUE >= Math.pow(10, 15)); // true
//		4 7
//		20 15 10 17
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		long answer = 0;
		boolean end = false;
		long left = 1;
		long right = arr[arr.length-1]-1; 
		long cut = (left +right)/2; //중간값
		while(!end) {
			
			long r = 0; // r MAX :  10^9 * 10^6
			int count = 0;
			//check
			for (int  a : arr) {
				long v = a - cut < 0 ? 0 : a - cut;
				if(v> 0) {
					r+=v;
					count++;
				}
				
//				if(r >= M) {
//					answer = cut; //enough
//					left = cut;
//					break;
//				}
			}
			
			if(answer == cut)
				end = true;
			if(r> M) {
				// more cut
				long ng = (r - M)/count;  // enough average;
				cut += ng;
				answer = cut;
			}else {
				// r< M //
				long ng = M - r == 0 ? 1 : M - r; 
				cut-= ng;
			}
			
			for (int i = 0; i < args.length; i++) {
				
			}
		}
		
		//max 
		//result 
		System.out.println(answer);
	}

	
}