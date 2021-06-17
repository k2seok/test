public class programmers_72410 {

	public static void main(String[] args) {

		System.out.println(solution("...!@BaT#*..y.abcdefghijklm."	));
		System.out.println(solution("=.="	));
		
	}

	
	/**
	 * rule 7개순차 구현
	 * @param new_id
	 * @return
	 */
	  public static String solution(String new_id) {
	        String answer = new_id;
	        
	        //1
	        answer = answer.toLowerCase();
//	        System.out.println(answer);
	        //2
	        answer = answer.replaceAll("[^a-z0-9\\-\\_\\.]", "");
	        //3
	        answer = answer.replaceAll("\\.{2,}", ".");
//	        System.out.println(answer);
	        
	        //4
	        answer = answer.replaceAll("^\\.|\\.$", "");
	        //5
	        answer = answer.length() < 1 ? "a" : answer;
//	        System.out.println(answer);
	        //6
	        answer = answer.length() < 15 ? answer : answer.substring(0, 15).replaceAll("\\.$", "");
	        //7
	        String e= (""+answer.charAt(answer.length()-1)); 
	        answer = answer.length() > 2 ? answer : (answer+ e + e+ e).substring(0,3); 
//	        System.out.println(answer);
//	        
	        
	        return answer;
	    }
}
