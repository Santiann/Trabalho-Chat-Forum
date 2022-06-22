package Socket;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) throws IOException {
		System.out.println("Cliente iniciado...");
		Socket socket = new Socket("localhost", 1234);
		// Criação do objeto socket, inserção da porta e o IP no qual o cliente se conectará;
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		// Escreve na tela uma mensagem na tela do servidor;
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// Objeto com o intuito de escutar a placa de rede;
		EscutaThread escuta = new EscutaThread(in);
		// Criação do objeto escuta que é resposavel por ficar escutando a rede e exibir no console;
		escuta.start();
		// Inicia o objeto escuta como uma thread. Enquanto o laço é executado. 
		String entrada = "";
		
		while (true) {
			entrada = JOptionPane.showInputDialog(null, "Mensagem para o servidor", "Cliente", JOptionPane.INFORMATION_MESSAGE);
			// Pergunta a usuário qual a mensagem que ele deseja enviar;
			out.println(entrada);
			// Manda para o servidor a mensagem;
			Date data = new Date();
			// Criação do objeto date;
			System.out.println("Cliente: " + entrada);
			// Mostra na tela a mensagem encaminhada
			System.out.println("Data: " + data);
			// Mostra na tela a data em que foi enviada; 
		}
	}	
}
