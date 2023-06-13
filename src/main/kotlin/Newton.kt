import kotlin.math.abs

fun newton() {
    //Дано
    val eps = 0.0025 //Точность
    val a = -10.0
    val b = -3.0
    println("Дано:\n\tf(x) = x^4+7x^3-6x^2-50x\n\tL = [$a;$b]\n\tε = $eps")

    println()

    println("Шаг 1: Выбираем начальное приближение")
    val x0 = if (f(a) * d2fDx2(a) > 0) {
        println("\t${f(a)} * ${d2fDx2(a)} > 0 => x0 = a = $a")
        a
    } else {
        println("\t${f(a)} * ${d2fDx2(a)} < 0 => x0 = b = $b")
        b
    }

    println()

    var xk = x0
    var k = 0
    println("Шаг 2: Задаем начало итерационного цикла\n\tk = $k")

    println()

    println("Шаг 3: Найдем новое значение x1\n\tx1 = $x0 - ${dfDx(x0)} / ${d2fDx2(x0)}")
    val x1 = x0 - dfDx(x0) / d2fDx2(x0)
    println("\tx1 = $x1")

    println()

    println("Шаг 4: Проверим окончание цикла\n\t|f'(x1)|>ε")
    if (abs(x1)>eps) println("\t|${"%.4f".format(dfDx(abs(dfDx(x1))))}|>$eps => продолжаем вычисления")
    else println("\t|${abs(dfDx(x1))}|<$eps => мы нашли искомую точку")

    println()

    println("Сведем все вычисления в таблицу")

    println("${"N".padEnd(3)}${"x".padEnd(14)}" +
            "${"dfDf(x)".padEnd(14)}${"d2fDx2(x)".padEnd(14)}")
    while (abs(dfDx(xk)) > eps) {
        println("${k.toString().padEnd(3)}${"%.4f".format(xk).padEnd(14)}" +
                "${"%.4f".format(dfDx(xk)).padEnd(14)}${"%.4f".format(d2fDx2(xk)).padEnd(14)}")
        xk -= dfDx(xk) / d2fDx2(xk)
        k++
    }
    println("${k.toString().padEnd(3)}${"%.4f".format(xk).padEnd(14)}" +
            "${"%.4f".format(dfDx(xk)).padEnd(14)}${"%.4f".format(d2fDx2(xk)).padEnd(14)}")

    println()
    println("f'(x$k) = ${dfDx(xk)}")
    println("|f'(x$k)|<$eps => нашли искомую точку")

    println()
    println("Шаг 5: Найдем значение функции в найденной точке:" +
            "\n\tx*=${xk}\n\tf(x*)=${f(xk)}\n")
}