package virtusacodes;

import java.util.Scanner;


public class RomanConversionusingarray {

    // Method to convert integer to Roman numeral
    public static String convertToRoman(int number) {
        if (number <= 0 || number > 9999) {
            return "Invalid Input! Please enter a number between 1 and 9999.";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number between 1 to 9999 ");
        int num = sc.nextInt();

        String romanValue = convertToRoman(num);
        System.out.println("Roman Letter of " + num + " is: " + romanValue);

        sc.close();
    }
}

