# https://programmers.co.kr/learn/courses/30/lessons/42577?language=python3
'''
py_42577.py
range(start int, end int, inc int)
'''
def solution(phone_book):
    # false or true
    i = 0;
    for i in range(0, len(phone_book)):
        for j in range(0, len(phone_book)):
            if i == j:
                continue; 
            print(str(i) + '+++' + str(j))
            ab = str(phone_book[i]);
            cd = str(phone_book[j]);
            #print(ab);
            #print(cd[:len(ab)]);
            if ab == cd[:len(ab)]:
                return False;
    return True;


#solution([119, 97674223, 1195524421]);
print(solution([99,9, 12, 123, 1235, 567, 88]));
