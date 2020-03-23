import br.com.roquebuarque.dsl.HAPPY_BIRTHDAY_CAKE

object Cooker {
     infix fun make(value: Dish) =
         OrderReceipt(value.convertDishToString())
}

sealed class Ingredients{
    object Chocolate : Ingredients()
    object Coconut : Ingredients()
    object Sugar : Ingredients()
}

sealed class Event{
    object Birthday : Event()
    data class Party(val date: String) : Event()
}

sealed class Dish
object Cake : Dish()

data class OrderReceipt(private val ingredients: String) {

    infix fun of(main: Ingredients) = combineReceipt("of", main)

    infix fun and(additional: Ingredients) = combineReceipt("and", additional)

    infix fun withOut(removedIngredients: Ingredients) = combineReceipt("without", removedIngredients)

    infix fun forMy(cakeType: Event): String {
        return "$ingredients for my ${cakeType.convertTypeToString()}"
    }

    private fun combineReceipt(key: String, ingredients: Ingredients) =
        OrderReceipt("${this.ingredients} $key ${ingredients.convertFlavorToString()}")

}

private fun Event.convertTypeToString(): String {
    return when (this) {
        is Event.Birthday ->  "birthday $HAPPY_BIRTHDAY_CAKE"
        is Event.Party -> this.date
    }
}

private fun Dish.convertDishToString(): String {
    return when (this) {
        is Cake -> "\n \n \n \n Cake"
    }
}

private fun Ingredients.convertFlavorToString(): String {
    return when (this) {
        is Ingredients.Chocolate -> "Chocolate"
        is Ingredients.Coconut -> "Coconut"
        is Ingredients.Sugar -> "Sugar"
    }
}
