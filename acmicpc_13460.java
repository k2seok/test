import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;




public class acmicpc_13460 {

	private static int N;
	private static int M;
	private static String[][] map;
	private static int[] endBall;
	private static final int RED = 0;
	private static final int BLUE = 1;
	// private static final int COUNT = 2;
	private static final int I = 0;
	private static final int J = 1;

////https://www.acmicpc.net/problem/13460
	public static void main(String dummy[]) {

		Queue<int[][]> queue = new ArrayDeque<int[][]>();
		Queue<Integer> qc = new ArrayDeque<Integer>();
		queue.add(init());
		int result = -1;

		// for (int count = 1; count < 10; count++) {
		qc.add(0);

		// int[][] start = queue.peek();
		boolean end = false;
		int count = 0;
		while (!end) {
			int[][] ball = queue.poll();
			if (!qc.isEmpty())
				count = qc.poll();
			if (ball == null)
				break;
			if (count >= 10)
				continue;

			count++;

			for (int way = 1; way <= 4; way++) {
				endBall = new int[] { 0, 0 };

				int nextBall[][] = move(ball, way);

				// 공이 둘중에 하나가 들어감
				if (endBall[BLUE] + endBall[RED] > 0) {
					// 파란공이 들어감
					if (endBall[BLUE] > 0)
						continue;

					// 게임 종료.
					{
						result = count;
						end = true;
						break;
					}
				}

				//// bad move 체크 필요
				{
					if (ball[RED][I] == nextBall[RED][I] && ball[RED][J] == nextBall[RED][J]
							&& ball[BLUE][I] == nextBall[BLUE][I] && ball[BLUE][J] == nextBall[BLUE][J])
						continue;
				}

				queue.add(nextBall);
				qc.add(count);

			}

			// cal(ball, -1);

			// roll(ball, )
		}
		System.out.println(result);
	}
	//
	// private static void cal(int[][] ball, int existWay) {
	//
	//
	// }

	private static int[][] move(int[][] ball, int way) {
		int[][] nextBall = ball.clone();

		int color = RED;

		//// 이동시, 더 앞에 있는 공부터 움직인다
		switch (way) {
		case 1: // up - i
			if (nextBall[RED][I] > nextBall[BLUE][I])
				color = BLUE;
			break;

		case 2: // right + j
			if (nextBall[RED][J] < nextBall[BLUE][J])
				color = BLUE;

			break;
		case 3: // down + i
			if (nextBall[RED][I] < nextBall[BLUE][I])
				color = BLUE;
			break;
		case 4: // left - j
			if (nextBall[RED][J] > nextBall[BLUE][J])
				color = BLUE;
			break;
		}

		/// 앞의 공부터 이동한다.

		for (int count = 0; count < 2; count++) {
			int now[] = nextBall[color];
			// String path[] = new int[];
			int next[] = now.clone();
			for (int i = 1; i < (way % 2 > 0 ? N : M); i++) {
				if (!cal(next, way, color))
					break;

				/// 충돌체크 : 2번째 공이 움직일때, 부딪히는지 확인
				if (count > 0) {
					int[] prevBall = color == BLUE ? nextBall[RED] : nextBall[BLUE];
					if (!"O".equals(map[prevBall[I]][prevBall[J]])
							&& (prevBall[I] == next[I] && prevBall[J] == next[J])) {
						/// 원복
						if (way + 2 > 4)
							way -= 2;
						else
							way += 2;

						cal(next, way, color);
						break;
					}
				}

			}
			nextBall[color] = next;
			// 교환
			color = color == BLUE ? RED : BLUE;
		}
		return nextBall;
	}

	private static boolean cal(int[] next, int way, int color) {
		switch (way) {
		case 1: // up
			if (!isWall(next[I] - 1, next[J])) {
				next[I]--;
				if (isGoal(next[I], next[J], color))
					return false;
			} else
				return false;
			break;
		case 2: // right
			if (!isWall(next[I], next[J] + 1)) {
				next[J]++;
				if (isGoal(next[I], next[J], color))
					return false;
			} else
				return false;
			break;
		case 3: // down
			if (!isWall(next[I] + 1, next[J])) {
				next[I]++;
				if (isGoal(next[I], next[J], color))
					return false;
			} else
				return false;
			break;
		case 4: // left
			if (!isWall(next[I], next[J] - 1)) {
				next[J]--;
				if (isGoal(next[I], next[J], color))
					return false;
			} else
				return false;
			break;
		}

		return true;
	}

	private static boolean isGoal(int i, int j, int color) {
		if ("O".equals(map[i][j])) {
			endBall[color]++;
			return true;
		}
		return false;
	}

	private static boolean isWall(int i, int j) {
		// 끝
		if (i < 0 || j < 0 || i >= N || j >= M)
			return true;

		if ("#".equals(map[i][j]))
			return true;

		return false;
	}

	private static int[][] init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new String[N][M];
		int[][] start = new int[2][2];

		sc.nextLine(); // erase
		for (int i = 0; i < N; i++) {
			String s[] = sc.nextLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j];
				if ("B".equals(s[j]))
					start[BLUE] = new int[] { i, j };
				else if ("R".equals(s[j]))
					start[RED] = new int[] { i, j };
			}
		}

		return start;
	}
}
