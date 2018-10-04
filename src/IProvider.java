import java.io.OutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Abderrahim Dev on 02/06/2018.
 */
public interface IProvider extends Remote {
    //methode permettant de retourner la liste des fichiers d'un répertoire
     List<String> getFiles(String chemin) throws RemoteException;

     //méthode permettant de télécharger un fichier
     byte[] getFile(String chemin) throws RemoteException;
}
