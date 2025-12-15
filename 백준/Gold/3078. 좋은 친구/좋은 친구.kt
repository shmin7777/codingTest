fun main() {
    System.`in`.bufferedReader().use { reader ->
        val (n, k) = reader.readLine().split(" ").map { it.toInt() }

        val lengthCountMap = mutableMapOf<Int, MutableList<Int>>()
        var answer = 0L
        repeat(n) {
            val name = reader.readLine()
            val indexList = lengthCountMap.getOrDefault(name.length, mutableListOf())
            indexList.add(it)
            lengthCountMap[name.length] = indexList
        }

        lengthCountMap.values.forEach { idxList ->
            var s = 0
            var e = 0

            while (s < idxList.size) {
                while (e < idxList.size && idxList[e] - idxList[s] <= k) {
                    e++
                }
                answer += (e - s - 1)
                s++
            }
        }

        println(answer)
    }
}