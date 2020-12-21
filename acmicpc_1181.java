import java.util.*;

public class acmicpc_1181 {

	public static void main(String[] args) {

		// 1. length input
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		sc.nextLine();
		List<String> arr = new ArrayList<String>();

		for (int i = 0; i < length; i++) {
			String s = "";
			s = sc.nextLine();

			// 중복조건 검색
			if (!arr.contains(s)) {
				arr.add(s);
			}

		}

		myCol c = new myCol();

		// Collections.sort(arr, c);

		arr.sort(c);

		// 길이가 짧은 것부터
		// 길이가 같으면 사전 순으로

		// Result
		for (String string : arr) {
			System.out.println(string);

		}
	}

	public static class myCol implements Comparator<String> {
		public myCol() {

		}

		public int compare(String o1, String o2) {
			// -1, 0 , 1
			int result = 0;
			if (o1.length() > o2.length()) {
				result = 1;
			} else if (o1.length() < o2.length()) {
				result = -1;
			} else
				result = o1.compareTo(o2) > 0 ? 1 : -1;

			return result;

		}

	}

}
