package programmers;

import java.util.LinkedList;
import java.util.List;

public class programmers_49191 {

	// 4 , 3 = 1 //win
	// 3, 4 = -1 // loose


	static int answer = 0;
	static final int W = 1;
	static final int L = 2;

	static int[][] map = null;
	static boolean[] visit = null;

	public int solution(int n, int[][] results) {

		map = new int[n + 1][n + 1];
		visit = new boolean[n+1];

		List<Integer> list = new LinkedList<Integer>();
		// abs win + loose == n -1이면 정확한 순위 확인 가능
		for (int i = 0; i < results.length; i++) {
			int[] r = results[i];

			map[r[0]][r[1]] = 1;
			map[r[1]][r[0]] = -1;


			if (!list.contains(r[0]))
				list.add(r[0]);

			if (!list.contains(r[1]))
				list.add(r[1]);
		}

		calRank(n, list, 0);

		return answer;
	}

	// pNode is not use
	private void calRank(int n, List<Integer> list, int pNode) {
		// n -1 == 0 이면, 승수 확인 가능
		if (list.size() == 1) {
			if(visit[list.get(0)])
				return;
			visit[list.get(0)] = true;
			answer++;
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			int node = list.get(i);
			if(visit[node])
				continue;
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (i == j)
					continue;

				if (map[node][list.get(j)] != 0)
					count++;
			}

			// 간선개수 확인 결과
			if (count == n - 1) {
				
				visit[node] = true;
				answer++;
				// next

				// Next Node
				List<Integer> setUp = new LinkedList<Integer>();
				List<Integer> setDown = new LinkedList<Integer>();

				for (int j = 1; j < map.length; j++) {
					if (map[node][j] == 1) // down
						setDown.add(j);
					else if (map[node][j] == -1) // up
						setUp.add(j);
				}

				calRank(setUp.size(), setUp, node);
				calRank(setDown.size(), setDown, node);

			}
		}
	}
}
