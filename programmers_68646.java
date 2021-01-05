import java.util.HashSet;
import java.util.Set;

public class programmers_68646 {

	/**
	 * https://programmers.co.kr/learn/courses/30/lessons/68646?language=java 풍선터트리기
	 * x 개 풍선 중 1 개 될때까지 -1 부터 터뜨리기 +1 터뜨리기 큰 수 제거 큰수 아니면 visit true 로 변경 후 제거 1 < x
	 * < 1,000,000
	 * 
	 * 제거 : idx 끝까지 이동으로 처리
	 * 
	 * 
	 *  
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 9, -1, -5 };
		// a = new int[] { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };//

		System.out.println(solution(a) + "");

	}

	static int[] arr;
	static Set<Integer> result;

	public static int solution(int[] a) {
		result = new HashSet<Integer>();
		arr = a;
		for (int i = 0; i < a.length; i++) {
			cal(new boolean[a.length], false, i, arr[i], 0);
		}

		return result.size();
	}

	private static void cal(boolean[] visit, boolean use, int nowI, final int v, int r) {
		visit[nowI] = true;
		if (end(r))
			return;

		if (nowI - 1 > -1) { // 1)'
			if (!visit[nowI - 1]) {
				// 재방문, 1번 이후 의미없음. break;

				// move
				if (arr[nowI - 1] > v) // check
					cal(visit, use, nowI - 1, v, r + 1);
				else if (!use && arr[nowI - 1] < v) // check){
				{
					use = true;
					cal(visit, use, nowI - 1, v, r + 1);
				}
			}

		}

		if (nowI + 1 < arr.length) { // end
			if (visit[nowI + 1]) // 재방문, continue
				cal(visit, use, nowI + 1, v, r);
			else {

				// move
				if (arr[nowI + 1] > v) // check
					cal(visit, use, nowI + 1, v, r + 1);
				else if (!use && arr[nowI + 1] < v) // check){
				{
					use = true;
					cal(visit, use, nowI + 1, v, r + 1);
				}
			}
		}
	}

	private static boolean end(int end) {
		if (arr.length - 1 == end) {
			if (!result.contains(arr[0])) {
				result.add(arr[0]);
			}
			return true;
		}
		return false;

	}
}
