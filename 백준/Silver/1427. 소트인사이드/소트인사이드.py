import sys

a = list(sys.stdin.readline().strip())
a.sort(reverse=True)
print("".join(a))
