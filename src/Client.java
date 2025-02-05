import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final Integer PORT = 11111;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", PORT); // 연결할 서버의 정보

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("서버에게 전송할 메시지를 입력해주세요.");
            String nextLine = sc.nextLine();
            outputStream.writeUTF(nextLine);

            if (nextLine.equals("exit")) {
                break;
            }

            String messageFromServer = inputStream.readUTF();
            System.out.println("응답은 다음과 같습니다: " + messageFromServer);
        }

        // 자원 정리
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
