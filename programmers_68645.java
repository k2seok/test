public class programmers_68645 {

	static class Solution {
		static int v = 0;
		static int N = 0;
		static int[] now = null;
		static int nowLen = 0;
		static int[][] map = null;

		static final int I = 0;
		static final int J = 1;

		public int[] solution(int n) {
			int[] answer = {};

			map = new int[n][];
			for (int i = 0; i < n; i++) {
				map[i] = new int[i + 1];
			}

			N = n;
			v = 1;
			now = new int[] { 0, 0 };
			nowLen = n;

			// 3방향 이동
			int way = 1;
			while (nowLen > 0) {
				way %= 4;
				move(way++);
			}

			// result
			answer = new int[v - 1];
			int idx = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					answer[idx++] = map[i][j];
				}
			}
			return answer;
		}

		private boolean move(int way) {
			// end check
			if (nowLen < 1)
				return false;

			switch (way) {
			case 1: // down
				if (map[now[I]][now[J]] > 0)
					now[I]++;
				for (int i = 0; i < nowLen; i++) { // input
					map[now[I]++][now[J]] = v++;
				}

				now[I]--; // 마지막 처리 롤백

				break;
			case 2: // right
				if (map[now[I]][now[J]] > 0)
					now[J]++;
				for (int i = 0; i < nowLen; i++) { // input
					map[now[I]][now[J]++] = v++;
				}

				now[J]--; // 마지막 처리 롤백

				break;

			case 3: // left Up

				if (map[now[I]][now[J]] > 0) {
					now[I]--;
					now[J]--; // 인덱스 내렸을 경우 대각선으로 이동
				}

				for (int i = 0; i < nowLen; i++) { // input
					map[now[I]--][now[J]--] = v++;
				}

				// 마지막 처리 롤백
				now[I]++;
				now[J]++;

				break;
			default: // 0 : return
				return false;
			}

			nowLen--;	//이동 후 다음 개수 -1
			return true;
		}
	}

	public static void main(String[] args) {
		int n = 1000;
		//
		/*
		 * 숫자 n (4 ~ 1000)을입력했을때, 밑변의 길이와 높이가 n인 삼각형에서 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 숫자를
		 * 합친 배열을 리턴하는 문제 input Example : 4 result : 1 2 9 3 10 8 4 5 6 7
		 * simulation
		 * 풀이 리뷰 : 시뮬레이션 구현에 시간을많이 소요. 값 변경, 롤백처리 설계를 좀더 명확히 할 필요가 있음, 
		 * 목표는 30분 내로 단축!
		 * 
		 */
		////https://programmers.co.kr/learn/courses/30/lessons/68645
		System.out.println(new Solution().solution(n) +"");
	}
}
