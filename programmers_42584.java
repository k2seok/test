import java.util.ArrayDeque;
import java.util.Queue;

public class programmers_42584 {
//Solution

	/*
	 * >> mk2 : 효율성 개선을 위한 idx left, right 활용: O(N^2/2) 효율성 동일한 문제점 발생할 수 있음. 문제 케이스
	 * 모두 처리못해서 오답으로 처리되고 있음
	 * 
	 * 
	 * < time 만큼 실행
	 * 
	 * 1) now : que .add time마다  queue pop == idx
	 * 
	 * 2) idx <= now queue.add ans idx ++ 마지막 queue.add
	 * 
	 */
	// 10^5 효율성 떨어짐
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Queue<Integer> queue = new ArrayDeque<Integer>();

		// min : length > 1 이상
		for (int time = 0; time < prices.length; time++) {
			queue.add(time); // 현재 idx 추가

			int size = queue.size();
			int nowV = prices[time];
			for (int i = 0; i < size; i++) { // 1부터 유효
				int idx = queue.poll();
				if (idx == time) {
					answer[idx] = 0; // 현재가 0 부터 시작
				} else {
					answer[idx]++;
				}

				if (nowV >= prices[idx]) // 값이 떨어지지 않은 경우
					queue.add(idx);
				
				

			}

		}

		return answer;

	}

	public static void main(String[] args) {

		int[] prices = new int[100000];
		int f = 100000;
		for (int i = 0; i < 100000; i++) {
			prices[i] = f--;
		}

//		int[] prices = new int[] { 1, 2, 3, 2, 3, 1 }; // 5 4 1 2 1 0
//		int[] prices = new int[] { 1, 2, 3, 2, 3};
		for (int n : solution(prices)) {
			//System.out.print(n + " ");
		}
	}
}