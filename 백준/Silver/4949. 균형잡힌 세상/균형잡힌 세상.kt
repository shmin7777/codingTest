import java.util.Stack

fun main() {
    System.`in`.bufferedReader().use { reader ->
        val sb = StringBuilder()

        while (true) {
            val line = reader.readLine()
            if (line == ".") break
            sb.append(solution(line)).append('\n')
        }

        print(sb.toString())
    }
}

fun solution(str: String): String {
    var flag = true
    val stack = Stack<Char>()

    for (c in str) {
        when(c){
            '(' -> stack.push(c)
            '[' -> stack.push(c)
            ']' -> {
                if(stack.isNotEmpty() && stack.peek()=='['){
                    stack.pop()
                }else {
                    flag = false
                    break
                }
            }
            ')' -> {
                if(stack.isNotEmpty() && stack.peek()=='('){
                    stack.pop()
                }else {
                    flag = false
                    break
                }
            }
        }
    }

    return if (flag && stack.isEmpty()) "yes" else "no"
}
