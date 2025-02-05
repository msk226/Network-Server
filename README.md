### HTTP Server Ver.2 

- Ver.2는 현재 멀티스레드를 적용했습니다. 기존 Ver.1과 달리 클라이언트와 서버 연결 시, 새로운 쓰레드를 생성하여 데이터를 주고 받기 때문에 기존 Ver.1에서 발생하던 여러 클라이언트 동시 접속 불가 문제를 해결 했습니다. 
- `ClientHandler`의 경우 `try-with-resources`를 적용하여 자원 정리를 진행 했습니다. 이로 인해 코드 가독성 향상 및 리소스 닫기 보장 등 이점을 얻을 수 있습니다. 


### 사용 방법 

1. `Server.java` 파일을 실행 시킨다.
2. `Client.java` 파일을 실행 시킨다. 먼저 `Client.java` 파일을 실행 하면, `java.net.ConnectException` 에러가 발생한다. 
3. `Client` 콘솔에서 `Server`에게 보내고 싶은 메시지를 입력한다. 프로그램을 종료하려면 `exit`를 입력 한다. 
4. 입력한 메세지에 대한 응답을 `Client` 콘솔에서 확인한다.

