import sys
from collections import deque


def bfs():
    visit = [False for i in range(200000)]
    visit[n] = True
    queue = deque([])
    queue.append((n, 0))
    while queue:
        n1, time = queue.popleft()
        if n1 == k:
            return time

        nextList = [n1 * 2, n1 + 1, n1 - 1]
        for next in nextList:
            if next >= 0 and next < 200000 and not visit[next]:
                queue.append((next, time + 1))
                visit[next] = True


n, k = map(int, sys.stdin.readline().split(" "))
print(bfs())