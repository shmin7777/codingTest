import kotlin.math.pow

fun main() {
    System.`in`.bufferedReader().use { reader ->
        val sb = StringBuilder()
        while (true) {
            val line = reader.readLine() ?: break
            val N = line.toIntOrNull()?: break
            val str = "-".repeat(3.0.pow(N).toInt())
            sb.append(merge(str)).append("\n")
        }

        println(sb.toString())
    }
}

fun merge(str: String): String {
    if (str.length == 1) return str
    val interval = str.length / 3

    val left = merge(str.substring(0, interval))
    val mid = " ".repeat(interval)
    val right = merge(str.substring(str.length - interval, str.length))
    return left + mid + right
}

