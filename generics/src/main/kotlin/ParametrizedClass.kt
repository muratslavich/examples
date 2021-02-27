class ParametrizedClass<T>(
    private val value: T
) {

    fun getValue(): T {
        return value;
    }

}

fun main() {
    val parametrizedClass = ParametrizedClass<String>("example")
    val parametrizedClass1 = ParametrizedClass("example") // type can be inferred
}

class Producer<out T>