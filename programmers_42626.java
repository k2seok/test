import java.util.TreeSet;

public class programmers_42626 {
//Solution

	/**
	 * https://programmers.co.kr/learn/courses/30/lessons/42626 goal : scoville 정렬 후
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

//		int[] data = { 1, 2, 3, 9, 10, 12 };
//		System.out.println(solution(data, 7));

		 int[] data = {11, 0, 7, 1, 2,2,2, 3, 9, 10, 12}; // 5
	      System.out.println(solution(data, 11));

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

		TreeSet<Integer> set = new TreeSet<Integer>();

		for (Integer i : scoville) {
			set.add(i);
		}

		while (set.lower(k) != null && set.size() >= 2) {
			Integer a = set.pollFirst();
			Integer b = set.pollFirst();

			if (a != null && b != null) {
				set.add(a + b * 2);
				answer++;
			}
		}

		if (set.higher(k) == null || set.higher(k) < k)
			answer = -1;

		return answer;

	}
}