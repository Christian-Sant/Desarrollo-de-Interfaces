// Gestión diferenciada de distintos tipos de excepciones
package primero;

public class ExcepcionesDiversas {
    public static void main(String[] args) {
        // Rellenar array con números variados
        int[][] nums = new int[2][3]; // Corrected array declaration

        // Populate the array with some values
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = i + j; // Example of filling the array
            }
        }

        // Realizar cálculo para cada posición del array.
        // Se producen excepciones de diversos tipos.
        for (int i = 0; i < 2; i++) { // Corrected loop condition
            for (int j = 0; j < 3; j++) {
                try {
                    System.out.print("Segunda cifra de 5 * nums[" + i + "][" + j + "] / " + j + ": ");
                    System.out.println(String.valueOf(5 * nums[i][j] / j).charAt(1));
                } catch (ArithmeticException e) {
                    System.out.println("ERROR: aritmético 5 * " + nums[i][j] + " / " + j);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("ERROR: No existe nums[" + i + "][" + j + "]");
                } catch (Exception e) {
                    System.out.println("ERROR: de otro tipo al calcular segunda cifra de: 5 * " + nums[i][j] + " / " + j);
                    e.printStackTrace(); // Print stack trace for debugging
                }
            }
        }
    }
}