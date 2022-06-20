package br.com.up.projeto.socket.client;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class ClienteSocket {

    public void conectarServidor() throws Exception{

        String ipHost = "Inserir o ip aqui";
        Socket socket = new Socket(ipHost, 1234);
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        while(socket.isConnected()){

            output.writeUTF("Olá Servidor");
            output.flush();
            
            String message = IOUtils.toString(socket.getInputStream(), "UTF-8");
            System.out.println(message);
        }

        socket.close();
    }
}
