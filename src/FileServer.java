import java.net.Socket;

import manager.Manager;
import manager.file.*;
import server.*;

public class FileServer extends ObjectServer {
    Manager manager;
    public FileServer(Socket socket) {
        super(socket);
        manager = new Manager(new FileTokens(), new FileMachine());
        setManager(manager);
    }
    public static void main(String[] args) {
        Server server = new Server(Server.DEFAULT_PORT,FileServer.class);
        server.run();
    }
}