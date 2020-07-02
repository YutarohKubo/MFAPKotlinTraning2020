package observer

class RandomNumberGenerator : NumberGenerator(){
    override var number = 0

    override fun execute() {
        for (i in 0 until 20) {
            number = (0 until 50).random()
            notifyObservers()
        }
    }
}