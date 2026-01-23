package PracticaDI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GestorDeDescuentosTest {

    @Test
    void testSinDescuento() {
        double importe = 50;
        double resultado = GestorDeDescuentos.calcularTotal(importe);
        assertEquals(50, resultado);
    }

    @Test
    void testConDescuento() {
        double importe = 150;
        double resultado = GestorDeDescuentos.calcularTotal(importe);
        assertEquals(135, resultado); // 150 - 10%
    }

    @Test
    void testImporteNegativoLanzaExcepcion() {
        double importe = -10;
        assertThrows(IllegalArgumentException.class, () -> {
            GestorDeDescuentos.calcularTotal(importe);
        });
    }
}
