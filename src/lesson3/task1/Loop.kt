@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var m = n
    do {
        m /= 10
        count++
    } while (m > 0)
    return count

}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var res = 1
    var previousRes = 1
    if ((n == 1) || (n == 2)) return 1
    for (i in 3..n) {
        res += previousRes
        previousRes = res - previousRes
    }
    return res
}


/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var a = m
    var b = n
    while (a != b) {
        if (a > b) a -= b
        else b -= a
    }
    return m / a * n

}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var k = 2
    if (isPrime(n)) return n
    while (n % k != 0) k++
    return k

}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    if (isPrime(n)) return 1
    var f = n - 1
    while (n % f != 0) f--
    return f

}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var a = m
    var b = n
    while (a != b) {
        if (a > b) a -= b
        else b -= a
    }
    return a == 1

}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var g = sqrt(m.toDouble()).toInt()
    val f = sqrt(n.toDouble()).toInt()
    var a = 0
    do {
        if (((g * g) >= m) && ((g * g) <= n)) a++
        g++
    } while (g <= f)
    return a > 0

}


/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var h = x
    var count = 0
    while (h != 1) {
        count++
        if (h % 2 == 0) h /= 2
        else h = 3 * h + 1
    }
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var l = n
    val c = digitNumber(n)
    var r = 0
    for (i in c - 1 downTo 0) {
        r += (l % 10) * (10.0.pow(i)).toInt()
        l /= 10
    }
    return r

}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var c = digitNumber(n)
    val a: Number
    var b: Number
    var r = 0
    var h = c
    if (c % 2 != 0) {
        c--
        h++
    }
    a = n / 10.0.pow(h / 2).toInt()
    b = n % 10.0.pow(c / 2).toInt()
    for (i in (c / 2) - 1 downTo 0) {
        r += (b % 10) * (10.0.pow(i)).toInt()
        b /= 10
    }
    return a == r
}




/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var j: Number
    val c = digitNumber(n) - 1
    var m: Number
    var k = 0
    var p = c
    for (i in 1..c) {
        m = n % 10
        j = n / 10
        for (l in 1..p) {
            if (m != j % 10) k++
            j /= 10
        }
        n / 10
        p--
    }
    return k != 0
}




/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var c = 0
    var j = 0
    var s = 0
    var l: Number
    var i = 1
    while (s < n) {
        c = i * i
        l = c
        while (l != 0) {
            j++
            l /= 10
        }
        s += j
        j = 0
        i++
    }
    return (c / (10.0.pow(s - n)).toInt()) % 10

}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var c = 1
    var prev = 1
    var j = 0
    var s = 2
    var l: Number
    return if ((n == 1) || (n == 2)) 1
    else {
        while (s < n) {
            c += prev
            l = c
            while (l != 0) {
                j++
                l /= 10
            }
            s += j
            j = 0
            prev = c - prev
        }
        (c / (10.0.pow(s - n)).toInt()) % 10
    }
}
