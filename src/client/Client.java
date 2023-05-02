package client;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public abstract class Client {
    Socket socket;
	InputStream iStream;
	OutputStream oStream;

    static final int DEFAULT_PORT = 4000;
    final int MAX_BYTE = 1024;

    public Client(int port,InetAddress iAddress){
        try {
            socket = new Socket(iAddress, port);
			iStream = socket.getInputStream();
			oStream = socket.getOutputStream();
        } catch (Exception e) {
            System.out.println("클라이언트 생성 오류");e.printStackTrace();
        }
    }   

    String sendString(String output){
        String input = "";
        try {
            oStream.write(output.getBytes(StandardCharsets.UTF_8));

            byte[] bt = new byte[MAX_BYTE]; 
            int size = iStream.read(bt);
            input = new String(bt, 0, size, "UTF-8");
            
        } catch (Exception e) {
            System.out.println("클라이언트 전송 오류");e.printStackTrace();
        }        
        return input;
    }
    void exit(){
        try {
            iStream.close();
            oStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("클라이언트 종료 오류");e.printStackTrace();
        }        
    }
    public abstract void run();
}