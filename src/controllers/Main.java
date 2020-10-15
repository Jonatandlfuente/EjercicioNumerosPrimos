package controllers;

import java.math.BigInteger;

import models.Primo;
import views.Formulario;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// Calcular los numeros primos del 1:100000 pedir al usuario por pantalla el
		// número de hilos que quieren que intervengan

		System.out.println("Hilo principal iniciando.");
		int numHilos = 0;
		Formulario nuevoFormulario = new Formulario();
		numHilos = nuevoFormulario.miFormulario();
		int rangoInicial = 0;
		int rangoFinal = 0;
		int ultimoNumero = 100;
		// Para cada hilo irá calculando los rangos en los que tiene que operar la
		// lógica del hilo
		long startTime = 0;
		long estimatedTime = 0;
		long totalTime = 0;
		int aux = 0;
		int auxTotal = 0;
		Primo primo;
		// Iniciamos el contador en nano segundos
		startTime = System.nanoTime();/* Si lo queremos en milisegundos: System.currentTimeMillis(); */
		for (int i = 1; i <= numHilos; i++) {
			aux = 0;
			rangoInicial = (ultimoNumero / numHilos) * (i - 1);
			// Como las particiones no son exactas, para que el último rango de números vaya
			// hasta el final
			if (i == numHilos) {
				rangoFinal = ultimoNumero;
			} else {
				rangoFinal = ((ultimoNumero / numHilos) * (i));
			}
			// Para que comience el rango desde el 1 y no desde 0
			if (i == 1) {
				rangoInicial = 1;
			} else {
				rangoFinal = ((ultimoNumero / numHilos) * (i));
			}
			// Mostramos por pantalla los rangos
			System.out.println("empieza en: " + rangoInicial + " y acaba en: " + rangoFinal);
			// Instanciamos usando los rangos en el constructor
			primo = new Primo(rangoInicial, rangoFinal);
			// Mostramos la Id del hilo
			System.out.println("La id del hilo " + i + " es: " + primo.getId());
			// Iniciamos el hilo
			primo.start();
			//Esperamos a que el hilo que termine espere al hilo siguiente
			primo.join();
			//Recogemos el número de primos totales
			aux = primo.getTotalDePrimos();
			// Recogemos el dato del reloj
			estimatedTime = System.nanoTime() - startTime;
			// Calculamos el tiempo total en una variable acumulativa y el total de primos
			totalTime = totalTime + estimatedTime;
			auxTotal = auxTotal + aux;
		}
		// Mostramos el tiempo total de ejecución
		System.out.println("El tiempo total de ejecución es: " + totalTime + " nano segundos con " + numHilos + " hilos");
		// Mostramos el total de primos
		System.out.println("El numero total de primos es: " + auxTotal);
	}
}
