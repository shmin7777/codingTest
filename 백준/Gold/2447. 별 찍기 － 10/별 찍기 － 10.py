import sys

N = int(sys.stdin.readline())
star = [["*"] * N for i in range(N)]


def recursicve(start):
    global N
    global star
    if start // 3 == N:
        return

    first = list([start // 3, start // 3])

    length = start // 3
    for i in range(length, N):
        if i == start + first[0]:
            first[0] = i
        for j in range(length, N):
            if j == start + first[1]:
                first[1] = j

            if i == first[0] and j == first[1]:
                star[i][j] = " "
            if i - length < first[0] and j - length < first[1]:
                star[i][j] = " "

        first[1] = length
    recursicve(start * 3)


recursicve(3)

for i in star:
    print("".join(i))
