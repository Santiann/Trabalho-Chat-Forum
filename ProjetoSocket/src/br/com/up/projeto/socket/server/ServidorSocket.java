package br.com.up.projeto.socket.server;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class ServidorSocket {

    public void listenClients() throws Exception{

        ServerSocket serverSocket = new ServerSocket(1234) ;

        Socket socket = serverSocket.accept();

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        while(socket.isConnected()){

            String message = IOUtils.toString(socket.getInputStream(), "UTF-8");
            System.out.println(message);

            output.writeUTF("Olá cliente");
            output.flush();
            
           
        }

        socket.close();
    }
}
