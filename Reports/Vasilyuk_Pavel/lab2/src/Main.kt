import java.io.File
import java.io.InputStream

fun main(){
        task_1()
        task_2()
}

fun task_1(){
        val inputStream: InputStream = File("file.txt").inputStream()
        val lineList = mutableListOf<String>() //buff for file content
        var splitList = arrayListOf<List<String>>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
        lineList.forEach{splitList.add(it.split(" "))}

        println("Regular line")
        for(i in 0 until splitList.size){
                println(splitList[i])
        }

        println("Reversed line")
        for(i in 0 until splitList.size){
                println(splitList[i].reversed())
        }
}

fun task_2(){
        print("\nEnter utility: ")
        val Line:String = readLine().toString()
        val splitLine:List<String> = Line.split(" ")
        val lineList = mutableListOf<String>() //buff for file content

        var numCheck:Boolean = false
        for(it in splitLine)
        {
               if(it.matches(Regex("(\\d+)"))) numCheck = true
        } //check for numbers of lines

        when{
                splitLine.contains("tail") || Line.contains(Regex("(\\w+)\\.(\\w+)")) -> {
                        when{
                                splitLine.contains("-n") || numCheck -> {
                                        val number = Regex("(\\d+)").find(Line) //numbers of lines
                                        val filename = Regex("(\\w+)\\.(\\w+)").find(Line)

                                        if (filename != null && number != null) {
                                                val inputStream: InputStream = File(filename.value).inputStream()
                                                inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
                                                val lineNumber = lineList.count() - number.value.toInt() //line number we will start with

                                                if(lineNumber < 0){
                                                        for(it in lineList)
                                                                println(it)
                                                }
                                                else{
                                                        for(i in lineNumber until lineList.count())
                                                                println(lineList[i])
                                                }
                                        }
                                }
                                else -> {
                                        val number = 10
                                        val filename = Regex("(\\w+)\\.(\\w+)").find(Line)

                                        if (filename != null) {
                                                val inputStream: InputStream = File(filename.value).inputStream()
                                                inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
                                                val lineNumber = lineList.count() - number //line number we will start with

                                                if(lineNumber < 0){
                                                        for(it in lineList)
                                                                println(it)
                                                }
                                                else{
                                                        for(i in lineNumber until lineList.count())
                                                                println(lineList[i])
                                                }
                                        }
                                }
                        }

                }
                else -> println("Error, wrong utility!")
        }
}

//tail 12 file2.txt

