import sys
from collections import deque
from typing import List


n = int(sys.stdin.readline())
x = [1, -1, 0, 0]
y = [0, 0, 1, -1]

region = []
maxHeight = 0

for _ in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    maxHeight = max(maxHeight, max(row))
    region.append(row)

answer = 0

for height in range(0, maxHeight + 1):
    queue = deque()
    visit = [[False] * n for _ in range(n)]
    zone = 0
    for i in range(n):
        for j in range(n):
            if region[i][j] > height and not visit[i][j]:
                zone += 1
                queue.append((i, j))
                visit[i][j] = True

                while queue:
                    n1 = queue.popleft()

                    for d in range(4):
                        x1 = n1[0] + x[d]
                        y1 = n1[1] + y[d]

                        if (
                            x1 >= 0
                            and y1 >= 0
                            and x1 < n
                            and y1 < n
                            and not visit[x1][y1]
                        ):
                            if region[x1][y1] > height:
                                queue.append((x1, y1))
                                visit[x1][y1] = True
    answer = max(zone, answer)

print(answer)
