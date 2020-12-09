import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 3 or 5로 빼기

		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();

		//초기화
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int result = -1; // 최소
    
		int count = 0;
		queue.add(start);
		
		while (result < 1 && queue.size() > 0) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				
				// 5
				if(now - 5 >= 0) {
					if(!queue.contains(now - 5))
						queue.add(now - 5);
					
					if(now -5 == 0)//end
					{
						result = count;
						break;
					}
						
				}
				
				// 3
				if(now - 3 >= 0) {
					if(!queue.contains(now - 3))
						queue.add(now - 3);
					
					if(now -3 == 0)//end
					{
						result = count;
						break;
					}
				}
				
			}
		}
		System.out.println(result);
	}
}
