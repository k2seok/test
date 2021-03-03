import java.util.Arrays;

public class programmers_43238 {
// Solution
	/**
	 * 
		 이분탐색 : like 분할-정복
		 
		 완탐 , 가지치기 > 시간복잡도 n^2 은 해결할 수 없는 문제, 
		 이분탐색을 활용한 최소 nlogn 처리가 필요.
		 
		 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(6, new int[] {7,10}));
		System.out.println(solution(1000000000, new int[] {1, 1000000000, 1000000000}));
		//1000000000

		System.out.println(solution(1000000000, new int[] {2,45,4,2,1,6,7,8,9,11}));
//		System.out.println(solution(n, new int[] {2,45,4,2,1,6,7,8,9,11}));
	}

	static int[] arr;
	static int[] arrCnt;

	static int N = 0;
	static int MAXV = 0;
	static long answer = 0;
	static int maxIdx= 0;
	public static long solution(int n, int[] times) {
//		long answer = 0;
		
		N = n;
		answer = 0;
		Arrays.sort(times);
		arr = times.clone();
		int max = -1;
		int idx = times.length-1;
		while(max < 0) {
			max = times[idx]*n;
			if(max < 0) //max Int
				idx--;
		}
		
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
	private static void bs(long left, long right) {
		
		//right idx 줄이기
		int idx = (int)Math.log10(right)+1;
		idx++; // min is 2
//		System.out.println(idx);
		
		long mid = (left + right)/idx; //30 10 15 20  3 2 1 
		int v= 0;
		for (int a : arr) {
			if(a > mid) { // useless
				break;
			}
			if(v > N) {
				//branch
				break;
			}
			v += mid/a;
		}
//		for (int idx = 0; idx < arr.length; idx++) {
//			int a = arr[idx];
////			int cnt = arrCnt[idx];
//			int cnt = 1;
//			if(a > mid) { // useless
//				break;
//			}
//			v += mid/a*cnt;
//		}
		
		if(left == right)
			answer = left; //end
		
		if(answer > 0) //all End
			return;
		
		
		if(v < N) {
			bs((mid == left ? right : mid), right);	// to right
		}else if(v > N){
			bs(left, (mid == right ? left : mid));	// to left
		}else {
			//find : mid is answer
			answer = mid;
		}
			
	}

}