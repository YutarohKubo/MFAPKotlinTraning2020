package observer

class DigitObserver : Observer{

    override fun update(generator: NumberGenerator) {
        println("DigitObserver:" + generator.number)
        Thread.sleep(100)
    }

}