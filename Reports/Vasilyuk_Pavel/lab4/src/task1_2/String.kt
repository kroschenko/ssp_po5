import kotlin.String

class Strings (private var str: String){
    private var len: Int = str.length

    fun printStr() {
        print("Value: $str, length: $len")
    }
}