import java.util.Random;

/**
 * This class simulates rolling a pair of dice 10,000 times and counts the
 * number of times doubles of are rolled for each different pair of doubles.
 */
public class DiceSimulation {

    public static void main(String[] args) {
        final int NUMBER = 10000;

        // A random number generator used in simulating the rolling of dice
        Random generator = new Random();

        int die1Value;
        int die2Value;
        int count = 0;
        int snakeEyes = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;

        while (count < NUMBER) {
            die1Value = generator.nextInt(1, 7);
            die2Value = generator.nextInt(1, 7);

            if (die1Value == die2Value) {
                switch (die1Value) {
                    case 1 -> snakeEyes++;
                    case 2 -> twos++;
                    case 3 -> threes++;
                    case 4 -> fours++;
                    case 5 -> fives++;
                    case 6 -> sixes++;
                    default -> {
                    }
                }
            }

            count++;
        }

        // Display the results
        System.out.println("You rolled snake eyes " + snakeEyes + " out of " + count + " rolls.");
        System.out.println("You rolled double twos " + twos + " out of " + count + " rolls.");
        System.out.println("You rolled double threes " + threes + " out of " + count + " rolls.");
        System.out.println("You rolled double fours " + fours + " out of " + count + " rolls.");
        System.out.println("You rolled double fives " + fives + " out of " + count + " rolls.");
        System.out.println("You rolled double sixes " + sixes + " out of " + count + " rolls.");
    }

}
