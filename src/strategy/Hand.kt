package strategy

class Hand private constructor(private val handValue: Int) {
    companion object {
        private const val HANDVALUE_GUU = 0
        private const val HANDVALUE_CHO = 1
        private const val HANDVALUE_PAA = 2

        private val hand = arrayOf(Hand(HANDVALUE_GUU), Hand(HANDVALUE_CHO), Hand(HANDVALUE_PAA))
        private val name = arrayOf("グー", "チョキ", "パー")

        fun getHand(handValue: Int) = hand[handValue]
    }

    fun isStrongerThan(h: Hand) = fight(h) == 1

    private fun fight(h: Hand) = when {
        this === h -> 0
        (this.handValue + 1) % 3 == h.handValue -> 1
        else -> -1
    }

    override fun toString() = name[handValue]

}