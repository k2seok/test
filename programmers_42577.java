import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class programmers_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //1. len 만큼 for 돌리면서 key value 저장, 있는경우 false 반환 end
        /**
         * 2. 입력시 검사,
         * 3. check() : len map 에서 foreach 로 일치 검사 ,로 split 후 n 과 일치 확인
         * key len
         * value  String , 로 입력
         *  
         */
       
        int minLen = 1;
        Arrays.sort(phone_book);
        
        
        Map<Integer, String> book = new LinkedHashMap<Integer, String>();
        for (int i = 0; i < phone_book.length; i++) {
        	

        	//check
        	for (int j = minLen; j < phone_book[i].length(); j++) {
				if(!book.containsKey(j))
					continue;
				String[] now = book.get(j).split(",");
				String b = phone_book[i].substring(0,j);
				
				for (String s : now) {
					if(b.equals(s)) {
						//System.out.println(s + " is consist of " + b );
						return false;
					}
				}
			}
        	
        	int len = phone_book[i].length();
        	minLen = minLen > len ? len : minLen;
        	book.put(len, book.containsKey(phone_book[i]) ? book.get(phone_book[i].length()) + ","+ phone_book[i] : phone_book[i]);
        	
        	
		}
        
        
        
        return answer;
    }
}