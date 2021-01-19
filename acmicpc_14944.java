import java.util.Scanner;

//https://www.acmicpc.net/problem/14944
public class acmicpc_14944 {

	public static void main(String[] args) {

		long result = 10000000;

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int arr[] = new int[N + 1];

		for (int i = 0; i < N; i++) {
			arr[i + 1] = sc.nextInt();
		}

		/*
		 * 1)n개의 모든 길 길이 합 + 만들어준 길 + eI 에서 길의 끝점까지 가는길 - si , si_+1 길의 값 
		 * 2)0에서 ei 까지의 합(어차피 지나갈 길임) + 만들어준길 + ei에서 길의끝점까지 *2 - si , si_+1 길의 값
		 * 3)sI eI 이동 후 다시백 : 0부터 끝까지 이동 + 만들어준길 *2  
		 * 4)길 끝에서 새로운 길 이동 후, 끝까지 이동 : 0 ~eI 까지 이동 +새로운길 + sI부터 eI까지 이동
		 */
		for (int T = 0; T < M; T++) {
			long now = 0;
			// boolean visit[] = new boolean[N + 1];
			int sI = sc.nextInt();
			int eI = sc.nextInt();
			int nV = sc.nextInt(); // 새로운 길의 값


			
			
			// 1)
			{
				for (int i = 0; i < arr.length; i++) {
					now += arr[i];
				}
				now+=nV;
				
				for (int j = eI+1; j < arr.length; j++) {
					now += arr[j];
				}
				now -= arr[sI+1];
			}
			
			result = result < now ? result : now;
			now = 0;
			//2
			{
				for (int i = 0; i <= eI; i++) {
					now += arr[i];
				}
				now+= nV;
				
				int v = 0;
				for (int j = eI+1; j < arr.length; j++) {
					v +=arr[j];
				}
				now += v*2;
				
				now -= arr[sI+1];
			}
			
			result = result < now ? result : now;
			now = 0;
			
			//3
			{
				for (int i = 0; i < arr.length; i++) {
					now += arr[i];
				}
				
				now += nV*2;
			}
			
			result = result < now ? result : now;
			now = 0;
			

			// 4)
			{
				for (int i = 0; i <= eI; i++) {
					now += arr[i];
				}
				now+=nV;
				
				for (int j = sI+1; j <= eI; j++) {
					now += arr[j];
				}
			}
			
			result = result < now ? result : now;
			now = 0;
			
		}

		System.out.println(result);

	}

}
