import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * Taylor Huntington
 *
 */
public class PokeCsvReader {

    public static void main(String... args) {
        ArrayList<Pokemon> pokeList = readPokemon("pokeinput.csv");

        for (Pokemon p : pokeList) {
            System.out.println(p);
        }
    }

    Public ArrayList<Pokemon> readPokemon(String input) {

        //ArrayList<Pokemon> audList = new ArrayList<Pokemon>();
        //ArrayList<Pokemon> nonList = new ArrayList<Pokemon>();
        ArrayList<Pokemon> combinedList = new ArrayList<Pokemon>();

        Path pathToFile = Paths.get(input);

        // create an instance of BufferedReader

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String header = br.readLine();

            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                int[] spawns = line.split(",");
                int spawnlength = spawns.length();

                for(int i=1 ; i<=spawnlength ; i++ ) {

                    //If a Pokemon is spawned at point
                    if(spawns[i] > 0) {

                        if( i > 5) {
                            Pokemon nonaud = new Pokemon(spawns[i], spawns[0], False);
                            combinedList.add(nonaud);
                        }
                        else {
                            Pokemon inaud = new Pokemon(spawns[i], spawns[0], True);
                            combinedList.add(inaud);
                        }
                    }
                }

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return myList;
    }
}

}