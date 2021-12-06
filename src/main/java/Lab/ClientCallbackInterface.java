package Lab;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface ClientCallbackInterface extends Remote {
    Integer getClId() throws RemoteException;
    void informFromServer(HashMap<Integer, Inform> obj) throws RemoteException;
}
