package views;

import java.util.Scanner;

public class Formulario {

	/*
	 * Formulario para que el usuario especifique el n�mero de hilos con los que
	 * quiere ejecutar el programa
	 */
	public int miFormulario() {
		int hilos = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el n�mero de hilos:");
		hilos = teclado.nextInt();
		return hilos;
	}
}
