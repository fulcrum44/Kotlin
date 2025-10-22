fun main() {
    println("Ejercicio 1: Factoriales")
    println("------------------------")
    println(factorial(5))
    println(factorial(1))
    println(factorial(25))

    println()
    println("Ejercicio 2: MCD")
    println("------------------------")
    println("El máximo común divisor de 12 y 15 es ${maximoComunDivisor(12, 15)}")
    println("El máximo común divisor de 81 y 342 es ${maximoComunDivisor(81, 342)}")

    println()
    println("Ejercicio 3: MCM")
    println("------------------------")
    println("El mínimo común múltiplo de 5 y 15 es ${minimoComunMultiplo(5, 15)}")
    println("El mínimo común múltiplo de 3 y 7 es ${minimoComunMultiplo(3, 7)}")

    println()
    println("Ejercicio 4: Nº es primo o no")
    println("------------------------")
    println("El nº 4 ${if (esPrimo(4)) "es primo" else "no es primo"}")
    println("El nº 31 ${if (esPrimo(31)) "es primo" else "no es primo"}")
    println("El nº 17 ${if (esPrimo(17)) "es primo" else "no es primo"}")
    println("El nº 20 ${if (esPrimo(20)) "es primo" else "no es primo"}")

    println()
    println("Ejercicio 5: Serie de números primos")
    println("------------------------")
    println("Lista de 4 primos: ${listaNumerosPrimos(4)}")
    println("Lista de 10 primos: ${listaNumerosPrimos(10)}")
    println("Lista de 20 primos: ${listaNumerosPrimos(20)}")

    println()
    println("Ejercicio 6: Descomposición en factores primos")
    println("------------------------")
    println("Los factores primos de 15 son: ${listadoFactoresPrimos(15)}")
    println("Los factores primos de 44 son: ${listadoFactoresPrimos(44)}")

    println()
    println("Ejercicio 7: Descomposición en factores primos")
    println("------------------------")
    println("Los factores primos de 28 son: ${arrayFactoresPrimos(28)}")
    println("Los factores primos de 56 son: ${arrayFactoresPrimos(56)}")

}

fun factorial(n : Int): Int {
    if (n <= 1) return 1 // Cuando el número recibido es 1 o menor no hay que multiplicar nada. El factorial de 1 y 0 es 1 en ambos casos.
    else return n * factorial(n-1) // Multiplicamos en recursividad hasta que n sea 1.
}

fun maximoComunDivisor(n1 : Int, n2 : Int): Int {
    var numeroMayor = if (n1 > n2) n1 else n2
    var numeroMenor = if (numeroMayor == n1) n2 else n1

    if (numeroMenor == 0) return numeroMayor
    else return maximoComunDivisor(numeroMenor, numeroMayor%numeroMenor)
}

fun minimoComunMultiplo(n1 : Int, n2 : Int): Int {
    return (n1*n2)/maximoComunDivisor(n1, n2)
}

fun esPrimo(n : Int): Boolean {
    if (n == 1) return false // El 1 no se considera primo
    if (n == 2 && n == 3) return true // El 2 y 3 son primos

    var divisor = 2 // El divisor empezará en 2 porque, lógicamente, cualquier número es divisible por 1

    while (divisor != n) { // Si la condición del bucle llegase al punto de no cumplirse quiere decir que no se ha encontrado ningún divisor que no sea el 1 ni el propio número. Entonces, es primo el número
        if (n%divisor == 0) return false

        divisor++
    }

    return true
}

fun listaNumerosPrimos(n : Int): List<Int> {
    var contador = 1
    var primosEncontrados = 0

    var primos = mutableListOf<Int>()

    while (primosEncontrados != n) {
        if (esPrimo(contador)) {
            primos.add(contador)
            primosEncontrados++
        }

        if (primosEncontrados >= 2 && contador == 3) contador+=2 // El 1 y el 2 son números primos. A partir del 3, todos los pares que vengan no serán primos ya que todos serán divisibles al menos entre 2. Solo comprobaremos los impares entonces.
        else contador++
    }

    return primos
}

fun listadoFactoresPrimos(n: Int): List<Int> {
    var factoresPrimos = mutableListOf<Int>();
    var numero = n

    // Dividimos entre 2 si se puede y hasta que se pueda
    while (numero%2==0) {
        factoresPrimos.add(2)
        numero/=2;
    }

    // Probamos dividir entre 3 y los siguientes primos hasta la raíz cuadrada del número. Si dividiesemos entre un número mayor que el de la raíz cuadrada nos saldría un número decimal y no queremos eso
    var i=3

    while (i*i <= numero) { // i*i es otra manera de hacer una raíz cuadrada de num
        while (!esPrimo(i)) i+=2 // Al final del bucle se aumenta dos unidades la variable i. Quizás el siguiente valor de i no es primo, valor que no nos interesaría usar para descomponer. Nos lo saltamos automáticamente pasando al siguiete impar hasta encontrar el próximo primo

        while (numero%i==0) {
            factoresPrimos.add(i)
            numero/=i
        }

        i+=2
    }

    // Llegados a este punto puede ser que nos quede un número mayor que dos que no pueda dividirse nada más que consigo mismo. Añadimos ese número a la lista, lógicamente.
    if (numero > 2) factoresPrimos.add(numero)

    return factoresPrimos
}

fun arrayFactoresPrimos(n: Int): Array<Int> {
    var factoresPrimos
    var numero = n

    // Dividimos entre 2 si se puede y hasta que se pueda
    while (numero%2==0) {
        factoresPrimos.set(-1, 2)
        numero/=2;
    }

    // Probamos dividir entre 3 y los siguientes primos hasta la raíz cuadrada del número. Si dividiesemos entre un número mayor que el de la raíz cuadrada nos saldría un número decimal y no queremos eso
    var i=3

    while (i*i <= numero) { // i*i es otra manera de hacer una raíz cuadrada de num
        while (!esPrimo(i)) i+=2 // Al final del bucle se aumenta dos unidades la variable i. Quizás el siguiente valor de i no es primo, valor que no nos interesaría usar para descomponer. Nos lo saltamos automáticamente pasando al siguiete impar hasta encontrar el próximo primo

        while (numero%i==0) {
            factoresPrimos.set(-1, i)
            numero/=i
        }

        i+=2
    }

    // Llegados a este punto puede ser que nos quede un número mayor que dos que no pueda dividirse nada más que consigo mismo. Añadimos ese número a la lista, lógicamente.
    if (numero > 2) factoresPrimos.set(-1, i)

    return factoresPrimos
}