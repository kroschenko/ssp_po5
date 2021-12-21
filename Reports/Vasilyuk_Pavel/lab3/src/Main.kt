@file:JvmName("main")

package org.example.main

import java.io.File
import java.io.InputStream

public class Prog() {
    fun trng() {
        val triangle = Triangle()
        triangle.setTriangle(3.0, 3.0, 3.0)

        val triangle2: Triangle = Triangle(3.0, 3.0, 3.0)

        val triangle3: Triangle = Triangle()
        triangle3.Side1 = 5.0
        triangle3.Side2 = 5.0
        triangle3.Side3 = 5.0

        val triangles = arrayOf(triangle, triangle2, triangle3)
        for (i in triangles.indices) {
            println("Triangle " + (i + 1) + ": " + triangles[i])
            if (triangles[0].isRectangular()) println("Triangle " + (i + 1) + " - equilateral") else println("Triangle " + (i + 1) + " - inequilateral")
            println("Perimeter of a triangle " + (i + 1) + ": " + triangles[i].perimeter())
            System.out.format("Square of a triangle %d: %.3f \n", i + 1, triangles[i].square())
        }
        if (triangle.equals(triangle2)) println("Triangles 1 and 2 - equals") else println("Triangles 1 and 2 - not equals")
        println("\n\n")
    }

    fun veh() {
        val inputStream: InputStream = File("file.txt").inputStream()
        val lineList = mutableListOf<String>()
        var splitList = arrayListOf<List<String>>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
        lineList.forEach{splitList.add(it.split("\t|"))}

        var veh = arrayListOf<Vehicles>()


            for(i in 0 until splitList.size){
                if(splitList[i].size < 9){
                    veh.add(Vehicles(splitList[i][0].toInt(), splitList[i][3].toInt(), splitList[i][5].toInt(), splitList[i][6].toInt(),
                                     splitList[i][7].toInt(), splitList[i][1], splitList[i][2], splitList[i][4]))
                } else {
                    veh.add(Vehicles(splitList[i][0].toInt(), splitList[i][3].toInt(), splitList[i][5].toInt(), splitList[i][6].toInt(),
                                     splitList[i][7].toInt(), splitList[i][1], splitList[i][2], splitList[i][4], splitList[i][8], splitList[i][9]))
                    }
        }

        println("List of vehicles:")
        for(j in 0 until splitList.size){
            veh[j].print()
        }

        println("\nList of vehicles (brand - BMW):")
        for(j in 0 until splitList.size){
            if(veh[j].getBrand.contains("BMW"))
                veh[j].print()
        }

        println("\nList of vehicles (brand - Mercedes, exploitation - 10 years)")
        for(j in 0 until splitList.size){
            if(veh[j].getBrand.contains("Mercedes") && (2021 - veh[j].getYeOfIss) > 10 )
                veh[j].print()
        }

        println("\nList of vehicles (year of issue - 2015, price - 10000)")
        for(j in 0 until splitList.size){
            if(veh[j].getYeOfIss == 2015 && veh[j].getPrice > 10000 )
                veh[j].print()
        }

        println("\nList of vehicles (rented)")
        for(j in 0 until splitList.size){
            if(veh[j].getFIO != "none" && veh[j].getPassNum != "none")
                veh[j].print()
        }
    }
}

fun main() {
    Prog().trng()
    Prog().veh()
}