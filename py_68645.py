# https://programmers.co.kr/learn/courses/30/lessons/68645?language=python3
def solution(n):
    answer = []
    lst_Arr = [[0] * (_i + 1) for _i in range(n)];
    
    way = 0; 

    cnt = n;
    v = 1;
    now = [-1, 0];
    while cnt > 0:
        way %= 3;
        way += 1;
    
        if way == 1:  # left
            for _cnt in range(cnt):
                now[0] += 1;
                #print(now);
                lst_Arr[now[0]][now[1]] = v;
                v += 1;
        if way == 2:  # right
            for _cnt in range(cnt):
                now[1] += 1;
                #print(now);
                lst_Arr[now[0]][now[1]] = v;
                v += 1;
        if way == 3:  # up
            for _cnt in range(cnt):
                now[0] -= 1;
                now[1] -= 1;
                #print(now);
                lst_Arr[now[0]][now[1]] = v;
                v += 1;
                
        cnt -= 1;
    
    for lst in lst_Arr:
        answer += lst;
    return answer


result = solution(4);
sol1_Answer = [1, 2, 9, 3, 10, 8, 4, 5, 6, 7];
#print(sol1_Answer);
if sol1_Answer == result:
    print("true");
