package client;

import java.net.InetAddress;
import java.util.Scanner;

public class SysInClient extends Client{
    Scanner scanner;
    final String EXIT_STRING = "exit";
    public SysInClient(int port, InetAddress iAddress) {
        super(port, iAddress);
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while(true){
            String input = scanner.nextLine();
            if(input.equals(EXIT_STRING))   break;
            
            String resultString = sendString(input);
            System.out.println(resultString);
        }
        exit();
    }

    void exit(){
        super.exit();
        scanner.close();
    }

    public static void main(String[] args) {
        InetAddress local = null;
        try{
            local = InetAddress.getLocalHost();
        } catch (Exception e) {
            System.out.println("iNet 생성 오류");
            e.printStackTrace();
        }  
        Client client = new SysInClient(DEFAULT_PORT, local);
        client.run();
    }
}