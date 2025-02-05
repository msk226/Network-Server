import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // try-with-resources
        try (DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())){

            while (true) {
                String messageFromClient = inputStream.readUTF();

                System.out.println("클라이언트가 입력한 메시지는 다음과 같습니다: " + messageFromClient);
                if (messageFromClient.equals("exit")) {
                    break;
                }
                String processMessage = messageFromClient + "!!!";
                outputStream.writeUTF(processMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}