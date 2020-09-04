//https://programmers.co.kr/learn/courses/30/lessons/42842
class Solution_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {-1, -1};
        /**
         * 카펫은 brown + y  길이의 2차원 배열 값
         * 1차원배열로 생각해서 풀면 쉽다
         * 1차원에서카펫은 항상  b/2  + y + b/2 의 길이를 갖게됨
         * b/2%2 + b%2 + y 는 한배열 (가로)의 길이
         * 2 1 이 아닌경우,
         * 
         * ex 12개씩 나누면 24/2 = 12 
         * . 테두리값은 남아야하므로 12 이하이어야 함
         * .. 12 - 8 = 4
         * 1) 약수의 값 찾기
         * 2)1 이 맞다는 가정으로 check
         * 
         * 테두리영역만 제외하면 계산식이 (x-2) * (y-2)  == yellow
         * 일치하는 값이 answer
         * 24
         *
         *  
         *  48 8 6 12 4 10 2 
         *  6 4 
         *  24 약수 6 4
         *  . . . . . . . .
         *  . . . . . . . .
         *  . . . . . . . .
         *  . . . . . . . .
         *  . . . . . . . .
         *  . . . . . . . .
         */
        
        final int CNT = brown + yellow;
        
        int[] arr = new int[10000000];
        int[] xArr = new int[10000000];
        int count = 0;
        
        for (int b = CNT; b > 2; b--) {
        	if(CNT%b >= 1)
        		continue;
        	if(b < CNT/b) continue ; //가로가 항상 큼
        	arr[b] = CNT/b;
        	xArr[count++] = b;
		}
        
        // only one
       if(count < 1)
    		//   System.out.println("err");
    		   return new int[]{ xArr[0] , arr[xArr[0]]};
       // 2)
       for (int i = 0; i < count; i++) {
    	   
    	   int x = xArr[i];
    	   int y = arr[xArr[i]];
    	   if((x-2) * (y-2) == yellow) { //find
    		   return new int[] { x , y};
    	   }
       }
        
        return answer;
    }
}