package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class programmers_49191 {

	static int answer = 0;

	static int[][] map = null;
	static boolean[] ranker = null;

	public int solution(int n, int[][] results) {

		map = new int[n + 1][n + 1];
		ranker = new boolean[n + 1];

		int arr[] = new int[n + 1];

		List<Integer> list = new LinkedList<Integer>();
		// init
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		// abs win + loose == n -1이면 정확한 순위 확인 가능
		for (int i = 0; i < results.length; i++) {
			int[] r = results[i];

			map[r[0]][r[1]] = 1;
			map[r[1]][r[0]] = -1;

			arr[r[0]]++;
			arr[r[1]]++;
		}

		calRank(arr.clone(), list);

		return answer;
	}

	private void calRank(int[] result, List<Integer> list) {
		if(list.size() < 1)
			return;
		if (list.size() == 1) {
			// 1명인 경우 결과 정해짐
			answer++;
			ranker[list.get(0)] = true;
			return;
		}

		int need = list.size() - 1;

		for (int now : list) {
			int min = result[now];

			if (min >= need) { // now ranker
				answer++;
				ranker[now] = true;
				
				List<Integer> wList = new ArrayList<Integer>();
				List<Integer> lList = new ArrayList<Integer>();
				int[] nextR = result.clone();
				nextR[now] = 0;

				// next init
				for (int j : list) {
					if(ranker[j])
						continue; // 이미 등록된 값
					
					if (map[now][j] > 0) {
						lList.add(j);
						nextR[j]--;

					} else if (map[now][j] < 0) { // i 가 j 에게 졌음
						wList.add(j);
						nextR[j]--;
					}
				}

				calRank(nextR, wList);
				calRank(nextR, lList);
				break;
			}
		}
	}
}
