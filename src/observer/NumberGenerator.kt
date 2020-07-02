package observer

abstract class NumberGenerator {

    private val observers = arrayListOf<Observer>()
    abstract var number: Int

    fun addObserver(observer: Observer) = observers.add(observer)

    fun deleteObserver(observer: Observer) = observers.remove(observer)

    fun notifyObservers() = observers.forEach { it.update(this) }

    abstract fun execute()

}