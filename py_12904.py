# -*- coding: utf-8 -*- 
# programmers.co.kr/learn/courses/30/lessons/12904?language=python3
## Tip : python 한글주석 사용시, 최상단에 인코딩 표기를 해주어야 에러가 발생안함
''''
1) len(s) 만큼 실행
   nowLen /2 만큼 나눈값을 reverse
   else nowLen%2 > 0  
        nowLen - 1  #holsu
 now == reverse  is palindrome
  2) str[0:3
   
  con) time : 120
  String arr 는 역시 python 이 유리.
     
'''

def solution(s):
    answer = 1

    for _length in range(2, len(s) + 1):
        for _idxS in range(0, len(s) - 1):
            if(_idxS + _length > len(s)):
                #print("idx overflow")
                break;
            _nowLen = (int)(_length / 2);

            left = s[_idxS:_idxS + _nowLen];
            right = "";
            _idxS += _nowLen;  # next start idx
            
            if(_length % 2 > 0):  # holsu
                _idxS += 1;
                if(_idxS + _nowLen > len(s)):
                    break;
                right = s[_idxS:_idxS + _nowLen];
            else:
                if(_idxS + _nowLen > len(s)):
                    break;
                right = s[_idxS:_idxS + _nowLen];
                
            #print(left + "|" + right);  # equals == palindrome
            if(left[::-1] == right):
                #print("find: " + str(_length));
                answer = _length;  # do not find any more
                break; 

    return answer


result = solution("abcdcba");
sol1_Answer = 3;
print(result);
if sol1_Answer == result:
    print("true");


'''
# 펠린드롬의 특징을 활용한 최대 길이값 찾기
# 특징 : 
# 1) 재귀를 통한 분할정복 > 1 에서 2~ len(s)까지 검사, 중복검사가 이루어
# def shortest_palindrom_ByProgrammers(s):
#     if s[::-1] == s:
#         print(s + "|" + s[::-1])
# 
#     return len(s) if s[::-1] == s else max(shortest_palindrom_ByProgrammers(s[:-1]), shortest_palindrom_ByProgrammers(s[1:]))
# print(shortest_palindrom_ByProgrammers("zbdabdabddd"));
'''