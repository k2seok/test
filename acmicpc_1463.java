import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	//https://www.acmicpc.net/problem/1463
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = 0;
		x = sc.nextInt();

    if(x <= 1) { // 1인경우
			System.out.println(0); 
			return;
		}

		Queue<Integer> queue = new ArrayDeque<Integer>();

    int count = 0;
		queue.add(x);
		while(true) {
			//1 /3
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				
				if(now%3 < 1) {
					//check end
					if(now/3 == 1) {
						System.out.println(count + 1);
						return;
					}
					else queue.add(now/3);
				}
				
				if(now%2 < 1) {
					//check end
					if(now/2 == 1) {
						System.out.println(count + 1);
						return;
					}
					else queue.add(now/2);
				}
				
				if(true){
					//check end
					if(now - 1 == 1) {
						System.out.println(count + 1);
						return;
					}
					else queue.add(now - 1);
				}
			}
			count++;
		}
	}
}
