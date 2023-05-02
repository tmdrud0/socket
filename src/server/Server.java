package server;
import java.lang.reflect.Constructor;
import java.net.*;

public class Server{
	int port;
	Constructor<?> constructor;
	ServerSocket serverSocket;

	public final static int DEFAULT_PORT = 4000;

	public Server(int port, Class<? extends ServerWorker> serverWorker){
		this.port = port;
		try {
			constructor = serverWorker.getDeclaredConstructor(Socket.class);
			serverSocket = new ServerSocket(port);
		} catch (Exception e) {System.out.println("서버 생성 오류");e.printStackTrace();}
	}

	public void run(){
		while(true){
			try{
				Socket connection = serverSocket.accept();
				ServerWorker task = (ServerWorker)constructor.newInstance(connection);
				task.run();
			}catch(Exception e){System.out.println("서버 실행 오류");e.printStackTrace();}
		}
	}
}