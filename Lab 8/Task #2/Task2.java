import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) throws IOException {
        File file = new File("secret.txt");
        Scanner inputFile = new Scanner(file);

        StringBuilder stringBuilder = new StringBuilder();
        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] tokens = str.split(" ");

            for (int i = 0; i < tokens.length; i++) {
                if (i % 5 == 0) {
                    stringBuilder.append(tokens[i].toUpperCase().charAt(0));
                }
            }

        }

        System.out.println(stringBuilder);
        inputFile.close();
    }

}
