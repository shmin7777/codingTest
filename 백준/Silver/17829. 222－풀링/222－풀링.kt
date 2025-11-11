fun main() {
    System.`in`.bufferedReader().use { reader ->
        val N = reader.readLine().toInt()

        val board = Array(N) { IntArray(N) }

        for (i in 0..<N) {
            val input = reader.readLine().split(" ").map { it.toInt() }
            for (j in 0..<N) {
                board[i][j] = input[j]
            }
        }

        println(merge(board))
    }
}

fun merge(board: Array<IntArray>): Int {
    if (board.first().size == 1) return board.first().first()

    val newBoard = Array(board.size / 2) { IntArray(board.size / 2) }
    for (i in board.indices step 2) {
        for (j in board.indices step 2) {
            val list = listOf(
                board[i][j],
                board[i][j + 1],
                board[i + 1][j],
                board[i + 1][j + 1]
            ).sortedDescending()
            newBoard[i / 2][j / 2] = list[1]
        }
    }

    return merge(newBoard)
}
