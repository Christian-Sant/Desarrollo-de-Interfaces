package GestiondeBiblioteca;

import java.util.Scanner;
//CHRISTIAN JAY LAGO
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		int opcion = -1;
		do {
			System.out.println("---Biblioteca---");
			System.out.println("0. Salir");
			System.out.println("1. Guardar Libro");
			System.out.println("2. Cargar Biblioteca");
			System.out.println("3. Consultar Libro");
			System.out.println("4. Modificar precio del Libro");
			System.out.println("5. Eliminar Libro");
			System.out.println("6. Listar Libro");
			System.out.print("Opcion: ");
			opcion = sc.nextInt();
			switch(opcion) {
			case 0 : 
				System.exit(0);
				break;
			case 1 :
					biblioteca.cargarLibros();
					biblioteca.guardarLibros(sc);
					break;
			case 2 :
				biblioteca.cargarLibros();
				biblioteca.constructor();
				break;
			case 3 :
				biblioteca.cargarLibros();
				biblioteca.consultarLibro(sc);
				break;
			case 4 :
				biblioteca.cargarLibros();
				biblioteca.modificarPrecio(sc);
				break;
			case 5 :
				biblioteca.cargarLibros();
				biblioteca.eliminarLibro(sc);
				break;
			case 6 :
				biblioteca.cargarLibros();
				biblioteca.listarLibro();
				break;
			default :
				System.out.println("Opcion no valida.\n");
			}
				
		}
		while(opcion != 0);
			
	}
}
