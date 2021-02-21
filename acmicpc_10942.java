import java.util.Scanner;

public class acmicpc_10942 {
//Main
	/**
	 * 10942 펠린드롬? 목표 : N 개의 자연수 나열된값중 M개의 질문을 통해 펠린드롬인지 t/f 반환
	 * 
	 * 1) N개 자연수 입력 , M개 질문 입력 2) 질문시마다 팰린드롬 계산 cal() 3) cal 은
	 * 
	 * t / f 반환 최소단위 값 t 반환 ! t면false 반환
	 * 
	 * prev idx 와 next idx 가 pIdx >= nIdx 면 모두 일치 true반환 prev 값과 next 값이 일치하면 true
	 * 반환
	 * 
	 * 
	 * @param args
	 */
	static int N = 0;
	static String[] arr = null;

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		arr = sc.nextLine().split(" ");

		final int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			
			System.out.println(palin(s,e) ? "1"	: "0"); // 결과
		}
		
	}

	private static boolean palin(int sIdx, int eIdx) {
		if(sIdx >= eIdx ) //완료 : 일치
			return true;
		
		if(arr[sIdx].equals(arr[eIdx])) {
			return palin(sIdx +1 , eIdx - 1); 
		}else
			return false;
	}
}