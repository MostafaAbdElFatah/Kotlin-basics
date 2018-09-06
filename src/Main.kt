
fun main(args:Array<String>){

    val div =  {num:Int -> num / 2 }
    println(div(30))

    val  list = listOf(Person("Mostafa"), Person("Ali")
            , Person("AbdElFatah"), Person("Mohamed")
            , Person(" Asden"), Person(" Asd"))
    var result = list.filter { !it.name.contains(" ") }.joinToString (", "){ it.name }
    println(result)

    val game = Game()
    println(game.path)
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()
    println(game.path)

    val fish = "fishnet" to "Catch fish"
    println("$fish, ${fish.first}, ${fish.second}")
    val (tool, use) = fish
    println("$tool, $use" )
    val (tool1, use1) =  giveMeATool()
    println("$tool1, $use1" )
    println("*********************************************")
    var list = mutableListOf<Int>(1,5,10,8,9,10,22,69,14,78,9)
    println(list)
    list.add(2,20)
    println(list)
    list.remove(69)
    println(list)
    list.addAll(listOf(2,3,5,6,7))
    println(list)
    list.get(list.size - 1)
    println(list)
    list.removeAt(5)
    println(list)
    println(list.size)
    list.clear()
    println(list.size)
    println("50: ${list.contains(50)}")
    println("********************")
    var unmutList = listOf<Int>(50,20,30,40,90,80,70)
    println(unmutList.size)
    println(unmutList.get(2))
    println("50: " + unmutList.contains(50))
    println("********************")
    var map = mutableMapOf<String,Int>("one" to 1,"two" to 2 , "three" to 3)
    map.put("four",4)
    println(map)
    println(map.size)
    println( map.get("two"))
    println(map.getOrDefault("five","don't exist this number"))
    println(map.getOrElse("five"){"don't exist this number"})
    map.clear()
    println(map.size)
    map.put("four",4)
    map.put("four",4)
    map.put("four",4)
    println(map)
    map.remove("four")
    println("hello in kotlin".hasSpaces())
    println("helloInKotlin".hasSpaces())
    println(10.factorial())
}
// extension
fun Int.factorial():Int{
    var f = 1
    for (i in 2..this)
        f *= i
    return f
}
fun String.hasSpaces():Boolean{
    val found:Char? = this.find { it == ' ' }
    return found != null
}

fun giveMeATool(): Pair<String,String>{
    return ("fishnet1" to "Catch fish1")
}

data class Person (val name:String)

enum class Direction {
    NORTH, EAST, WEST, SOUTH, START, END
}

class Game {
    var path = mutableListOf<Direction>(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }
    val end = { path.add(Direction.END); println("Game Over: $path"); path.clear(); false }
}