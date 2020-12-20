/**
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43162 //점화식 BFS 0 번부터 < i
 * 까지 검색 (0은 검색하지 않음)
 * 
 * 간선 N개 검색,
 */
public class programmers_43162 {

	static boolean[] visit = null;
	static private int answer;
	static int[][] map = null;
	static int N = -1;

	public static int solution(int n, final int[][] com) {

		answer = 0;
		visit = new boolean[n];
		map = com;
		N = n;

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			answer++;
			visit[i] = true;
			for (int j = 0; j < N; j++) {
				if(visit[j])
					continue;
				if (map[i][j] == 1) // find
				{
					visit[j] = true;
					findNode(j);
				}

			}
		}
		return answer;
	}

	private static void findNode(int idx) {

		for (int j = 0; j < N; j++) {
			if (j == idx || visit[j])
				continue;

			if (map[idx][j] == 1) {
				visit[j] = true;
				findNode(j);
			}

		}
	}

	public static void main(String args[]) {
		// 3 [[1, 1, 0], [1, 1, 0], [0, 0, 1]] 2

		int n = 3;
		int[][] com = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }; // answer : 1
		System.out.println(solution(n, com));

	}
}
