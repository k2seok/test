import java.util.Scanner;

public class acmicpc_15684 {
	//Main
	private static int maxPath;
	private static int maxDari;
	private static int dCount;
	private static boolean[][] visit;
	private static int result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		maxDari = sc.nextInt();
		dCount = sc.nextInt();
		maxPath = sc.nextInt();

		visit = new boolean[maxPath + 1][maxDari + 1];

		for (int t = 0; t < dCount; t++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			visit[i][j] = true;
		}

		// cal
		result = -1; // 사다리 3개 놔도 갈 수 없는 값

		for (int count = 0; count <= 3; count++) {
			if (cal(count)) {
				result = count;
				break;
			}
		}

		System.out.println(result);
	}

	private static boolean cal(int count) {
		if (count < 1) {
			if (endGame()) {
				return true;
			}
			return false;
		}

		// 다리 놓기
		for (int i = 1; i <= maxPath; i++) {
			for (int j = 1; j <= maxDari; j++) {
				// 사다리를 둘 수 있음
				if (!visit[i][j]) {

					// 우측에 있는 지 확인
					if (canGo(j + 1) && visit[i][j])
						continue;
					// 좌측에 있는지 확인
					if (canGo(j - 1) && visit[i][j - 1])
						continue;
					visit[i][j] = true;

					if (cal(count - 1))
						return true;
					visit[i][j] = false;
				}
			}
		}

		return false;
	}

	private static boolean endGame() {
		// TODO i == i 인지 확인
		// j 1 ~ maxJ까지 사다리 타던도중 옆의 값이 있고 visit == true면 이동해야함
		for (int start = 1; start <= maxDari; start++) {
			int now = start;
			for (int j = 1; j <= maxPath; j++) {

				// 우로 이동
				if (canGo(now + 1) && visit[j][now])
					now++;
				else if (canGo(now - 1) && visit[j][now - 1]) // 좌로 이동
					now--;
			}
			if (now != start)
				return false;
		}
		return true;
	}

	private static boolean canGo(int idx) {
		if (idx <= maxDari && idx > 0)
			return true;
		return false;
	}
}