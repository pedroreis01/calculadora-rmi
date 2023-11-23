import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Server implements ICalculadora {
        
    public Server() {}

    public double adicao(double x, double y) throws RemoteException {
        return x + y;
    }

    public double subtracao(double x, double y) throws RemoteException {
        return x - y;
    }

    public double multiplicacao(double x, double y) throws RemoteException {
        return x * y;
    }

    public double divisao(double x, double y) throws RemoteException {
        if (y != 0) {
            return x / y;
        } else {
            throw new RemoteException("Divisão por zero não permitida.");
        }
    }
        
    public static void main(String args[]) {
        
        try {
            //Create and export a remote object
            Server obj = new Server();
            ICalculadora calculadora = (ICalculadora) UnicastRemoteObject.exportObject(obj, 0);

            //Register the remote object with a Java RMI registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            registry.bind("ICalculadora", calculadora);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}