package org.example.main

class Vehicles {
    private var id: Int = 0
    private var yearIss: Int = 0
    private var pr: Int = 0
    private var regNum: Int = 0
    private var carNum: Int = 0
    private lateinit var pasNum: String
    private lateinit var brand: String
    private lateinit var mod: String
    private lateinit var col: String
    private lateinit var fio: String


    constructor(id: Int, yearIss: Int, pr: Int, regNum: Int, carNum: Int,
                brand: String, mod: String, col: String, fio: String = "none", pasNum: String = "none") {
        this.id =      id
        this.yearIss = yearIss
        this.pr =      pr
        this.regNum =  regNum
        this.carNum =  carNum
        this.pasNum =  pasNum
        this.brand =   brand
        this.mod =     mod
        this.col =     col
        this.fio =     fio
    }

    constructor(){ }

    var getBrand: String
        get() = brand
        set(value) {
            brand = value
        }
    var getYeOfIss: Int
        get() = yearIss
        set(value) {
            yearIss = value
        }
    var getPrice: Int
        get() = pr
        set(value) {
            pr = value
        }
    var getFIO: String
        get() = fio
        set(value) {
            fio = value
        }

    var getPassNum: String
        get() = pasNum
        set(value) {
            pasNum = value
        }
    override fun toString(): String {
        return  "Vehicle{" +
                "Id='" + id + '\'' +
                ", Brand='" + brand + '\'' +
                ", Model='" + mod + '\'' +
                ", Year of Issue='" + yearIss + '\'' +
                ", Color=" + col +
                ", Price=" + pr +
                ", Registration Number='" + regNum + '\'' +
                ", Car Number='" + carNum + '\'' +
                ", FIO='" + fio + '\'' +
                ", Passport Number='" + pasNum + '\'' +
                '}'
    }

    fun print() {
        println(this.toString())
    }

}