import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote {
    double adicao(double x, double y) throws RemoteException;
    double subtracao(double x, double y) throws RemoteException;
    double multiplicacao(double x, double y) throws RemoteException;
    double divisao(double x, double y) throws RemoteException;
}