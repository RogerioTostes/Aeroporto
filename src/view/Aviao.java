package view;

import java.util.concurrent.Semaphore;
import controller.controle;


public class Aviao {
	public static void main(String[] args) {
		int permissao = 1;
		Semaphore Um = new Semaphore (permissao);
		Semaphore dois = new Semaphore(permissao);
		for (int i = 0; i < 12; i ++){
			Thread t = new controle (i, Um, dois);
			t.start();
		}
		
	}

}
