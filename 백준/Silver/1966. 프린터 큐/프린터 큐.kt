fun solution(m: Int, order: MutableList<Int>): Int {
    var answer = 0
    val queue = ArrayDeque<Node>()
    queue.addAll(order.mapIndexed { index, priority -> Node(index, priority) })

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        if (queue.any { it.priority > current.priority }) {
            queue.add(current)
            continue
        }
        answer++
        if (current.index == m) return answer
    }

    return answer
}

fun main() {
    System.`in`.bufferedReader().use { reader ->
        val sb = StringBuilder()
        val row = reader.readLine().toInt()
        repeat(row) {
            // n: 문서의 개수, m: 몇 번째로 인쇄되었는지 궁금한 문서의 위치
            val (n, m) = reader.readLine().split(" ").map { it.toInt() }
            val order = reader.readLine().split(" ").map { it.toInt() }.toMutableList()
            sb.append(solution(m, order)).append("\n")
        }

        print(sb.toString())
    }
}

data class Node(
    val index: Int,
    val priority: Int,
)
