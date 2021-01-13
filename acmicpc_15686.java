
import java.util.Scanner;

//https://www.acmicpc.net/problem/15686

public class acmicpc_15686 {

	private static int result;
	private static int N;
	private static int M;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // <= 50
		M = sc.nextInt(); // <= 13

		int[][] map = new int[N + 1][N + 1];
		PointArr a = new PointArr();
		PointArr b = new PointArr(13); // max b value
		result = (50 + 50) * 13; // max result

		sc.nextLine();
		for (int i = 1; i <= N; i++) {
			String[] dum = sc.nextLine().split(" ");

			for (int j = 0; j < dum.length; j++) {
				map[i][j + 1] = Integer.parseInt(dum[j]);

				// valueable
				if (map[i][j + 1] > 0) {
					if (map[i][j + 1] < 2)
						a.push(new int[] { i, j + 1 });
					else
						b.push(new int[] { i, j + 1 });
				}
			}
		}

		// b에서 M개 선택
		cal(0, new PointArr(M), a, b);

		System.out.println(result);

	}

	private static void cal(int count, PointArr selectB, final PointArr a, final PointArr b) {
		if (selectB.getCount() >= M) {
			end(a, selectB);
			return;
		}

		if (count >= b.getCount())
			return;

		selectB.push(b.get(count));
		cal(count + 1, selectB, a, b);

		selectB.pop();
		cal(count + 1, selectB, a, b);

	}

	private static void end(PointArr a, PointArr selectB) {
		final int I = 0;
		final int J = 1;

		// TODO Auto-generated method stub
		int[] results = new int[a.getCount()];
		for (int i = 0; i < a.getCount(); i++) {
			int[] h = a.get(i);
			results[i] = (50 + 50); // max value

			for (int j = 0; j < selectB.getCount(); j++) {
				int[] t = selectB.get(j);
				results[i] = Math.min(results[i], (int) (Math.abs(h[I] - t[I]) + Math.abs(h[J] - t[J])));
			}
		}

		int now = 0;
		for (int i : results) {
			now += i;
		}
		result = Math.min(result, now);
	}

}

class PointArr {
	private int[][] arr;
	private int count;

	public PointArr(int size) {
		// TODO Auto-generated constructor stub
		this();
		if (size > 2)
			arr = new int[size][2];
	}

	public PointArr() {
		arr = new int[2][2];
	}

	public int[] get(int idx) {
		return arr[idx];
	}

	public int[] pop() {
		return arr[count-- - 1];
	}

	public void push(int[] p) {
		if (count < 0)
			count = 0;
		else if (count >= arr.length)
			resize();

		// if (arr[count] == null)
		arr[count++] = p;

	}

	public final int getCount() {
		return count;
	}

	private void resize() {
		int[][] dum = new int[arr.length * 2][2];
		System.arraycopy(arr, 0, dum, 0, arr.length);
		arr = dum;
	}

}