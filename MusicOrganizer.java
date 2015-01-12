import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * realiza una impresion del listado de las canciones guardadas
     */
    public void listAllFiles()
    {

        int index = 1;
        for(String fileName : files)
        {
            System.out.println(index + ".-" +fileName);
            index++;
        }

    }

    /**
     * 
     */
    public void listMaching(String searchString)
    {
        boolean contain = false;
        for (String filename : files)
        {
            if (filename.contains(searchString))
            {
                System.out.println(filename);
                contain = true;
            }
        }

        if (!contain)
        {
            System.out.println("Error, no se a encontrado ninguna archivo que contenaga " + 
                "`" + searchString + "´" );
        }
    }

    /**
     * reproduce primeros minutos de las canciones 
     * que contienen en el titulo el texto pasado por parametro
     */
    public void playFirstSecond(String autorName)
    {
        boolean contain = false;
        for (String filename : files)
        {
            if (filename.contains(autorName))
            {
                this.player.playSample(filename);
                contain = true;
            }
        }

        if (!contain)
        {
            System.out.println("Error, no se a encontrado ninguna cnación de " + 
                "`" + autorName + "´" );
        }  

    }
    /**
     * retorna la indice del primer archivo 
     * que contenga la cadena pasada por parametro
     */
    
    public int findFirst(String nameFile)
    {
        boolean found = false;
        int find = -1;
        int index = 0;
        while (!found && index < files.size())
        {
            if(this.files.get(index).contains(nameFile))
            {
                found = true;
                find = index;
            }
            index++;
        }
        return find;
    }

}
