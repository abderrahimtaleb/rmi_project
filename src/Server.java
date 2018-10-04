import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Abderrahim Dev on 02/06/2018.
 */
public class Server {
    public static void main(String args[])
    {
     try {
         //création de l'objet FilesProvider
         FilesProvider fp = new FilesProvider();

         //enregistrement à RMI registry au port 1099
         LocateRegistry.createRegistry(1099);

        // Enregistre l'objet crée auprès du serveur de noms.
         Naming.rebind("FileProvider",fp);

         System.out.println("Serveur démmaré ! ");

     }catch (Exception ex)
     {
         ex.printStackTrace();
     }
    }
}
