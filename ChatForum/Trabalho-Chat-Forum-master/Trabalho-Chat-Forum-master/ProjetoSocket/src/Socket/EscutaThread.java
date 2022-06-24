package Socket;

import java.io.*;
import org.json.JSONException;
import org.json.JSONObject;

public class EscutaThread extends Thread{
	DataInputStream in;
	public EscutaThread(DataInputStream in) {
		this.in = in;
	}

	public void run() {
	
		String entrada;
		
		try {
			while (true) {
				JSONObject JSONObject = new JSONObject(in.readUTF());
				System.out.print((JSONObject.getString("Identificador")+':'));
				System.out.print(JSONObject.getString("Mensagem")+' ');
				System.out.println(JSONObject.getString("Data"));
				
			}
		} catch (IOException | JSONException e) {}
		
		
	}
	
}
