fun main() {
    task_1()

    var numbers:Array<Double> = Array(6, {(0..10).random().toDouble()})
    reverse(numbers)

    if(polindrome("А лис, он умён - крыса сыр к нему носила."))println("Строка является палиндромом!")
    else println("Строка НЕ является палиндромом!")
}

fun task_1(){
    var N:Int = 5
    var i = 1;
    var sq = Array(N, {i++ * 2})

    for(el in sq){
        print("${el} ")
    }
    println()
    println("Min number: ${sq.minOrNull()}, max number: ${sq.maxOrNull()}")
    println("Sum: ${sq.sum()} \n")
}

fun reverse(arr:Array<Double>){
    print("Regular array:   ")
    for(el in arr){
        print("${el}  ")
    }
    println();

    var buff:Double
    var i = 0
    var j = arr.count()-1

    for(i in arr.indices){
        if(i > (arr.count()-1)/2){ break }

        buff = arr[i]
        arr[i] = arr[j]
        arr[j] = buff
        j--
    }

    print("Reversed array:  ")
    for(el in arr){
        print("${el}  ");
    }
    println("\n")
}

fun polindrome(str:String):Boolean{
    var replace = str.replace(Regex("[^а-яА-ЯёЁ]"),"")
    var string = replace.replace(Regex("[ёЁ]"),"е")
    var lowerStr = string.lowercase()

    return when (lowerStr) {
        lowerStr.reversed() -> true
        else -> false
    }
}