fun fibonacci() {
    //Дано
    val n = 20
    var a = -10.0
    var b = -3.0
    println("Дано:\n\tf(x) = x^4+7x^3-6x^2-50x\n\tL = [$a;$b]")

    //Шаг 1
    var x1k = a + fibonacciByIndex(n) / fibonacciByIndex(n + 2)
    var x2k = a + fibonacciByIndex(n + 1) / fibonacciByIndex(n + 2) * (b - a)
    if (f(x1k) > f(x2k)) a = x1k
    else b = x2k


    //Шаг 4 или 5
    println()
    println(
        "${"N".padEnd(3)} " +
                "${"a".padEnd(14)} " +
                "${"b".padEnd(14)} " +
                "${"b-a".padEnd(14)} " +
                "${"x1".padEnd(14)} " +
                "${"x2".padEnd(14)} " +
                "${"f(x1)".padEnd(14)} " +
                "f(x2)".padEnd(14)
    )
    for ((i, k) in (1..n - 3).withIndex()) {
        println(
            "${i.toString().padEnd(3)} " +
                    "${"%.4f".format(a).padEnd(14)} " +
                    "${"%.4f".format(b).padEnd(14)} " +
                    "${"%.4f".format(b - a).padEnd(14)} " +
                    "${"%.4f".format(x1k).padEnd(14)} " +
                    "${"%.4f".format(x2k).padEnd(14)} " +
                    "${"%.4f".format(f(x1k)).padEnd(14)} " +
                    "%.4f".format(f(x2k)).padEnd(14)
        )
        x1k = a + fibonacciByIndex(n - k + 1) / fibonacciByIndex(n - k + 3) * (b - a)
        x2k = a + fibonacciByIndex(n - k + 2) / fibonacciByIndex(n - k + 3) * (b - a)
        if (f(x1k) > f(x2k)) a = x1k
        else b = x2k
    }

    println()
    println(
        "Шаг 7: Найдем значение функции в найденной точке:" +
                "\n\tx*=${(a + b) / 2}\n\tf(x*)=${f((a + b) / 2)}\n"
    )
}

fun fibonacciByIndex(index: Int): Double {
    if (index == 0) {
        return 0.0
    }

    var n0 = 0L
    var n1 = 1L
    for (i in 2 until index) {
        val n2 = n0 + n1
        n0 = n1
        n1 = n2
    }
    return n1.toDouble()
}