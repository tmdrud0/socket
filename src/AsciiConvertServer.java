import java.net.Socket;
import java.util.stream.*;

import server.*;

public class AsciiConvertServer extends ServerWorker{
    public AsciiConvertServer(Socket socket) {
        super(socket);
    }

    @Override
    protected String work(String input){
        IntStream intStream = input.chars();
        String output = intStream.mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" "));
        return output;
    }
    public static void main(String[] args) {
        Server server = new Server(Server.DEFAULT_PORT,AsciiConvertServer.class);
        server.run();
    }
}