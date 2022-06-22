package Socket;

import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.Date;

public class Servidor {

	public static void main(String[] args) throws IOException {
		System.out.println("Servidor iniciado ...");
		ServerSocket socketServidor = new ServerSocket(1234);
		// Criação do objeto server socket e a inserção da porta;
		Socket socketCliente = socketServidor.accept();
		// O servidor fica escutando a porta "1234", assim que um cliente 
		// com a mesma porta acessa ele libera. Caso a porta seja diferente, o acesso é negado.
		PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
		// Escreve na tela uma mensagem na tela do client
		BufferedReader in = new BufferedReader (new InputStreamReader(socketCliente.getInputStream()));
		// Objeto com o intuito de escutar a placa de rede
		EscutaThread escuta = new EscutaThread(in);
		// Criação do objeto escuta que é resposavel por ficar escutando a rede e exibir no console;
		escuta.start();
		// Inicia o objeto escuta como uma thread. Enquanto o laço é executado. 
		String entrada;
		while (true) {
			entrada = JOptionPane.showInputDialog(null, "Mensagem para o cliente", "Servidor", JOptionPane.INFORMATION_MESSAGE);
			// Mostra na tela a mensagem para usuário escrever a mensagem
			Date data = new Date();
			// Cria o objeto date
			System.out.println("Servidor: " + entrada);
			// Mostra na tela a mensagem do servidor para o client
			System.out.println("Data: " + data);
			// Mostra a data que foi enviada a mensagem
			out.println(entrada);
			// Mostra na tela do client a mensagem enviada
		}

	}

}
