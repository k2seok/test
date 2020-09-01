package acmicpc_samsung;

import java.util.Scanner;

//https://www.acmicpc.net/problem/13458
public class Solution_13458 {

	/**
	 * 총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. 
	 * i번 시험장에 있는 응시자의 수는 Ai명이다.
		감독관은 총감독관과 부감독관으로 두 종류가 있다. 총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고, 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명이다.
		각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
		각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.
		
		-풀이
		 arr[i]/B 만큼의 사람이 필요
		 
		 **result 값이 int 보다 커지는 경우가 있으므로 long 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int arr[] = new int[len];
		long result = 0; // 결과값 크기 확인!!
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
			
		final int A = sc.nextInt();
		final int B = sc.nextInt();
		
		
		for (int i = 0; i < arr.length; i++) {
			int now =  arr[i];
			// A 빼기
			now -= A;
			result++;
			if(now < 1) {
				continue;
			}
			
			//B만큼 제거
			int numB = now/B > 0 ? now/B + (now%B > 0 ? 1 : 0) : 1;
			now -= numB*B; // test
			if(now > 0)
				System.out.println("err");
			result += numB;
		}
		System.out.println(result);
	}
}