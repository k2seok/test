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
