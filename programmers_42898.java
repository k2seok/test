package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class programmers_42898 {

	final int I = 0;
	final int J = 1;
	final static int V = 1000000007;

	public int solution(int m, int n, int[][] puddles) {

//		final int I = n + 1;
//		final int J = m + 1;
		int answer = 0;

		int[][] map = new int[n+1][m+1];
		boolean[][] visit = new boolean[n + 1][m + 1];
		int[] end = new int[] { n, m };

		for (int k = 0; k < puddles.length; k++) {
			visit[puddles[k][J]][puddles[k][I]] = true;
		}

		// {}<int[]>();
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { 1, 1 });

		boolean exit = false;
		while (!exit) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				// end
				if (now[0] == end[0] && now[1] == end[1]) {
					answer++;
					exit = true;
					continue;
				}

				if (!exit) {// next : 한번이라도 도착한 경우, 다음 계산이 의미없음
					if (now[1] + 1 <= m) { // down
						int next[] = new int[] { now[0], now[1] + 1 };
						
						if (map[next[0]][next[1]] < 0)
							continue;
						if (visit[next[0]][next[1]]) // 이미 조회
							continue;
						queue.add(next);
						visit[next[0]][next[1]] = true;
						map[next[0]][next[1]] += map[now[0]][now[1]];
					}

					if (now[0] + 1 <= n) { // right
						int next[] = new int[] { now[0] + 1, now[1] };
						
						if (map[next[0]][next[1]] < 0)
							continue;
						map[next[0]][next[1]] += map[now[0]][now[1]];
					}


				}

			}
		}

		return answer%V;
	}
}
