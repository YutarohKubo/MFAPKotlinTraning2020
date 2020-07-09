package strategy

class Player(private val name: String, private val strategy: Strategy) {

    private var winCount = 0
    private var loseCount = 0
    private var gameCount = 0

    fun nextHand() = strategy.nextHand()

    fun win() {
        strategy.study(true)
        winCount++
        gameCount++
    }

    fun lose() {
        strategy.study(false)
        loseCount++
        gameCount++
    }

    fun even() {
        gameCount++
    }

    override fun toString() = "[$name:$gameCount games, $winCount win, $loseCount lose]"

}