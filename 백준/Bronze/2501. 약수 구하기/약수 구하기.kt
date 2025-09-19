fun main() {
    System.`in`.reader().use {
        val (N, K) = readln().split(" ").map { it.toInt() }

        var cnt = 0
        var result = 0
        for (i in 1..N) {
            if (N % i == 0) {
                cnt++
                if (cnt == K) {
                    result = i
                    break
                }
            }
        }

        println(result)
    }
}
