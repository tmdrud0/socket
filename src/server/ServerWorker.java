package server;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public abstract class ServerWorker implements Runnable {
    protected Socket socket;
    protected InputStream iStream;
    protected OutputStream oStream;
    protected final int MAX_BYTE = 1024;
    public ServerWorker(Socket socket) {
        this.socket = socket;
        try{
            iStream = socket.getInputStream();
            oStream = socket.getOutputStream();
        }   catch(Exception e){
            System.out.println("서버워커 초기화 오류");
            e.printStackTrace();
        }    
    }
    protected void closeSocket(){
        try {
            iStream.close();
            oStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("서버워커 소켓 close 오류");
            e.printStackTrace();
        }
    }
    
    abstract protected String work(String input);

    @Override
    public void run ()
    {
        try{
            while (true){
                byte[] bt = new byte[MAX_BYTE];
                int size = iStream.read(bt);

                String input = new String(bt, 0, size, "UTF-8");
                System.out.println(input);
                String output = work(input);
                oStream.write(output.getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception e){
            System.out.println("서버워커 실행 오류");
            e.printStackTrace();
        }
        closeSocket();
    }
}