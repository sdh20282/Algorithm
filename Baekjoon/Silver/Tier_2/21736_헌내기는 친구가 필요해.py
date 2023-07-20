N , M = map(int,input().split())

campus = []

doyeon = []


for i in range(N):
    tmp = list(input())
    campus.append([])
    
    for j in range(M):
        if tmp[j] == "I":
            doyeon.append(i)
            doyeon.append(j)
            
        campus[i].append(tmp[j])

stack = [doyeon]

campus[doyeon[0]][doyeon[1]] = 'X'

dx = [-1,0,1,0]
dy = [0,1,0,-1]

cnt = 0

while stack:
    v = stack.pop()

    if campus[v[0]][v[1]] == 'P':
        cnt += 1

    campus[v[0]][v[1]] = 'X'

    for i in range(4):
        newX = v[0] + dx[i]
        newY = v[1] + dy[i]

        if newX >=0 and newX < N and newY >= 0 and newY < M:
            if campus[newX][newY] != 'X':
                stack.append([newX,newY])

if cnt > 0 :
    print(cnt)
else:
    print("TT")