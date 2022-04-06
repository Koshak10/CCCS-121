import java.util.Arrays;
import java.util.Scanner;

public class Average {

    // The array which will contain the scores
    private final int[] data = new int[5];

    // The arithmetic average of the scores
    private double mean = 0;

    public Average() {
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter score number " + (i + 1 ) + ": ");
            data[i] = keyboard.nextInt();
        }

        selectionSort();
        calculateMean();
    }

    public void calculateMean() {
        double total = 0;

        for (int score : data) {
            total += score;
        }

        mean = total / data.length;
    }

    @Override
    public String toString() {
        return "Average{" +
                "data=" + Arrays.toString(data) +
                ", mean=" + mean +
                '}';
    }

    public void selectionSort() {
        int size = data.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i] < data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
