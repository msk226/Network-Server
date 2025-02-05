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
        System.out.println("현재 서버가 " + PORT + "번 포트에서 가동중입니다. ");

        Socket socket = serverSocket.accept();
        System.out.println("클라이언트가 연결되었습니다. ");

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String messageFromClient = inputStream.readUTF();

            System.out.println("클라이언트가 입력한 메시지는 다음과 같습니다: " + messageFromClient);
            if (messageFromClient.equals("exit")) {
                break;
            }
            String processMessage = messageFromClient + "!!!";
            outputStream.writeUTF(processMessage);
        }

        System.out.println("연결을 종료합니다.");

        // 자원 정리
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
