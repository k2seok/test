import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class swExpert_1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Solution();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static int answer;
	static int[] arr;
	static int I;

	// swexpertacademy 1206. [S/W 문제해결 기본] 1일차 - View
	/*
	 * max : 5000 * 255 < 10^6 최대시간 : O(1)
	 * 
	 * BFS : j층에서  check : i-1 i-2 i+1 i+ 2 < j 층 확인
	 * 
	 */
	public static void Solution() throws FileNotFoundException {
		//Scanner sc = new Scanner(new File("./tcFile/swExpert_1206.txt"));
		Scanner sc = new Scanner(System.in);

		// T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		// init
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			I = sc.nextInt();
			int MAX = 0;
			arr = new int[I];
			for (int i = 0; i < I; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > MAX)
					MAX = arr[i];
			}
			answer = 0;

			for (int nowV = 1; nowV <= MAX; nowV++) { // now층
				for (int idx = 2; idx < I - 2; idx++) { // n열
					if (nowV <=  arr[idx])	//n열의 해당 층 조망권 확인
						check(nowV, idx);
				}
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}

	private static void check(int now, int idx) {
		// TODO Auto-generated method stub
		int l1 = idx - 1;
		int l2 = idx - 2;

		int r1 = idx + 1;
		int r2 = idx + 2;

		if (l1 >= 0 && arr[l1] < now) {
			if (l2 >= 0 && arr[l2] < now) {
				if (r1 < arr.length && arr[r1] < now) {
					if (r2 < arr.length && arr[r2] < now) {
						answer++;
					}
				}
			}
		}

	}

}
