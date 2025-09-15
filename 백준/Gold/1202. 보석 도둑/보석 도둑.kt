import java.util.PriorityQueue

data class Jewel(val M: Int, val V: Long)

fun main() {
    with(System.`in`.bufferedReader()) { ->
        val (N, K) = readLine().trim().split(" ").map { it.toInt() }

        val jewels = mutableListOf<Jewel>()
        repeat(N) {
            val (m, v) = readLine().trim().split(" ")
            jewels.add(Jewel(m.toInt(), v.toLong()))
        }

        val bags = IntArray(K) { readLine().trim().toInt() }

        jewels.sortBy { it.M }
        bags.sort()

        val pq = PriorityQueue<Jewel>(compareByDescending { it.V })

        var idx = 0
        var total = 0L

        for (cap in bags) {
            // 이 while은 전역 idx를 증가시키므로 각 보석은 한 번만 처리됨
            while (idx < N && jewels[idx].M <= cap) {
                pq.add(jewels[idx])
                idx++
            }
            if (pq.isNotEmpty()) {
                total += pq.poll().V
            }
        }

        println(total)
    }
}
