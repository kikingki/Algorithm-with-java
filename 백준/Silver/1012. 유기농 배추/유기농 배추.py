import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

# 4방향 좌표
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

# 깊이 우선 탐색(DFS) - 재귀로 구현
def dfs(x, y):
    if x < 0 or x >= m or y < 0 or y >= n:          # 범위를 벗어날 경우
        return False

    if field[y][x] == 1:
        field[y][x] = 0         # 방문한 노드 다시 방문X
        for i in range(4):      # 4방향 검사
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)         # 재귀 호출
        return True
    return False


t = int(input())
for _ in range(t):
    m, n, k = map(int, input().split())
    field = [[0]*m for _ in range(n)]           # N x M 지도
    count = 0

    for _ in range(k):
        x, y = map(int, input().split())
        field[y][x] = 1                         # 첫번째 괄호가 y 좌표

    for i in range(n):
        for j in range(m):
            # 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사
            if dfs(j, i):
                count += 1
    print(count)

