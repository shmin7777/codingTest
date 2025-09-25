var max = 0
val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)
lateinit var visit: Array<BooleanArray>
lateinit var board: Array<IntArray>
var n = 0
var m = 0

fun main() {
    System.`in`.bufferedReader().use { br ->
        val (nn, mm) = br.readLine().split(" ").map { it.toInt() }
        n = nn; m = mm

        board = Array(n) { br.readLine().split(" ").map(String::toInt).toIntArray() }
        visit = Array(n) { BooleanArray(m) }

        for (i in 0 until n) {
            for (j in 0 until m) {
                visit[i][j] = true
                dfs(i, j, 1, board[i][j])
                visit[i][j] = false
            }
        }

        print(max)
    }
}

fun dfs(nx: Int, ny: Int, depth: Int, sum: Int) {
    if (depth == 4) {
        max = maxOf(max, sum)
        return
    }

    for (i in 0 until 4) {
        val curX = nx + dx[i]
        val curY = ny + dy[i]

        if (curX in 0 until n && curY in 0 until m && !visit[curX][curY]) {
            if (depth == 2) {
                visit[curX][curY] = true
                dfs(nx, ny, depth + 1, sum + board[curX][curY])
                visit[curX][curY] = false
            }
            visit[curX][curY] = true
            dfs(curX, curY, depth + 1, sum + board[curX][curY])
            visit[curX][curY] = false
        }
    }
}
