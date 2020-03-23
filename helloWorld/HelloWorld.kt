fun main() {
    helloWorld{
        print("$this $it")
    }
}

fun helloWorld(block: String.(String) -> Unit) {
    block("Hello", "World")
}