import java.util.Scanner;

public class acmicpc_14888 {
	// https://www.acmicpc.net/problem/14888

	static int N = 0;
	static int[] arr;
	static String s = "";
	// static List<Integer> s = new ArrayList<Integer>();
	static final int limit = (int) (Math.pow(10.0, 9.0)); // 10ek
	static int[] result = new int[] { +limit, -limit };

	static final int MIN = 0;
	static final int MAX = 1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		// sa = new int[4];
		// s = new String[N - 1];
		// Input
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		// + - * /
		// for (int i = 0; i < sa.length; i++) {
		// sa[i] = sc.nextInt();
		// }
		int idx = 0;
		sc.nextLine();
		String[] temp = sc.nextLine().split(" ");
		for (int i = 0; i < temp.length; i++) {
			int v = Integer.parseInt(temp[i]);
			while (v-- > 0) {
				s += i;
			}
		}

		cal(arr[1], 1, s);

		System.out.println(result[MAX]);
		System.out.println(result[MIN]);

	}

	private static void cal(int value, int idx, String arg) {
		if (N - idx <= 2) {
			int a = idx + 1;
			int b = idx + 2;
			if (N - idx == 2) {
				end(calSa(calSa(value, arr[a], arg.charAt(0)), arr[b], arg.charAt(1)));
				end(calSa(calSa(value, arr[a], arg.charAt(1)), arr[b], arg.charAt(0)));
			} else
				end(calSa(value, arr[a], arg.charAt(0)));
			return;
		}

		// Input

		// Cal

		for (int i = 0; i < arg.length(); i++) {
			int nowA = calSa(value, arr[idx + 1], arg.charAt(i));

			String now = "";
			for (int i2 = 0; i2 < arg.length(); i2++) {
				if (i2 != i)
					now += arg.charAt(i2);

			}
			cal(nowA, idx + 1, now);
		}

	}

	private static void end(int value) {
		result[MAX] = Math.max(result[MAX], value);
		result[MIN] = Math.min(result[MIN], value);
	}

	private static int calSa(int a, int b, char i) {
		int result = 0;

		switch (i) {
		case '0': // +
			result = a + b;
			break;
		case '1': // -
			result = a - b;
			break;
		case '2': // *
			result = a * b;
			break;
		case '3': // /
			result = a / b;
			break;
		}

		return result;
	}
}