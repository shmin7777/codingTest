import sys


def execution(c: str):
    parts = c.split(" ")
    command = parts[0]

    if command == "1":
        stack.append(parts[1])
    elif command == "2":
        answerList.append(stack.pop() if stack else -1)
    elif command == "3":
        answerList.append(len(stack))
    elif command == "4":
        answerList.append(0 if stack else 1)
    else:
        answerList.append(stack[-1] if stack else -1)


n = int(sys.stdin.readline())
answerList = []
stack = []

for i in range(n):
    c = sys.stdin.readline().strip()
    execution(c)

print(*answerList, sep="\n")
