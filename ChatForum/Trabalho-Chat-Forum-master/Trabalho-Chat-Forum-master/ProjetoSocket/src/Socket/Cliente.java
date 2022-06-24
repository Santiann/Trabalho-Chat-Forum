package Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) throws IOException, JSONException {
		System.out.println("Cliente iniciado...");
		Socket socket = new Socket("192.168.1.109", 1235);
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		EscutaThread escuta = new EscutaThread(dataInputStream);
		escuta.start();
		Scanner scanner = new Scanner(System.in);
		
		while (socket.isConnected()) {
			
			String mensagem = scanner.nextLine();
			
			JSONObject objeto = new JSONObject();
			objeto.put("Identificador", "RafaelChato");
			objeto.put("Mensagem", mensagem);
			objeto.put("Data", "23/06/2022 20:20");
			dataOutputStream.writeUTF(objeto.toString());			
		}
	}	
}
