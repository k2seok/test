import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class programmers_67256 {

	/**
	 * https://programmers.co.kr/learn/courses/30/lessons/67256?language=java 키패드누르기
	 * 
	 * 
	 * 1 4 7 은 left only
	 * 3 6 9 
	 * 2 5 8 0 은 가까운손 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] a = new int [] {1, 3, 4, 1, 4, 5, 9, 5};
		int[] a = new int [] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";

		
		System.out.println(solution(a, hand));

	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		
		//index up : + 3
		//scale up : + 2
	
		int[] lHands = new int[] {1 ,4 ,7}; 
		int[] rHands = new int[] {3 ,6 ,9}; 
		
		
		
		
		int startL = 1;
		int nowLHand = -1; // * 
		int nowRHand = -2; // #
		// 1 : numbers n 이 2 5 8 0 인지 확인
		// 
		
		for(int num : numbers) {
			String nowH = "";
			if(Arrays.binarySearch(lHands, num) >= 0){
				nowH += "L";
			}else if(Arrays.binarySearch(rHands, num) >= 0){
				nowH += "R";
			}else { //가까운 손 확인
				//2차원 배열로 변환 후 비교
				int now = num;
				
				// 키패드 배열 index 크기는 4*3
				int[] nowArr = getHandArray(now);
				
				int[] arrL = getHandArray(nowLHand);
				int[] arrR = getHandArray(nowRHand);
			
				// 거리값 계산
				int vL = Math.abs(arrL[0] - nowArr[0]) + Math.abs(arrL[1] - nowArr[1]);
				int vR = Math.abs(arrR[0] - nowArr[0]) + Math.abs(arrR[1] - nowArr[1]);
				
				//결과비교
				if(vL == vR) {
					nowH = "right".equals(hand) ? "R" : "L"; //주손을 사용
				}else {
					nowH = vL < vR ? "L" : "R";
				}
			}
			
			if("R".equals(nowH))
				nowRHand = num;
			else
				nowLHand = num;
			
			answer += nowH; 
		}
		
		return answer;
	}

	private static int[] getHandArray(int now) {
		if(now < 0) { // * 또는 #
			return now == -1 ? new int[] {3,0} : new int[] {3,2};
		}else if(now == 0) {
			return new int[] { 3,1};
		}
		
		int i = now%3 == 0 ? now/4 : now/3;
		int j = now%3 > 0 ? now%3 -1 : 2; // 3개 값 까지 표기
		
		
		return new int[] {i,j};
	}
}