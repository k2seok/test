import java.util.Scanner;


public class acmicpc_561 {

	/*
	 *Zero One Algorithm Contest 2020 Open Contest  G   ㅋㅋ루ㅋㅋ 문제
	 * R은 ㅋㅋ루ㅋㅋ 
	 * K는 R의 양옆에붙을경우 ㅋㅋ루ㅋㅋ가 된다.
	 *부분집합을 만들어서 가장 긴 ㅋㅋ루ㅋㅋ의 개수를 구하시오
	 *		//KKRKK 	5  
	 *	// RRKRR		4  : R만 사용
	 * 입력된 문자열 개수를 사용해 최고 홀수 값만들기
	 * 
	 * 
	 * 풀이
	 * 기
	최대입력 3,000,000
	 r 의 개수 == 최대 값
	 
	 1) r을 모두 입력 == count += r
	 2) 남은 k를 양옆에  k2 만큼 더하기  += k/2
	 
	 */
	public static void main(String[] args) {

		int count = 0;

		int K = 0;
		int R = 0;
		Scanner sc = new Scanner(System.in);
		String arr[] = sc.nextLine().split("");
		// max : O(n)
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals("K"))
				K++;
			else
				R++;
		}
		
		count += R;		// 홀수		//짝수		//1개
		count += K%2 > 0 ? K-1 : K != 1 ? K : 0;
		
		System.out.println(count);
	}
}
