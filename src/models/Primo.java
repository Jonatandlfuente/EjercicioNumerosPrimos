package models;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Primo extends Thread {

	public int totalDePrimos;
	public String nombre;
	public int rangoInicial;
	public int rangoFinal;

	// Constructor con los rangos que recorrerá la lógica del hilo
	public Primo(int rangoInicial, int rangoFinal) {
		super();
		this.rangoInicial = rangoInicial;
		this.rangoFinal = rangoFinal;
	}

	public int getTotalDePrimos() {
		return totalDePrimos;
	}

	public void setTotalDePrimos(int totalDePrimos) {
		this.totalDePrimos = totalDePrimos;
	}

	@Override
	public void run() {
		int aux = 0;
		// la lógica del hilo nos verifica si un número es primo entre dos rangos
		for (int i = rangoInicial; i <= rangoFinal; i++) {
			verificarPrimo(i);
		}
	}

	/*
	 * Método que verifica si un número es primo y si lo es lo muestra por pantalla,
	 * devuelve un booleano que utilizaremos para contar el número de primos
	 */
	public static void verificarPrimo(int numeroPrimo) {
		boolean primo = false;

		BigInteger bigInteger = new BigInteger(String.valueOf(numeroPrimo));
		primo = bigInteger.isProbablePrime(numeroPrimo);
		if (primo != false) {
			/*
			 * Prueba para contar el número de primos, no funciona
			 * Primo.setTotalDePrimos(Primo.getTotalDePrimos()+1)
			 */
			System.out.println(numeroPrimo);
		}
	}
}
