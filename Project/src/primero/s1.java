package primero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class s1 {
    public static void main(String[] args) {
        // Crear y llenar un ArrayList
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);

        // Usar Stream para filtrar y transformar
        List<Integer> resultado = numeros.stream()
            .filter(n -> n > 2)           // mantener mayores que 2
            .map(n -> n * 2)              // multiplicar por 2
            .collect(Collectors.toList()); // convertir a lista

        System.out.println(resultado); // Imprime: [6, 8, 10]
    }
}   