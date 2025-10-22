import java.util.Objects
import kotlin.math.sqrt

class Punto(var x: Double, var y: Double) {
    // Constructor secundario
    constructor() : this(0.0, 0.0)

    fun mover(desplazamientoX: Double, desplazamientoY: Double) {
        x += desplazamientoX
        y += desplazamientoY
    }

    // usamos la formula para calcular la distancia entre dos puntos en un plano cartesiano
    fun distancia(otro: Punto): Double {
        val distanciaX = x - otro.x
        val distanciaY = y - otro.y
        return sqrt(distanciaX * distanciaX + distanciaY * distanciaY)
    }

    operator fun plus (otro: Punto): Punto {
        return Punto(x + otro.x, y + otro.y);
    }

    operator fun minus (otro: Punto): Punto {
        return Punto(x - otro.x, y - otro.y);
    }

    // equals
    override fun equals(o: Any?): Boolean {
        if (o === null || o !is Punto) return false;
        var otroPunto: Punto = o

        return this.x == otroPunto.x && this.y == otroPunto.y
    }

    // hashcode - es recomendable usarlo en conjunto con el equals.
    override fun hashCode(): Int {
        return Objects.hash(this)
    }

    // toString
    override fun toString(): String {
        return "(x: $x, y: $y)"
    }
}
