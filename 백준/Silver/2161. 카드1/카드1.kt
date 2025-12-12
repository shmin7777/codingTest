fun main(){
    System.`in`.bufferedReader().use { reader ->
        val N = reader.readLine().toInt()
        val cards = (1..N).toList()
        val queue = ArrayDeque(cards)
        val sb = StringBuilder()

        while(queue.isNotEmpty()){
            if(queue.size == 1){
                val lastCard = queue.removeFirst()
                sb.append(lastCard)
                break
            }
            sb.append(queue.removeFirst()).append(" ")
            queue.add(queue.removeFirst())
        }

        println(sb.toString())
    }
}
