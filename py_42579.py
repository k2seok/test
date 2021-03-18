'''
py_42577.py
range(start int, end int, inc int)
str(int) > convert to  String

1. input genres Arr  append or  add (idx, value)
2. sorting and input : a < nowV ? insert : next

3. result calcul
    3.1 sum all play v 
    3.2 answer add v (Answer) 

    
    arr[10000 *10000]  # is maiximum table 
    arr
    IDX_GEN = 10000;
    gen_Cnt = 0;
'''

        
def solution(genres, plays):
    IDX_GEN = 10000;
    answer = [];
    lst_Answer = [];# gen Name List
    input_genres = []; 
    
    for i in range(0, len(genres)):
#
        gen = genres[i];  # idx = 0;
        
        if gen not in input_genres:  # Name not exist > append new
            lst_Answer.append([gen, i]);
            input_genres.append(gen);
        else:  # exist
            idx = 0;
            while idx < len(lst_Answer):
                if(gen == lst_Answer[idx][0]):
                    break;  # find genres Idx
                idx += 1;
            for j in range(1, len(lst_Answer[idx])): # input now Idx genres
                # sorting
                prev = plays[lst_Answer[idx][j]];
                nowV = plays[i];
                if(prev < nowV):
                    lst_Answer[idx].insert(j, i);
                    break;
                
                if(j == len(lst_Answer[idx]) - 1):  # end value
                   lst_Answer[idx].append(i);
        
    lst_max = [];
    for _rank in range(0, len(lst_Answer)):  # find genres rank all gen
        maxV = -1;
        idx = -1;
        # print(len(lst_Answer));
        for i in range(0, len(lst_Answer)):
            if i in lst_max:
                continue;
            
            nowM = 0;
            for _v in lst_Answer[i][1:]:
                nowM += plays[_v];
            if maxV < nowM:
                maxV = nowM;
                idx = i;
        lst_max.append(idx); 
    
    for _i in range(0, len(lst_Answer)):  # pop all gen best songs until 2nd   
        v = lst_max.pop(0);
        if(v < 0):
            break;
        now = lst_Answer[v];
        if(len(now) < 3):
            answer += now[1:2];
        else:
            answer += now[1:3];
    #print(answer)
    return answer;

#sol1_Answer = [4, 1, 3, 0];

print(solution(["pop", "jazz", "jazz", "rap", "rap"], [5, 5, 40, 5, 5])) # 2 1 3 4 0

'''
#TestCase
genres = ['classic', 'pop', 'classic', 'classic', 'pop'];
plays = [500, 600, 150, 800, 2500];
sol1_Answer = [4, 1, 3, 0];

genres = ["a", "c", "c", "e", "e", "f","a", "c", "c", "e", "e", "f"]
plays = [1, 3, 3, 5, 5, 5,1, 3, 3, 5, 5, 5]
sol1_Answer = [5, 4] # 4 3 5

if sol1_Answer == solution(genres, plays):
    print(True)

genres = ['A', 'B', 'A', 'A','B']
plays = [500, 600, 501, 800, 900]

sol1_Answer = [0,1,2]


if sol1_Answer == solution(genres, plays):
    print(True)

else:
    print(False)
''' 
