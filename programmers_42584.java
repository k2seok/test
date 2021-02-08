public class programmers_42584 {
//Solution

	/*
	 * 1) time가 len까지 ++ 되도록 구현 2) 해당 idx 값을 time까지 확인 후 ++ 처리 3) boolean end 에서 죽은
	 * 값 true 처리 2)n 값이 len까지 ++
	 * 
	 * 
	 */
	// 10^5 효율성 떨어짐 
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		boolean[] end = new boolean[prices.length];

		// con : length > 1 이상
		for (int time = 1; time < prices.length; time++) {
			for (int idx = 0; idx < time; idx++) {
				if (!end[idx]) {
					answer[idx]++;

					if (prices[idx] > prices[time]) // 이전값이 더 높음
						end[idx] = true;
				}
			}
		}

		return answer;

	}

	public static void main(String[] args) {

		int f = 100000;
		//int[] prices = new int[] { 1, 2, 3, 2, 3 };
		int[] prices = new int[f];
		// 100,000
		for (int i = 0; i < 100000; i++) {
			prices[i] = f--;
		}
		for (int n : solution(prices)) {
			System.out.print(n + " ");
		}
	}
}