import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program creates a list of songs for a CD by reading from a file.
 */
public class CompactDisc {

    public static void main(String[] args) throws IOException {
        File file = new File("Classics.txt");
        Scanner input = new Scanner(file);
        String title;
        String artist;

        // ADD LINES FOR TASK #3 HERE
        // Declare an array of Song objects, called cd, with a size of 6
        Song[] cd = new Song[6];
        for (int i = 0; i < cd.length; i++) {
            title = input.nextLine();
            artist = input.nextLine();

            // ADD LINES FOR TASK #3 HERE
            // Fill the array by creating a new song with
            // the title and artist and storing it in the
            // appropriate position in the array
            cd[i] = new Song(title, artist);
        }

        System.out.println("Contents of Classics:");
        for (Song song : cd) {
            // ADD LINES FOR TASK #3 HERE
            // Print the contents of the array to the console
            System.out.print(song);
        }
    }

}
