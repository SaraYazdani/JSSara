package Lab;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    Integer setClId(ClientCallbackInterface cb) throws RemoteException;

    void sendInform(Inform obj) throws RemoteException;

    Inform sendUpdatesToServer() throws RemoteException;
}
