
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

// https://www.acmicpc.net/problem/3190
public class acmicpc_3190 {

	private static int N;
	private static int[][] map;
	private static Vector<int[]> apple;
	private static Queue<int[]> change;
	private static Vector<int[]> body;

	private static final int I = 0;
	private static final int J = 1;

	private static final int TIME = 0;
	private static final int WAY = 1;

	public static void main(String[] args) {

		init();

		int time = 0;
		// int head = 0;
		int tail = 0;
		int way = 1; // 0 1 2 3
		while (time++ < 10000000) {
			move(way);
			way = wayChange(time, way);

			if (end(tail, body.get(body.size() - 1))) {
				System.out.println(time);
				return;
			}

			if (!eat(body.get(body.size() - 1)))
				tail++;
		}

	}

	private static void move(int way) {
		int[] next = body.get(body.size() - 1).clone();
		switch (way) {
		case 0:
			next[I]--;
			break;
		case 1:
			next[J]++;
			break;
		case 2:
			next[I]++;
			break;
		case 3:
			next[J]--;
			break;
		}
		body.add(new int[] { next[I], next[J] });
	}

	private static int wayChange(int time, int way) {
		if (!change.isEmpty()) {
			int now[] = change.peek();
			if (time == now[TIME]) {
				change.poll();
				return headChange(way + now[WAY]);
			}
		}
		return way;
	}

	private static int headChange(int way) {
		switch (way) {
		case 4:
			way = 0;
		case 0:

			break;
		case 1:
			break;
		case 2:
			break;

		case -1:
			way = 3;
		case 3:
			break;
		}

		return way;
	}

	private static boolean eat(int[] head) {
		for (int i = 0; i < apple.size(); i++) {
			int[] now = apple.get(i);

			if (now != null && now[I] == head[I] && now[J] == head[J]) {
				apple.set(i, null);
				return true;
			}
		}
		return false;
	}

	private static boolean end(int tail, int[] head) {
		if (head[I] == 0 || head[J] == 0 || head[I] > N || head[J] > N)
			return true; // 밖으로 나감
		else if (body.size() - tail > 3) { // 충돌
			for (int i = tail; i < body.size() - 2; i++) {
				if (head[I] == body.get(i)[I] && head[J] == body.get(i)[J])
					return true;
			}
		}
		return false;
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int K = sc.nextInt();

		apple = new Vector<int[]>();
		for (int i = 0; i < K; i++) {
			apple.add(new int[] { sc.nextInt(), sc.nextInt() });
		}

		int J = sc.nextInt();
		change = new ArrayDeque<int[]>();

		sc.nextLine();
		for (int i = 0; i < J; i++) {
			int[] now = new int[2];
			String[] s = sc.nextLine().split(" ");
			now[TIME] = Integer.parseInt(s[TIME]);
			now[WAY] = ("D".equals(s[WAY]) ? 1 : -1);
			change.add(now);

		}

		body = new Vector<int[]>();
		body.add(new int[] { 1, 1 });
	}

}