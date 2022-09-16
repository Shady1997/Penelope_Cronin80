package utilites;

import java.text.DecimalFormat;
import java.util.Random;

public class GenerateData {

    // generate random string for data driven test
    public static String generateString(int StringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = StringLength;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    // generate random character
    public static char generateCharacter() {

        return generateString(1).charAt(0);
    }

    // generate random integer number
    public static int generateInteger(int upperBound) {
        Random rand = new Random(); // instance of random class
        // generate random values from 0-24
        int int_random = rand.nextInt(upperBound);
        return int_random;
    }

    // generate random float number
    public static float generateFloat(int digitLength) {
        Random rand = new Random(); // instance of random class
        float float_random = rand.nextFloat();
        DecimalFormat df = new DecimalFormat(getDecimalFormat(digitLength));// format double digits
        float p = Float.parseFloat(df.format(float_random));
        return p;
    }

    // generate random double number
    public static double generateDouble(int digitLength) {
        Random rand = new Random(); // instance of random class
        double double_random = rand.nextDouble();// generate double number
        DecimalFormat df = new DecimalFormat(getDecimalFormat(digitLength));// format double digits
        double p = Double.parseDouble(df.format(double_random));
        return p;
    }

    // get decimal format
    public static String getDecimalFormat(int digitLength) {
        String doubleFormat = "#.";
        for (int i = 0; i < digitLength; i++) {
            doubleFormat += "#";
        }
        return doubleFormat;
    }
}
