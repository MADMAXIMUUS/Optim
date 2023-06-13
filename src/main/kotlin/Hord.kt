import kotlin.math.abs

fun hord() {
    //Дано
    val eps = 0.0025 //Точность
    var a = -10.0
    var b = -3.0
    println("Дано:\n\tf(x) = x^4+7x^3-6x^2-50x\n\tL = [$a;$b]\n\tε = $eps")

    println()

    println("Шаг 1: Проверяем начальное условие")
    println("\tdfDx($a) = ${dfDx(a)}")
    println("\tdfDx($b) = ${dfDx(b)}")
    val c = dfDx(a) * dfDx(b)
    println("\tdfDx($a)*dfDx($b) = $c")
    if (c > 0) {
        println("\tФункция имеет одинаковые знаки на концах отрезка")
        return
    }
    println("\tУсловие выполнилось")

    println()

    println("Шаг 2: Положим начало цикла k = 0")
    var k = 0

    println()

    println("Шаг 3: Вычислим новую точку x1")
    val x1 = a - dfDx(a) / (dfDx(a) - dfDx(b)) * (a - b)
    println("\tx1 = ${"%.4f".format(x1)}")

    println()

    println("Шаг 4: Проверим условие окончания")
    val d = dfDx(x1)
    println("\tdfDx(${"%.4f".format(x1)}) = ${"%.4f".format(d)}")
    if (d < eps) {
        println("\tИскомая точка найдена")
        println()
        println(
            "Шаг 6: Найдем значение функции в найденной точке:" +
                    "\n\tx*=${"%.4f".format(x1)}\n\tf(x*)=${"%.3f".format(f(x1))}"
        )
        return
    }
    println("\tИскомая точка не найдена")

    println()

    println("Шаг 5: Переходим к следуюшему шагу")
    if (d > 0) {
        println("\tdfDx(${"%.4f".format(x1)}) > 0 => b = x1")
        b = x1
    } else {
        println("\tdfDx(${"%.4f".format(x1)}) < 0 => a = x1")
        a = x1
    }

    println()

    var xk = x1

    println(
        "${"N".padEnd(3)}${"a".padEnd(14)}${"b".padEnd(14)}" +
                "${"x".padEnd(14)}${"dfDf(x)".padEnd(14)}"
    )
    while (abs(dfDx(xk)) > eps) {
        println(
            "${k.toString().padEnd(3)}${"%.4f".format(a).padEnd(14)}" +
                    "${"%.4f".format(b).padEnd(14)}${"%.4f".format(xk).padEnd(14)}" +
                    "%.4f".format(dfDx(xk)).padEnd(14)
        )
        xk = a - (dfDx(a) / (dfDx(a) - dfDx(b))) * (a - b)
        if (dfDx(xk) > 0) b = xk
        else a = xk
        k++
    }
    println(
        "${k.toString().padEnd(3)}${"%.4f".format(a).padEnd(14)}" +
                "${"%.4f".format(b).padEnd(14)}${"%.4f".format(xk).padEnd(14)}" +
                "%.4f".format(dfDx(xk)).padEnd(14)
    )

    println()
    println("f'(x$k) = ${dfDx(xk)}")
    println("|f'(x$k)|<$eps => нашли искомую точку")

    println()
    println(
        "Шаг 6: Найдем значение функции в найденной точке:" +
                "\n\tx*=${xk}\n\tf(x*)=${f(xk)}\n"
    )
}