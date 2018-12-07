
package controller;
import java.util.concurrent.Semaphore;

public class controle extends Thread {

	private int idThread;
	private Semaphore Um;
	private Semaphore dois;

	public controle(int idThread, Semaphore Um, Semaphore dois) {

		this.idThread = idThread;
		this.Um = Um;
		this.dois = dois;
	}

	public void run() {

		manobra();
		taxiar();
		if (idThread % 2 == 0) {
			try {
				Um.acquire();
				decolar_afastar_Um();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				Um.release();
			}
		} else {
			try {
				dois.acquire();
				decolar_afastar_dois();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				dois.release();
			}
		}
	}

	private void manobra() {
		System.out.println("O aviao #" + idThread + " esta manobrando");
		int tempo = (int) ((Math.random() * 5) + 3);

		try {
			Thread.sleep(tempo * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idThread + " terminou de manobrar");
	}

	private void taxiar() {
		System.out.println("O aviao #" + idThread + " esta taxiando");
		int tempo = (int) ((Math.random() * 6) + 5);

		try {
			Thread.sleep(tempo * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idThread + " terminou de taxiar");
	}

	private void decolar_afastar_Um() {
		System.out.println("O aviao #" + idThread
				+ " esta decolando na pista Um");
		int tempoD = (int) ((Math.random() * 5) + 1);
		try {
			Thread.sleep(tempoD * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idThread + " decolou na pista Um");
		System.out.println("O aviao #" + idThread
				+ " esta se afastando na pista Um");
		int tempoA = (int) ((Math.random() * 6) + 3);
		try {
			Thread.sleep(tempoA * 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idThread
				+ " se afastou na pista Um");
	}

	private void decolar_afastar_dois() {
		System.out.println("O aviao #" + idThread + " decolando na pista dois");
		int tempoD = (int) ((Math.random() * 5) + 1);
		try {
			Thread.sleep(tempoD * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idThread + " decolou na pista dois");
		System.out.println("O aviao #" + idThread + " esta se afastando da pista dois");
		int tempoA = (int) ((Math.random() * 6) + 3);
		try {
			Thread.sleep(tempoA * 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idThread + " se afastou da pista dois");
	}
}
