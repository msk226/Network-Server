import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final Integer PORT = 11111;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("현재 서버가 " + PORT + "번 포트에서 가동중입니다. ");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress() + ":" + socket.getPort() + "에서 클라이언트가 연결되었습니다.");

            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}
