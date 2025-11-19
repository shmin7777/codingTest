fun main() {
    System.`in`.bufferedReader().use { reader ->
        val sb = StringBuilder()
        while (true) {
            val N = reader.readLine().toInt().takeIf { it != 0 } ?: break
            val midList = mutableListOf<Int>()

            var low = 1
            var high = 50
            while (low <= high) {
                val mid = (low + high) / 2
                midList.add(mid)
                if (mid < N) {
                    low = mid + 1
                } else if (mid > N) {
                    high = mid - 1
                } else {
                    break;
                }
            }
            
            sb.append(midList.joinToString(" ")).append('\n')
        }

        println(sb.toString())
    }
}