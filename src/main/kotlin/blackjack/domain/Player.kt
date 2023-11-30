package blackjack.domain

data class Player(val name: String) {
    var state: PlayerState = PlayerState.READY
        private set

    val hand: Hand = Hand()

    fun init(deck: Deck) {
        check(state == PlayerState.READY) { "can only 'init' if the 'PlayerState' is 'READY'" }
        repeat(Rule.INIT_CARD_COUNT) { hand.add(deck.draw()) }
        state = PlayerState.UNDER
    }

    fun hit(deck: Deck) {
        check(state == PlayerState.UNDER) { "can only 'hit' if the 'PlayerState' is 'UNDER'" }
        hand.add(deck.draw())
        updateState()
    }

    fun stay() {
        check(state == PlayerState.UNDER) { "can only 'stay' if the 'PlayerState' is 'UNDER'" }
        state = PlayerState.STAY
    }

    private fun updateState() {
        val score = hand.getBestScore()
        val count = hand.getCardCount()
        state = when {
            score.value > Rule.BLACKJACK_SCORE -> PlayerState.BUST
            score.value == Rule.BLACKJACK_SCORE -> when (count == Rule.BLACKJACK_CARD_COUNT) {
                true -> PlayerState.BLACKJACK
                false -> PlayerState.STAY
            }
            else -> state
        }
    }
}

@JvmInline
value class Players(private val values: List<Player>) {

    constructor(vararg names: String) : this(names.map { Player(it) })

    init {
        require(values.size == values.map { it.name }.toSet().size) { "duplicate name has been used" }
    }
}

enum class PlayerState {
    READY,
    UNDER,
    STAY,
    BLACKJACK,
    BUST;
}
