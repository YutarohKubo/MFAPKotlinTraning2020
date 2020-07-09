package strategy

fun main() {
    val player1 = Player("Taro", WinningStrategy(314))
    val player2 = Player("Hana", ProbStrategy(15))
    repeat(100) {
        val nextHand1 = player1.nextHand()
        val nextHand2 = player2.nextHand()
        when {
            nextHand1.isStrongerThan(nextHand2) -> {
                println("Winner:$player1")
                player1.win()
                player2.lose()
            }
            nextHand2.isStrongerThan(nextHand1) -> {
                println("Winner:$player2")
                player1.lose()
                player2.win()
            }
            else -> {
                println("Even...")
                player1.even()
                player2.even()
            }
        }
    }
    println("Total result:")
    println(player1)
    println(player2)
}

