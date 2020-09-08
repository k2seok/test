package kakao2020blindTest;


public class Solution_60059 {
	/**
	 * 자물쇠와 열쇠 2차원 배열 key, lock 에서 key 를 회전, 방향 이동 할 수있는 모든 경우의수를 찾은 뒤 key 1 이 lock
	 * 의 모든 0에 일치해야 함
	 * 
	 * 1) 회전 round 생성 1 2 3 2) key 의 모든 1 값에서 모양일치확인 2.1) 모양 맞추기 : 1 n번째 값에 end[i]
	 * 값으로 맞췄다고 했때, 이동한만큼 1* n+ 1 값이 lock[i][j]와일치하는 지 확인
	 * 
	 * @param key
	 * @param lock
	 * @return
	 */
	final int _KEY = 1;
	final int _LOCK = 0;

	int cntK = 0;
	int cntL = 0;

	int nowKeyArr[][] = null;
	int lockArr[][] = null;
	private int[][] fieldLock;

	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		// 모양 일치 확인
		nowKeyArr = new int[key.length][2];
		lockArr = new int[lock.length][2];

		fieldLock = lock.clone();
		for (int i = 0; i < key[0].length; i++) {
			for (int j = 0; j < key[0].length; j++) {
				if (key[i][j] == _KEY) // start
				{
					nowKeyArr[cntK++] = new int[] { i, j };
				}
			}
		}

		for (int i = 0; i < key[0].length; i++) {
			for (int j = 0; j < key[0].length; j++) {
				if (lock[i][j] == _LOCK) // end
				{
					lockArr[cntL++] = new int[] { i, j };
				}
			}
		}

		// chnage
		/**
		 * 회전방법 1 2 3 은 90 180 270 도
		 * 
		 */
		for (int turn = 1; turn <= 4; turn++) {
			 int[][]nowKey = key.clone();

			for (int j = 0; j < key[0].length; j++) {
				int[] nowArr = new int[key[0].length];
				int idx = 0;
				for (int i = key[0].length - 1; i >= 0; i--) {
					nowArr[idx++] = nowKey[i][j];
				}
				key[j] = nowArr;
			}

			// check
			for (int i = 0; i < cntK; i++) {
				//i 번째 키 꺼내기
				int[] nowK = nowKeyArr[i].clone();
				int nowCnt = cntK;	// 남은 count 수

				for (int idx = 0; idx < cntL; idx++) {
					int[] nowL = lockArr[idx];

					// move : idx 번째 열쇠구멍에 맞춘다는 가정
					int nowI = nowL[0] - nowK[0];
					int nowJ = nowL[1] - nowK[1];

					//nowK[0] += nowI;
					//nowK[1] += nowJ;

					answer = isEnd(key.clone(), new int[] {nowI,nowJ}, nowCnt - 1);
					
					if(answer)
						return answer;
				}
				// nowK[i]
			}

		}

		return answer;

	}

	private boolean isEnd(final int[][] key, int[] move, int lockCnt) {
		int length = key[0].length;
		int[][] nowKey = new int[length][length];
		//key 이동
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				//move 만큼 현재의 nowKey value들 이동
				if(i + move[0] >= 0 && i + move[0] < length && j + move[1] >= 0 && j + move[1] < length)
					nowKey[i + move[0]][j+ move[1]] = key[i][j];
				
			}
		}
		// 일치확인 
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length ; j++) {	
				if(fieldLock[i][j] != _LOCK && nowKey[i][j] == _KEY)
					return false;
				if(fieldLock[i][j] == _LOCK && nowKey[i][j] == _KEY) {
					lockCnt--;
					if(lockCnt < 1)
						return true;
				}
			}
		}
		
		
		return false;
	}



}
