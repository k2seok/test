public class programmers_70129 {
	//solution
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/70129
	 * 1) s delete 0 2) len(s)
	 * 
	 * sample 0111010 > 2, 5
	 */
	public static int[] solution(String s) {
		int[] answer = new int[2];

		while (!s.equals("1")) {
			int prevLen = s.length();
			s = s.replaceAll("0", "");
			int nowLen = s.length();

			// cast 2진법
			s = Integer.toBinaryString(nowLen);
			answer[0]++;
			answer[1] += prevLen - nowLen; // 1 value
		}
		System.out.println('g');
		return answer;
	}

	public static void main(String[] args) {

		String s = "0111010";
		solution(s);

	}
}