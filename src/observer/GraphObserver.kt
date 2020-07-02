package observer

class GraphObserver : Observer {

    override fun update(generator: NumberGenerator) {
        println("GraphObserver:")
        val count = generator.number
        print("*".repeat(count))
        println()
        Thread.sleep(100)
    }

}