import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class programmers_43238 {

	/**
	 * 
		 
		 완탐 , 가지치기
		 
		 tiems.sort()
		 // 가장 오래걸리는 시간 ? 
		 mx : times[len(times)-1]* n
		 
		 tims에서 작은 p가 얼마나 빨리처리하는지가 중요.
		 p0 을 가장 많이 사용한경우,  6 is 42
		 p0 5 is 7*5
		 p0 4 is 7*4  p1 20   .. 28
		 p0 3 is 7*3  p1 30  ... 30   .. end
		 
		 1) max값 찾기
		 2) 작은값부터 검색
		 2.1) prevV < nextV  is end goto 2.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(6, new int[] {7,10}));

	}

	static int[] arr;

	static int N = 0;
	static long answer = 0;
	public static long solution(int n, int[] times) {
//		long answer = 0;
		
		N = n;
		Arrays.sort(times);
		
//		1)
		answer =  (long)(times[times.length-1]*n);
		
		//2)
		for (int cnt = n; cnt > 0; cnt--) {
			recul(0,cnt, N);
		}
		
		return answer;
	}
	private static void recul(int idx, int pay, int cnt) {
		//end : cnt-pay;    cnt - pay < 1 end : recul?  
		
	}

}