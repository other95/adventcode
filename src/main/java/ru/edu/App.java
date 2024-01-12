package ru.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if ( args.length != 1 ) {
            return;
        }
        String filename = args[0];

        FileManager fileManager = new FileManager(filename);

        fileManager.save(fileManager.getLineCount(),fileManager.getSpaceCount(),fileManager.getLongestLine());

    }
}
