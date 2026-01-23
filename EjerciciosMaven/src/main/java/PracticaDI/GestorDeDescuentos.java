package PracticaDI;

import java.util.Scanner;

public class GestorDeDescuentos {
	public static double calcularPrecioFinal(double precioBase) {
		
		if (precioBase < 0) {
		throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		// Posible error lógico aquí: el requisito dice > 100, pero el código dice > 150
		if (precioBase > 150) {
		return precioBase * 0.90; // 10% descuento
		}
		return precioBase;
	}
}
