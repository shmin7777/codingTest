import heapq
import sys

heap = []
heapq.heapify([])

n = int(sys.stdin.readline())
answer = []

for i in range(n):
    x = int(sys.stdin.readline())
    if x == 0:
        if len(heap) == 0:
            answer.append(0)
        else:
            answer.append(heapq.heappop(heap))
    else:
        heapq.heappush(heap, x)

print("\n".join(map(str, answer)))
