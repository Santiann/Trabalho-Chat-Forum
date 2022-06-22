package Socket;

import java.io.*;
import java.util.Date;

public class EscutaThread extends Thread{
	// O código EscutaThread é uma herança do programa Thread;
	BufferedReader in;
	public EscutaThread(BufferedReader in) {
		// Criaçã do construtor que recebe o objeto IN e o coloca como global;
		this.in = in;
	}

	public void run() {
	
		String entrada;
		Date data = new Date();
		
		try {
			while ((entrada = in.readLine()) != null) {
				// Mostra na tela as mensagens recebidas;
				// Ambos, tanto o servidor quanto o cliente mostram na tela o que foi recebido. 
				// importante ressaltar que eles executam paralelamente;
				System.out.println("Recebi:" + entrada);
				System.out.println("Data: " + data);
			}
		} catch (IOException e) {}
		
		
	}
	
}
