import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class programmers_42861 {
//Solution
	public static void main(String[] args) {
		int[][] costs;
		int n = 0;

		n = 4;
		costs = new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }; // 4
		System.out.println(solution(n, costs));
//		
//		// 섬의 2그룹 
		n = 4;
		costs = new int[][] { { 0, 1, 5 }, { 0, 2, 5 }, { 1, 2, 5 }, { 1, 3, 5 }, { 2, 3, 5 } }; // 4
		System.out.println(solution(n, costs));

		// 섬의 2그룹 2
		n = 5;
		costs = new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 3 }, { 2, 3, 8 }, { 3, 4, 1 } }; // ;7
		System.out.println(solution(n, costs));

	}

	/**
	 * 모든, 연결에서 최소의 연결값을 지정 > 최소신장트리 (Minimum Spanning Tree) 
	 * 프림알고리즘 : 
	 * 1)임의의 vertex 에서 시작, 
	 * 2)트리 내부의 두 vertex 가 선택되지않은 간선을 선택한다. (visit check) 
	 * 2-1)간선은 최소가중치 부터 잇는다. (가중치 오름차순 정렬필요) 
	 * 3)모든 vertex 가 연결된 경우 종료
	 * 
	 * @param n
	 * @param costs
	 * @return
	 */
	public static int solution(int n, int[][] costs) {
		int answer = 0;

		boolean[] linked = new boolean[costs.length];
		boolean[] visit = new boolean[n];

		Comparator<int[]> compare = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		};

		Arrays.sort(costs, compare);
//		System.out.println(Arrays.toString(costs[0]));

		int count = 0;

		// 최초 0번 값으로 트리시작
		linked[0] = true;
		visit[costs[0][0]] = true;
		visit[costs[0][1]] = true;
		count += 2;
		answer += costs[0][2];

		// 1
		for (int i = 0; count < n && i < linked.length; i++) {
			if (linked[i])
				continue;

			int checked = 0;
			int now[] = new int[] { costs[i][0], costs[i][1] };

			if (visit[now[0]])
				checked++;
			if (visit[now[1]])
				checked++;

			if (checked > 1) {
				// cycle : 조회대상에서제외시킴
				linked[i] = true;
				continue;
			} else if (checked == 1) {
				// find : 2그룹이 나오지않도록 최소 1개연결된 값에서 연결(concept 프림알고리즘)
				linked[i] = true;
				visit[costs[i][0]] = true;
				visit[costs[i][1]] = true;
				count += 1;
				answer += costs[i][2];

				i = 0; // 다시 최소가중치부터 조회
			}

		}

		return answer;
	}

}
