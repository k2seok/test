import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class programmers_1830 {
//Solution

	/*
	 * 단어별(띄어쓰기별) 규칙 확인: 대문자 입력 , 소문자 광고 
	 * 규칙1 : split 
	 * 규칙2 : 접두 접미 
	 * 규칙3 : trim > 항상 적용 
	 * 
	 *1) find all a b, set
	 *2) a > 2? lastindexOf a , 1st idx -1 ~ lastidx  +1 
	 *3) else  idx ~ lastIdx  
	 *>> valid > visit[i] ? invalid else " " + s
	 *return answer.trim
	 */
    public static String solution(String sentence) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < sentence.length; i++) {
        	char c = sentence.charAt(i);
			
        	if(c < 'A' || c > 'Z')
        		map.put(c +"", i); //lastIdx
        	
		}
        
        
        
        
        return answer;
    }


	public static void main(String[] args) {
		
		System.out.println(solution("HaEaLaLaObWORLDb"));

	}
}