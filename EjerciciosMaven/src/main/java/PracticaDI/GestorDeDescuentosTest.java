package PracticaDI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GestorDeDescuentosTest {

    @Test
    void compraInferiorA100_NoTieneDescuento() {
        double importe = 50;
        double resultado = GestorDeDescuentos.calcularPrecioFinal(importe);
        assertEquals(50, resultado);
    }

    @Test
    void compraSuperiorA100_TieneDescuentoDel10() {
        double importe = 150;
        double resultado = GestorDeDescuentos.calcularPrecioFinal(importe);
        assertEquals(135, resultado);
    }

    @Test
    void compraNegativa_LanzaExcepcion() {
        double importe = -20;
        assertThrows(IllegalArgumentException.class, () -> {
            GestorDeDescuentos.calcularPrecioFinal(importe);
        });
    }
}
