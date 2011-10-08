import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface ServerIntfGUI extends Remote {
    public String getMessage() throws RemoteException;
    public void setMessage(String a) throws RemoteException;
}
