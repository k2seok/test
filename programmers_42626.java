import java.util.PriorityQueue;

public class programmers_42626 {
//Solution

	/**
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 
	 * set -> priorityQueue 를 활용해서 해결
	 * offer : 순서에 맞게 입력해준다. offer : error 시 false 리턴 (예외처리됨)
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

//		int[] data = { 1, 2, 3, 9, 10, 12 };
//		System.out.println(solution(data, 7));

//		 int[] data = {11, 0, 7, 1, 2,2,2, 3, 9, 10, 12}; // k : 11 .. answer is  5
//		 int[] data = {8,10, 11}; // K : 7 .. answer is 0
		 int[] data = {1,1, 100}; // K : 7 .. answer is 0
	      System.out.println(solution(data, 100));

		// maximum
		// 1,000,000
//		data = new int[1000000];
//		for (int i = 0; i < 1000000; i++) {
//			data[i] = i + 1;
//		}
//		// 1,000,000,000
//		System.out.println(solution(data, 1000000000));

	}


	public static int solution(int[] scoville, int k) {
		int answer = 0;

		PriorityQueue<Integer> set = new PriorityQueue<>();

		for (Integer i : scoville) {
			set.offer(i); // insert priority Idx
		}

		while (set.peek() < k) { // 가장 작은 값이 k 보다 큰지 확인
			if (set.size() < 2) {
				answer = -1;
				break;
			}

			int a = set.poll();
			int b = set.poll();

			set.offer(a + b * 2);
			answer++;
		}

		return answer;

	}
	
}