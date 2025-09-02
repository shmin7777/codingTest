def recursion(s, l, r, cnt):
    cnt += 1
    if l >= r:
        print(f"{1} {cnt}")
    elif s[l] != s[r]:
        print(f"{0} {cnt}")
    else:
        return recursion(s, l + 1, r - 1, cnt)


def isPalindrome(s):
    return recursion(s, 0, len(s) - 1, 0)


# 결과와 실행횟수 구하기

T = int(input())
for i in range(T):
    text = input()
    isPalindrome(text)
