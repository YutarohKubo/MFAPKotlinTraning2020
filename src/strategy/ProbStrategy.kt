package strategy

import kotlin.random.Random

class ProbStrategy(seed: Int) : Strategy {

    private val random = Random(seed)
    private var prevHandValue = 0
    private var currentHandValue = 0
    private val history = Array(3) {
        IntArray(3) { 1 }
    }

    override fun nextHand(): Hand {
        val bet = random.nextInt(getSum(currentHandValue))
        val handValue = when {
            bet < history[currentHandValue][0] -> 0
            bet < history[currentHandValue][0] + history[currentHandValue][1] -> 1
            else -> 2
        }
        return Hand.getHand(handValue)
    }

    private fun getSum(hv: Int) = history[hv].sum()

    override fun study(win: Boolean) {
        if (win) {
            history[prevHandValue][currentHandValue]++
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++
            history[prevHandValue][(currentHandValue + 1) % 3]++
        }
    }
}