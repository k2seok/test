import java.util.Arrays;

public class programmers_42747 {
//Solution

	// https://programmers.co.kr/learn/courses/30/lessons/42747
	/*
	 * H-index : 정렬 , 시뮬레이션
	 * 문제 조건에 따라 조건 추가
	 * ++ 숨어있는 조건 ) 조건에 일치하는 정답이 없는 경우 0 반환
	 * +++ 주의해야할 조건 ) 문제설명에  따라 h가 큰 값 부터 찾는경우, 
	 *  rH >= h (h번 이상 인용된 논문) 은 만족하나,
	 *  lH <= h (h번 이하 인용된 논문)만족 조건을 놓치는 경우가 발생할 수 있음 (case9번)
	 *  > 반복문을 증감식으로 작성 시 해결 ( 혹은 rH가 모든 값에 포함되는지 체크하면 됨)
	 */
	public static int solution(int[] arr) {
//		int answer = 0;

		final int N = arr.length;
		int max = 0;

		Arrays.sort(arr);
		for (int _c : arr) {
			max += _c;
		}
		int avr = max / N;

		// 1 인경우
		for (int h = arr[arr.length - 1]; h > -1; h--) { // 임의의 MAX값에서 시작
			int rH = 0;
			int lH = 0;
			// find rh
			for (int idx_r = arr.length - 1; idx_r >= -1; idx_r--) { // end check를 위해 -1 까지 실행
				if (idx_r < 0) // end: 모든 값이 rH에 포함됨
					rH = arr.length;
				else if (h <= arr[idx_r]) //
					continue;
				// v > now : idx_r 은 rH 값의 시작 -1 idx
				rH = N - (idx_r + 1);
				if (rH < h) // false : next
					break;

				// idx_r == 현재 값 중 가장 작은 h
				for (int idx_l = 0; idx_l < (idx_r > 0 ? idx_r : 1); idx_l++) {
					if (arr[idx_l] > h)
						break;
					lH++;
				}

				if (lH <= h)
					return h; // end
			}

		}

		return 0;
	}

	public static void main(String[] args) {

		int[] s = new int[] { 1, 2 }; /// answer : 1 (case11)
//		int[] s = new int[] { 100, 200,300 }; /// answer : 3 (case9)
		System.out.print(solution(s));
	}
}
