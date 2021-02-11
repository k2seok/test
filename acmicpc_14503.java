import java.util.Scanner;

///https://www.acmicpc.net/problem/14503
public class acmicpc_14503 {
	// public class Main {

	private static int N = 0;
	private static int M = 0;
	private static int[][] map;
	private static boolean[][] visit;
	private static int result;

	private final static int I = 0;
	private final static int J = 1;
	private final static int WAY = 2;

	public static void main(String[] args) {

		int robot[] = init();

		cal(robot[I], robot[J], robot[WAY]);

		System.out.println(result);
	}

	private static void cal(int nowI, int nowJ, int way) {

		// 1.
		if (!isWall(nowI, nowJ) && !visit[nowI][nowJ]) {
			result++;
			// test
			// System.out.print(nowI + ", " + nowJ);
			visit[nowI][nowJ] = true;
		}

		// 2.
		int nextWay[] = check(nowI, nowJ, way);

		if (nextWay == null)
			// dead code
			System.out.println("error!");
		else {

			// 4.
			if (isWall(nextWay[I], nextWay[J]))
				return;

			cal(nextWay[I], nextWay[J], nextWay[WAY]);
		}

	}

	private static int[] check(int nowI, int nowJ, int way) {
		// 3.

		int left[] = { nowI, nowJ - 1, 3 };
		int down[] = { nowI + 1, nowJ, 2 };
		int right[] = { nowI, nowJ + 1, 1 };
		int up[] = { nowI - 1, nowJ, 0 };

		int nextArr[][] = new int[4][];

		switch (way) {
		case 0:
			nextArr[0] = left;
			nextArr[1] = down;
			nextArr[2] = right;
			nextArr[3] = up;
			break;
		case 1:
			nextArr[0] = up;
			nextArr[1] = left;
			nextArr[2] = down;
			nextArr[3] = right;
			break;
		case 2:
			nextArr[0] = right;
			nextArr[1] = up;
			nextArr[2] = left;
			nextArr[3] = down;
			break;
		case 3:
			nextArr[0] = down;
			nextArr[1] = right;
			nextArr[2] = up;
			nextArr[3] = left;
			break;
		}

		for (int nextWay = 0; nextWay < 4; nextWay++) {
			int next[] = { nextArr[nextWay][I], nextArr[nextWay][J], nextArr[nextWay][WAY] };
			if (!isWall(next[I], next[J]) && !visit[next[I]][next[J]])
				return next;
		}

		return new int[] { nextArr[1][I], nextArr[1][J], way };
	}

	private static boolean isWall(int nowI, int nowJ) {
		if (nowI < 0 || nowJ < 0 || nowI >= N || nowJ >= M || map[nowI][nowJ] > 0)
			return true;

		return false;
	}

	private static int[] init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visit = new boolean[N][M];
		result = 0;

		int[] robot = new int[3];
		for (int i = 0; i < 3; i++) {
			robot[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		return robot;

	}
}