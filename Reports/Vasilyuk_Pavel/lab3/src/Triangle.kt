package org.example.main

import kotlin.math.pow

public class Triangle {
    private var side1: Double = 0.0
    private var side2: Double = 0.0
    private var side3: Double = 0.0


    constructor(side_1: Double, side_2: Double, side_3: Double)
    {
        this.side1 = side_1
        this.side2 = side_2
        this.side3 = side_3
    }

    constructor()
    {
        this.side1 = 0.0
        this.side2 = 0.0
        this.side3 = 0.0
    }

    public fun setTriangle(side_1: Double, side_2: Double, side_3: Double)
    {
        this.side1 = side_1
        this.side2 = side_2
        this.side3 = side_3
    }

    public fun square(): Double
    {
        return (3.0.pow(1.0/2.0) / 4 * side1.pow(2.0))
    }

    public fun perimeter(): Double
    {
        return side1 * 3
    }

    public fun isRectangular(): Boolean {
        return (side1 == side2 && side2 == side3)
    }

    var Side1: Double?
        get() = side1;
        set(value) {
            if (value != null) {
                side1 = value
            }
        }

    var Side2: Double?
        get() = side2;
        set(value) {
            if (value != null) {
                side2 = value
            }
        }

    var Side3: Double?
        get() = side3;
        set(value) {
            if (value != null) {
                side3 = value
            }
        }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val triangle: Triangle = o as Triangle
        return side1.equals(triangle.side1) && side2.equals(triangle.side2) && side3.equals(triangle.side3)
    }

    override fun toString(): String
    {
        return "sides = $side1, $side2, $side3"
    }
}