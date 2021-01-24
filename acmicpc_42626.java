import java.util.Arrays;

public class acmicpc_42626 {
//Solution

	/**
	 * https://programmers.co.kr/learn/courses/30/lessons/42626 goal : scoville 정렬 후
	 * 작은 수 부터 스코빌 계산 진행, k 넘은 경우 end
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		int[] data = { 11, 1, 5, 2, 3, 9, 10, 12 };
//		System.out.println(solution(data, 7));
		System.out.println(solution(data, 11));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		int maxStartIdx = -1;
		Arrays.sort(scoville); // sort
		
		for (int i = 0; i < scoville.length; i++) {//계산안해도 되는 범위
			if(scoville[i] >= K) {
				maxStartIdx = i;
				break;
			}
		}
		
		
		int[] under = Arrays.copyOfRange(scoville, 0, maxStartIdx);	// 작은 
		int[] upper = Arrays.copyOfRange(scoville, maxStartIdx, scoville.length); // 큰 값 
		
		
		
		// i i+1 인덱스 스코빌 계산 
		for (int idx = 0; idx < under.length; idx++) {
			
			Arrays.sort(under); // sort 
			
			if (idx + 1 >= under.length) {
				
				//upper 값 있으면 한번더 섞음
				if(upper.length > 0)
					answer++;
				else
					answer = -1; // 결과 만들 수 없음
				break; 
			}
				
			int nowV = under[idx] + under[idx + 1] * 2;
			answer++; // 섞음
			
			if (nowV >= K) {
				break; // 종료
			}
			else {
				under[idx + 1] = nowV;
				under[idx] = -1; // 현재값 null 처리
			}
			
		}

		return answer;
	}
}