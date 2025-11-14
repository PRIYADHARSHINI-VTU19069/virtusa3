package virtusacodes;
import java.util.*;

public class RomanConverstion {

    public static String numtoRoman(int num) {
        String romanletter = "";

        // THOUSANDS ROMAN CALC
        while (num >= 1000) {
            romanletter += "M";
            num -= 1000;
        }

        // HUNDREDS ROMAN CALC
        if (num >= 900) {
            romanletter += "CM";
            num -= 900;
        }

        else if (num >= 500) {
            romanletter += "D";
            num -= 500;
        }

        else if (num >= 400) {
            romanletter += "CD";
            num -= 400;
        }

        while (num >= 100) {
            romanletter += "C";
            num -= 100;
        }

        //TENS ROMAN CALC
        if (num >= 90) {
            romanletter += "XC";
            num -= 90;
        }

        else if (num >= 50) {
            romanletter += "L";
            num -= 50;
        }

        else if (num >= 40) {
            romanletter += "XL";
            num -= 40;
        }

        while (num >= 10) {
            romanletter += "X";
            num -= 10;
        }

        //ONES ROMAN CALC
        if (num >= 9) {
            romanletter += "IX";
            num -= 9;
        }

        else if (num >= 5) {
            romanletter += "V";
            num -= 5;
        }

        else if (num >= 4) {
            romanletter += "IV";
            num -= 4;
        }

        while (num >= 1) {
            romanletter += "I";
            num -= 1;
        }

        return romanletter;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers between 1 and 9999: ");
        int num = sc.nextInt();
        if (num < 1 || num > 9999){
            System.out.println("Invalid number.Please give num btw 1 to 9999");
        }else{
            System.out.println("The roman letter for the number" + num +" is: " + numtoRoman(num));
        }

        sc.close();
    }
}


