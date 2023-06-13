import kotlin.math.pow

fun main() {
    println(
        "Выберите метод:" +
                "\n\t1 - Метод Ньютона" +
                "\n\t2 - Метод Хорд" +
                "\n\t3 - Метод Фибоначчи" +
                "\n\t0 - Выход" +
                "\nВвод: "
    )
    var c = readln().toInt()
    while (c != 0) {
        when (c) {
            1 -> newton()
            2 -> hord()
            3 -> fibonacci()
        }
        println(
            "Выберите метод:" +
                    "\n\t1 - Метод Ньютона" +
                    "\n\t2 - Метод Хорд" +
                    "\n\t3 - Метод Фибоначчи" +
                    "\n\t0 - Выход" +
                    "\nВвод: "
        )
        c = readln().toInt()
    }
}

fun f(x: Double) = x.pow(4) + 7 * x.pow(3) - 6 * x.pow(2) - 50 * x

fun dfDx(x: Double) = 4 * x.pow(3) + 21 * x.pow(2) - 12 * x - 50

fun d2fDx2(x: Double) = 12 * x.pow(2) + 42 * x - 12