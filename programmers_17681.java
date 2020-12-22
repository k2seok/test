
///https://programmers.co.kr/learn/courses/30/lessons/17681
public class programmers_17681 {

	class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];

//		arr1 arr2 | 연산
			for (int i = 0; i < n; i++) {

				int v = arr1[i] | arr2[i];
//			System.out.println(v);

				String r = Integer.toBinaryString(v);
				while (r.length() < n) {
					r = '0' + r;
				}
//			System.out.println();

				r = r.replace('1', '#');
//			System.out.println(r);

				r = r.replace('0', ' ');
//			System.out.println(r);
				answer[i] = r;
			}
			return answer;
		}
	}
}