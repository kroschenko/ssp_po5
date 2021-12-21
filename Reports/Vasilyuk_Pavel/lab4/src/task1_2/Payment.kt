
class Payment {
    private var bill = arrayListOf<Items>()

    constructor() {
        bill = arrayListOf<Items>()
    }

    fun addItem(item: Items): ArrayList<Items> {
        bill.add(item)
        return bill
    }

    fun sum(): Int = bill.sumOf { it.getPr };

    class Items {
        lateinit var itm: String
        var pr: Int = 0

        constructor(itm:String, pr: Int){
            this.itm = itm
            this.pr = pr
        }

        override fun toString(): kotlin.String {
            return "{ " +
                    "Item='" + itm + '\'' +
                    ", Price=" + pr +
                    " }";
        }

        var getItm: String
            get() = itm
            set(value) {
                itm = value
            }
        var getPr: Int
            get() =  pr
            set(value) {
                pr = value
            }
    }
}
