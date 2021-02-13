import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class programmers_43165 {
	// Solution
	
	/*
	 * 1) condition
	 * numbers[idx] 는 50 개 이하,  경우의수는  2*len(numbers)
	 * 2<= idx <= 20 이므로 최대 20*2  ... O(1)
	 * 
	 * 2) 
	 * 
	 */
	
	public static int arr[];
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		// 짝수idx 는 음수표현, 홀수는 값
		int count = numbers.length*2; // 자연수 개수 포함 값
		arr = new int[count];
		
		// 0 is - , 1 is - 
		input(0,0);
		input(0,1);
		
		
		return answer;
	}
	
	private static void input(int nowI, int c) {
		
		//if(c )
		
	}

	public static void main(String[] args) {
		int target = 3;
		int[] numbers;
		numbers = new int[]{1, 1, 1, 1, 1	};
		System.out.println(solution(numbers, target));
	}
}