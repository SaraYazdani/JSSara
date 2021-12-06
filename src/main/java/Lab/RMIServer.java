package Lab;

import java.net.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    private final static int DEFAULT_PORT = 9000;
    private final static String DEFAULT_HOST = "tbd";
    private static String HOST_NAME;
    private static InetAddress a = null;
    private static RMIServer rmi;

    private static  ServerMethods sm;
    private static String serverId = "ServerMethods";

    public RMIServer() throws RemoteException, MalformedURLException, NotBoundException, AlreadyBoundException {
        LocateRegistry.createRegistry(DEFAULT_PORT);
        System.out.println("Remote implementation object created!");
        String urlString = "//" + HOST_NAME + ":" + DEFAULT_PORT + "/" + "LABYRINTHE";
        //Naming.rebind(urlString, S);
    }
}
