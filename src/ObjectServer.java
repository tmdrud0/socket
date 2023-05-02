import java.net.Socket;

import manager.Manager;
import server.ServerWorker;

public class ObjectServer extends ServerWorker{
    Manager manager;
    public ObjectServer(Socket socket) {
        super(socket);
    }
    public void setManager(Manager manager){
        this.manager = manager;
    }
    @Override
    protected String work(String input) {
        return manager.work(input);
    }
}