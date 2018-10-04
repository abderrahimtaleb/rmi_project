import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abderrahim Dev on 02/06/2018.
 */
public class FilesProvider extends UnicastRemoteObject implements IProvider  {

    List<String> files;
    OutputStream osFile;

    public FilesProvider() throws RemoteException{
        files = new ArrayList<>();
    }
    @Override
    public List<String> getFiles(String chemin) throws RemoteException {

        //récupérer la liste des fichiers de dossier spécifié par le chemin
        File[] listOfFiles = new File(chemin).listFiles();
        files.clear();
        //parcourir la liste
        for (int i = 0; i < listOfFiles.length; i++) {
            //s 'il s'agit d'un fichier
            if (listOfFiles[i].isFile()) {
                files.add(" Fichier : " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                //s 'il s'agit d'un dossier
                files.add(" Dossier : " + listOfFiles[i].getName());
            }
        }
        return files;
    }

    @Override
    public byte[] getFile(String chemin) throws RemoteException {

        try {
            File file = new File(chemin);
            byte buffer[] = new byte[(int)file.length()];

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(chemin));
            input.read(buffer,0,buffer.length);
            input.close();
            return(buffer);

        } catch(Exception e){
            System.out.println("FileImpl: "+e.getMessage());
            e.printStackTrace();
            return(null);
        }
    }
}
