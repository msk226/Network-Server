package v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final Integer PORT = 11111;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        Socket socket = serverSocket.accept();

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String messageFromClient = inputStream.readUTF();
            if (messageFromClient.equals("exit")) {
                break;
            }
            String processMessage = messageFromClient + "!!!";
            outputStream.writeUTF(processMessage);
        }
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
