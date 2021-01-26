import java.util.*;

public class acmicpc_12980 {
	/// skill Test 2
	public static void main(String args[]) {

//		int[] data = { 1, 2, 3, 9, 10, 12 };
		System.out.println(solution2(10));
	}

//	final int L = 0; // 현재 위
//	final int V = 1; // 점프값

	///https://programmers.co.kr/learn/courses/30/lessons/12980
	public static int solution(int N) {
		int ans = 0;

		// n 까지 한번에 이동
		ans = N;

		int count = 1; // 한번이동
		if (1 == N) // 1 확인
			return 1;

		for (int idx = 1; idx < N; idx *= 2) { // 순간이동
			if (idx == 1)
				continue;
			int now = N - idx; // 남은거리까지 점프
			ans = ans > now ? now : ans;
		}

		return ans;
	}

	////https://programmers.co.kr/learn/courses/30/lessons/68645
	public static int[] solution2(int N) {
		final int I = 0;
		final int J = 1;
		int[] answer = {};

		// init
		int[][] arr = new int[N][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1];
		}

		// input

		int away = 0;
		int[] now = new int[] { -1, 0 }; // 시작값 default
		int nowV = 1;
		for (int cnt = N; cnt > 0; cnt--) {
			away %= 3;
			away++; // 1 2 3
			switch (away) {
			case 1:
				for (int i = 0; i < cnt; i++) {
//					if (now[J] - 1 >= 0)
//						arr[now[I] + 1][now[J] - 1] = nowV++;
//					else
					arr[++now[I]][now[J]] = nowV++;
				}
				break;

			case 2:
				for (int i = 0; i < cnt; i++) {
					arr[now[I]][++now[J]] = nowV++;
				}
				// next
				break;

			case 3:
				for (int i = 0; i < cnt; i++) {
					if (now[I] - 1 >= 0) {
						if (now[J] - 1 >= 0)
							arr[--now[I]][--now[J]] = nowV++;
						else
							arr[--now[I]][now[J]] = nowV++;
					}

				}
				break;

			}

		}

		// answer input
		Vector<Integer> vec = new Vector<Integer>();

		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr[k].length; k2++) {
				vec.add(arr[k][k2]);
			}
		}
		answer = new int[vec.size()];
		for (int k = 0; k < vec.size(); k++) {
			answer[k] = vec.get(k);
		}

		return answer;
	}

}