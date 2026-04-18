// "when" in Kotlin is a yummy food from simple and easy to cook recipe.
// in this recipe,we will learn how to make IfChef easier and smarter with WhenChef: when expression!
fun main() {
    val EggLeft = 20 // you must use PascalCase or camelCase instead 'Egg_Left'
    when (EggLeft) {
        1,2,3,4,5,6,7,8,9,10 -> println ("I think I need to buy more")
        11,12,13,14,15,16,17,18,19,20 -> println ("That's enough,but I must buy more")
        else -> println ("too much! Hmm... Can't count")
        // or use this to shorter (range checker)
        /*
        in 1..10 -> println ("I think I need to buy more")
        in 11..20 -> println ("That's enough!")
        */
  }
}
