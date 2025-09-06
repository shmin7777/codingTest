import sys


def recursive(start, N, star):
    if N == 1:
        star[start][start] = 1
    else:
        make(start, N, star)
        recursive(start + 2, N - 2, star)


def make(start, N, star):
    for i in range(start, N):
        for j in range(start, N):
            if i in (start, N - 1):
                star[i][j] = 1
            elif j in (start, N - 1):
                star[i][j] = 1


input = int(sys.stdin.readline().strip())

N = 1 + 4 * (input - 1)


star = [[0] * N for _ in range(N)]


recursive(0, N, star)

for i in range(N):
    for j in range(N):
        if star[i][j] == 1:
            print("*", end="")
        else:
            print(end=" ")
    print()
