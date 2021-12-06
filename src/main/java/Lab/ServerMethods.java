package Lab;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServerMethods extends UnicastRemoteObject implements ServerInterface {
    private int clId = 0;
    private HashMap<Integer, ClientCallbackInterface> clientList = new HashMap<>();
    private HashMap<Integer, Inform> informHashMap = new HashMap<>();
    private int clientMessagesReceived = 0;
    private int clientMessagesSent = 0;

    protected ServerMethods() throws RemoteException {}

    @Override
    public Integer setClId(ClientCallbackInterface cb) throws RemoteException {
        synchronized (clientList) {
            int id = clId++;
            clientList.put(id, cb);
            return id;
        }
    }

    @Override
    public void sendInform(Inform obj) throws RemoteException {
        synchronized (clientList) {
            synchronized (informHashMap) {
                clientMessagesReceived++;
                if(!clientList.containsKey(obj.getClId())) {
                    clientList.put(obj.getClId(), obj.getCci());
                }

                obj.setMessagesFromClient(clientMessagesSent);
                obj.setMessagesFromServer(clientMessagesReceived);

                informHashMap.put(obj.getClId(), obj);
            }
        }
    }

    @Override
    public Inform sendUpdatesToServer() throws RemoteException{
        synchronized (clientList) {
            synchronized (informHashMap) {
                clientList.forEach((id, client) -> {
                    try {
                        client.informFromServer(informHashMap);
                        clientMessagesSent++;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                });
            }
        }
        return null;
    }

}
