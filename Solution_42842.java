//https://programmers.co.kr/learn/courses/30/lessons/42842
class Solution_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {-1, -1};

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
