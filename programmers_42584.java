public class programmers_42584 {
//Solution

	/*
	 * >> mk2 : 효율성 개선을 위한 idx left, right 활용: O(N^2/2)
	 * 효율성 동일한 문제점 발생할 수 있음.
	 * 문제 케이스 모두 처리못해서 오답으로 처리되고 있음
	 * 
	 */
	// 10^5 효율성 떨어짐
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		// min : length > 1 이상
		for (int idx = 0; idx < prices.length; idx++) {
			int nowP = prices[idx];
			int len = prices.length;
//			int left = 0;
			int right = len;
			int rightIdx = len - 1;
			for (int leftIdx = idx; leftIdx < prices.length; leftIdx++) {
				if (nowP > prices[leftIdx]) {
					answer[idx] = leftIdx - idx; // 현재위치가 떨어지는 값임
					break;
				}

				if (leftIdx > rightIdx) // right 값 모두 확인
				{
					if (right < len) // right 중 최소값 idx
						answer[idx] = right - idx; //시작위치 만큼 -
					else // 한번도 떨어진 적이 없음.
						answer[idx] = len - 1 - idx;
					break;
				}
				if (nowP > prices[rightIdx])
					right = len - leftIdx; // right 작은값 중 최소 idx

				rightIdx--;
			}
		}

		return answer;

	}

	public static void main(String[] args) {

//		int[] prices = new int[100000];
		// 100,000
//		int f = 100000;
//		for (int i = 0; i < 100000; i++) {
//			prices[i] = f--;
//		}

		int[] prices = new int[] { 1, 2, 3, 2, 3, 1 };
		for (int n : solution(prices)) {
			System.out.print(n + " ");
		}
	}
}