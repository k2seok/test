import java.util.*;

////https://www.acmicpc.net/problem/1094
public class Main {
    	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean arr[] = new boolean[6];
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int x = sc.nextInt();
		/**
		 * cal : 제곱 Math.pow(2, arr.legnth - i)
		 * nowX 에서 /2 만큼 계산
		 * all == for(int i; i = 0; i++)
		 * 		y += arr[i] ? Math.pow(2, i) : 0;
		 * 
		 *  y > 면
		 *  	continue
		 *  y == x 면 { arr[i] true 인 값들 찾아서 반환 end
		 *  y < x 면  arr[now] = true; 
		*/
		// maximum
		if(x == 64) {
			System.out.println(1);
		}
		else
		for (int round = arr.length; round > 0; round--) {

			int now = round - 1;
			//all
			int nowAll = 0;
			for (int i = 0; i < arr.length; i++) {
				nowAll += arr[i] ? Math.pow(2, i) : 0;
			}
			nowAll +=  Math.pow(2, now);
			
			// check
			if(nowAll > x)
				continue;
			else if(nowAll < x)
				arr[now] = true; 
			else if(nowAll == x) {
				int count = 1;	// all count + nowCount
				for (int j = 0; j < arr.length; j++) {
					count += arr[j] ? 1  : 0; 
				}
				System.out.println(count);	// result
				return;
			}
		}
	}
}
