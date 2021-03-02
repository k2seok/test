import java.util.Arrays;

public class programmers_43238 {
// Solution
	/**
	 * 
		 이분탐색 : like 분할-정복
		 
		 완탐 , 가지치기 > 시간복잡도 n^2 은해결할 수 없는 문제, 
		 이분탐색을 활용한 최소 nlogn 처리가 필요.
		 
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
		 
		 
		 
		 6*10 : max
		 1 :	min
		 
		 59
		 29
		 1 ~ 14 	15 ~ 29
		 v = max;  
		 
		 min ~ v/2 -1 |  v/2 ~ v 
		 v/7 + v/10  <= n 인경우, 더 큰 값필요 end
		 else 범위에서 다시 검색
		 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(6, new int[] {7,10}));

	}

	static int[] arr;

	static int N = 0;
	static int MAXV = 0;
	static long answer = 0;
	static int maxIdx= 0;
	public static long solution(int n, int[] times) {
//		long answer = 0;
		
//		n = 1000000000; // 문제발생!
//		Arrays.fill(times, 1);
		N = n;
		Arrays.sort(times);
		arr = times.clone();
		int max =times[times.length-1]*n;
		if(max < 0) //max Int
			max = Integer.MAX_VALUE;
		
		bs(1,max);
		
//		1) max value 
//		answer =  (long)(times[times.length-1]*n);
//		answer = Long.MAX_VALUE;
//		maxIdx = ((int)answer) < 0 ? Integer.MAX_VALUE : ((int)answer);
//		//1.1) max idx : answer 
		
		
		//2)
//		for (int cnt = n; cnt > 0; cnt--) {
//		}
		
		return answer;
	}
	private static void bs(int minV, int maxV) {
		int mid = maxV/2;
		int v= 0;
		for (int a : arr) {
			v += mid/a;
		}
		
		if(v > N) {
		}else {
			// TODO Auto-generated method stub
			
		}
		
	}

}