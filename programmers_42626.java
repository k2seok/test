import java.util.Arrays;

public class programmers_42626 {
//Solution

	/**
	 * https://programmers.co.kr/learn/courses/30/lessons/42626 goal : scoville 정렬 후
	 * 작은 수 부터 스코빌 계산 진행, k 넘은 경우 end
	 * idx 건너띄기 처리할 필요 있음
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

//		int[] data = { 1, 2, 3, 9, 10, 12 };
//		System.out.println(solution(data, 7));

		int[] data = { 11, 0, 7, 1, 2, 3, 9, 10, 12 };
		System.out.println(solution(data, 55));

		// maximum
		// 1,000,000
//		data = new int[1000000];
//		for (int i = 0; i < 1000000; i++) {
//			data[i] = i + 1;
//		}
//		// 1,000,000,000
//		System.out.println(solution(data, 1000000000));

	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		int maxStartIdx = -1;
		Arrays.sort(scoville); // init sort

		for (int i = 0; i < scoville.length; i++) {// 계산안해도 되는 범위
			if (scoville[i] >= K) {
				maxStartIdx = i;
				break;
			}
		}

		if (maxStartIdx < 0)
			maxStartIdx = scoville.length;

		int[] under = Arrays.copyOfRange(scoville, 0, maxStartIdx); // 작은
		int[] upper = Arrays.copyOfRange(scoville, maxStartIdx, scoville.length); // 큰 값

		// cal : i i+1 인덱스 스코빌 계산
		for (int idx = 0; idx < under.length; idx++) {

			// sort > idx switching
			if (idx + 1 < under.length) {
				int data1 = under[idx];
				int data2 = under[idx + 1];
				int data3 = -1;

				if (data1 < K) {
					// compare : 섞은값이 최소값인지 확인
					if (data1 > data2) {
						if (idx + 2 < under.length)
							data3 = under[idx + 2];

						if (data3 > -1 && data1 > data3) { // switch : 1 to 3

							under[idx] = data2;
							under[idx + 1] = data3;
							under[idx + 2] = data1;

							if (under[idx] > under[idx + 1]) {
								// compare : data2 < data3
								int temp = under[idx];
								under[idx] = under[idx + 1];
								under[idx + 1] = temp;
							}
						} else { // switch :1 to 2
							under[idx] = data2;
							under[idx + 1] = data1;
						}
					}
				} else {
					// 섞은값이 K보다 큼
					if (upper.length < 1) // 1 개도 없으면 추가
						upper = new int[] { K };

					under[idx++] = -1; // 무시하고 다음 idx부터 조회
				}

			}

			if (under[idx] >= K) {
				break; // 1st end condition
			}

			if (idx + 1 >= under.length) { // 2nd end Condition

				// upper 값 있으면 한번더 섞음
				if (upper.length > 0)
					answer++;
				else
					answer = -1; // under + upper 를 더해도, 결과 만들 수 없음 : 모든경우의 수 확인
				break;
			}

			// < 0이면 mix 값
			int data1 = under[idx];
			int data2 = under[idx + 1];

//			if (data1 < 0)
//				data1 = arr_Under_Mix[under[idx] * -1]; // mix값에서 가져옴
//			if (data2 < 0)
//				data2 = arr_Under_Mix[under[idx] * -1];

			int nowV = data1 + data2 * 2;
			answer++; // 섞음

			under[idx + 1] = nowV;
			under[idx] = -1; // 현재값 null 처리

		}

		/**
		 * 계산된 값이 >=K 인경우 다음 idx부터 조회
		 * 
		 */

		return answer;
	}
}