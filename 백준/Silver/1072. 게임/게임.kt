import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    System.`in`.bufferedReader().use { reader ->
        val (totalCnt, winCnt) = reader.readLine().split(" ").map { it.toInt() }

        var answer = -1
        val currentRate = getRate(totalCnt, winCnt)
        if (currentRate != -1) {
            var left = 1
            var right = totalCnt

            while (left <= right) {
                val mid = (left + right) / 2
                val newRate = getRate(totalCnt + mid, winCnt + mid)
                if (currentRate != newRate) {
                    answer = mid
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }
        
        println(answer)
    }
}

fun getRate(totalCnt: Int, winCnt: Int): Int {
    return winCnt.toBigDecimal().divide(totalCnt.toBigDecimal(), 2, RoundingMode.DOWN)
        .multiply(BigDecimal.valueOf(100))
        .toInt()
}