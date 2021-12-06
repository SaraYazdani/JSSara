package Lab;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Inform implements Serializable {
    private Integer clId;
    private int[][] pos;
    private ClientCallbackInterface cci = null;

    private int messagesFromServer;
    private int messagesFromClient;

    public Inform(ClientCallbackInterface cb) throws RemoteException {
        super();
    }

    public int[][] getPos() {
        return pos;
    }

    public void setPos(int[][] pos) {
        this.pos = pos;
    }

    public Integer getClId() {
        return clId;
    }

    public ClientCallbackInterface getCci() {
        return cci;
    }

    public int getMessagesFromClient() {
        return messagesFromClient;
    }

    public void setMessagesFromClient(int cm) {
        this.messagesFromClient = cm;
    }

    public int getMessagesFromServer() {
        return messagesFromServer;
    }

    public void setMessagesFromServer(int sm) {
        this.messagesFromServer = sm;
    }
}
