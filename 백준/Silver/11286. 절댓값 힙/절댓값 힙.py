import heapq
import sys

heap = []
counter = {}

n = int(sys.stdin.readline())
answer = []

for i in range(n):
    x = int(sys.stdin.readline())
    counter[x] = counter.get(x, 0) + 1
    if x == 0:
        if not heap:
            answer.append(0)
        else:
            target = heapq.heappop(heap)
            if counter.get(-target, 0) > 0:
                counter[-target] = counter[-target] - 1
                answer.append(-target)
            else:
                counter[target] = counter[target] - 1
                answer.append(target)
    else:
        heapq.heappush(heap, abs(x))

print("\n".join(map(str, answer)))
