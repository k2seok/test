public class programmers_62048 {
//Solution 
	// https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
	public static void main(String[] args) {

		int w = 3;
		int h = 12;
		System.out.println(solution(8, 12));
		System.out.println(solution(8, 3));
		System.out.println(solution(3, 12));
	}

	public static long solution(int w2, int h2) {
		// cal : w*h -  (가로 길이+세로 길이-최대 공약수)
		long w = w2; // max 1^8
		long h = h2; // max 1^8

		// cal 유클리드 호제 Euclidean algorithm
		// a > b 일때, (a%b) 는 r 이다. r > b 일때 r % b 0이면  b 는  최대공약수 이다 , (a*b 값으로 시작하면 최소공배수) 
		long[] srt = w < h ? new long[] { w, h } : new long[] { h, w };
		while (srt[1] % srt[0] != 0) {
			long prev = srt[0];
			long now = srt[1] % srt[0];
			srt = prev < now ? new long[] { prev, now } : new long[] { now, prev};

		}
		// srt[0] is 최대공약수;

		return w*h - (w + h - srt[0]);
	}
}
