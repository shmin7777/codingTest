import java.util.*

fun main() {
    System.`in`.bufferedReader().use { reader ->
        val dx = listOf(1, -1, 0, 0)
        val dy = listOf(0, 0, 1, -1)
        val (m, n) = reader.readLine().split(" ").map { it.toInt() }
        val queue = LinkedList<Tomato>()
        val visited = Array(n) { BooleanArray(m) }
        var nonRipeTomato = 0

        val board = mutableListOf<List<Int>>()
        for (i in 0 until n) {
            val row = reader.readLine().split(" ").map { it.toInt() }
            board.add(row)

            row.forEachIndexed { idx, r ->
                if (r == 1) {
                    queue.add(
                        Tomato(
                            x = i,
                            y = idx,
                            depth = 0
                        )
                    )
                }

                if (r == 0) nonRipeTomato++
            }
        }

        if (nonRipeTomato == 0) {
            println(0)
            return
        }

        var maxDay = 0

        while (queue.isNotEmpty()) {
            val tomato = queue.removeFirst()
            visited[tomato.x][tomato.y] = true

            maxDay = maxOf(maxDay, tomato.depth)

            repeat(4) {
                val nx = tomato.x + dx[it]
                val ny = tomato.y + dy[it]

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    if (board[nx][ny] == 0) {
                        nonRipeTomato--
                        queue.add(
                            Tomato(
                                x = nx,
                                y = ny,
                                depth = tomato.depth + 1,
                            )
                        )
                    }
                }
            }
        }

        if (nonRipeTomato == 0) {
            println(maxDay)
        } else {
            println(-1)
        }

    }
}

data class Tomato(
    val x: Int,
    val y: Int,
    val depth: Int,
)