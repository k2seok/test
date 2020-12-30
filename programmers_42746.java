/**
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/42746 
 * // BFS round  번자리에 들어갈 적합한 수찾기
	미리 모든 값 정렬 후 정렬된 큰수값부터 꺼내기
 * 까지 검색 (0은 검색하지 않음)
 * 
 */
public class programmers_42746 {

	
	public static String MAX = ""; 
	public static int[] arr;
	public static String solution(int[] numbers) {
//		String answer = "";
		
		arr = numbers.clone();
		
		for (int i = 0; i < numbers.length; i++) {
			input(0, i, "");
		} 
		
		
		
		
		
		return MAX;
	}

	private static void input(int count, int idx, String nowV) {
		if(count >= arr.length) {
			MAX = nowV.compareTo(MAX) < 1 ? MAX : nowV;
			return;
		}
		
//		if(nowV.split("")[count].compareTo(MAX.split("")[count]) > 0) {
//			MAX = nowV;
//		}
//		
		if(idx >= arr.length)
			return;
		
		nowV += arr[idx]+"";
		
		
		for (int i = idx+1; i < arr.length; i++) {
			input(count+1, i, nowV);
		} 
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		// 3 [[1, 1, 0], [1, 1, 0], [0, 0, 1]] 2

		int[] com = {6, 10, 2};
		System.out.println(solution( com));

	}
}
