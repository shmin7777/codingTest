import sys

arr = sys.stdin.readline().strip().split(sep=" ")
new_arr = list(map(lambda a: int(a), arr))
new_arr.sort()

print(new_arr[1])
