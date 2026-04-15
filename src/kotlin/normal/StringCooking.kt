// nấu "string"
fun main()
{
  val filename = "realmg.kt"
  val name = filename.substringBefore(".") // expected result: "realmg"
  val extension = filename.substringAfter(".") // expected result: "kt"
  println("$filename info: $name, extension: $extension")
}
