fun main(){
    val complexFile = "backup.2024.04.15.tar.gz"
    val simpleName = complexFile.substringBefore(".")
    val lastExt = complexFile.substringAfterLast(".")
    println("$complexFile → name: $simpleName, ext: $lastExt")
}
