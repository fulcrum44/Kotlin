import org.izv.jcl.implementandoclases.Punto

fun main() {

    var p1 = Punto(7.00, 568.00)
    var p2 = Punto(37.00, 60.00)

    // Probamos mover los puntos
    p1.mover(4.00, 18.00)
    p2.mover(52.00, 208.00)

    println("Localización del punto 1: ${p1}")
    println("Localización del punto 2: ${p2}")

    println("")

    // Calculamos distancia entre puntos
    println("La distancia entre p1 y p2 es: ${String.format("%.2f", p1.distancia(p2))}")
    println("La distancia entre p2 y p1 es: ${String.format("%.2f", p2.distancia(p1))}")

    println("")

    // Sumamos/restamos puntos
    var p3: Punto = p1 + p2
    var p4 = p1 - p2

    println("p3 -> ${p3} es la suma de p1 -> ${p1} y p2 -> ${p2}")
    println("p4 -> ${p4} es la resta de p1 -> ${p1} y p2 -> ${p2}")

    // Probamos el equals
    var p5 = p2

    println("")

    println("p5 -> ${p5} | p2 -> ${p2}")
    if (p5.equals(p2)) println("Son iguales")
    else println("No son iguales")

    println("")

    println("p3 -> ${p3} | p1 -> ${p1}")
    if (p3.equals(p1)) println("Son iguales")
    else println("No son iguales")
}