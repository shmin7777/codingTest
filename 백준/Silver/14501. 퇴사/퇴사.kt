import java.util.PriorityQueue
import kotlin.math.max

data class Consulting(val day: Int, val pay: Int)

fun main() {
    System.`in`.bufferedReader().use { reader ->
        val N = reader.readLine().toInt()
        val dp = IntArray(N) { -1 }
        val consultings = mutableListOf<Consulting>()
        repeat(N) { _ ->
            reader.readLine().split(" ").map { it.toInt() }.run {
                val (day, pay) = this
                consultings.add(
                    Consulting(
                        day = day,
                        pay = pay,
                    )
                )
            }
        }

        var result = 0
        for (i in 0 until N) {
            result = max(result, recursive(i, consultings, dp, N))
        }
        println(result)
    }
}

fun recursive(day: Int, consultings: List<Consulting>, dp: IntArray, N: Int): Int {

    if (day >= N) {
        return 0
    }

    val today = consultings[day]
    if (day + today.day > N) return 0
    if (dp[day] != -1) return dp[day]
    val queue = PriorityQueue<Int> { a, b -> b - a }
    for (i in today.day..N) {

        queue.add(
            today.pay + recursive(day + i, consultings, dp, N)
        )
    }

    val result = queue.poll() ?: 0
    dp[day] = result

    return result
}