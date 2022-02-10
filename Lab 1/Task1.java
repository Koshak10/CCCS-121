/**
 *
 * Task #1 - Correcting Logic Errors in Formulas
 *
 */
public class NumericTypes {

    public static void main(String[] args) {
        final int NUMBER = 2;
        double SCORE1 = 100;
        int SCORE2 = 95;
        final int BOILING_IN_F = 212;

        double average = (SCORE1 + SCORE2) / NUMBER;
        String output = SCORE1 + " and " + SCORE2 + " have an average of " + average;
        System.out.println(output);

        int fToC = (5 * (BOILING_IN_F - 32)) / 9;
        output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
        System.out.println(output);
        System.out.println();
    }

}
