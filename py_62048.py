def solution(w, h):
#     arr_Sort = list();

    a = b = 0.0;
    if(w > h):
        a = h;
        b = w;
    else:
        a = w;
        b = h;
    r = b % a;
    while r != 0:
        if(r > a):
            # a = a;
            b = r;
        else:
            a = r;
            b = a;
        r = b % a;
    
#     print(hex(w));
#     print(hex(h));
#     print(hex(w) * hex(h));
#     answer = int(hex(w) * hex(h) - hex(w+ h - a),10);
    answer = w * h - (w + h - a);
    print(int(answer)); 
    return answer;
   
solution(100000000, 100000000);
