package virtusacodes;

import java.util.Scanner;

public class ElectricityslabBill {
        // Each slab {limit, rate}
        // limit = maximum units in that slab
        double[][] slabs = {
                {90, 1.0},        // first 90 units
                {60, 1.5},        // next 60 units (91-150)
                {50, 2.0},        // next 50 units (151-200)
                {40, 2.5},        // next 40 units (201-240)
                {999999, 3.0}     // remaining units 240+
        };

        public double calculateBill(int units) {
            double amount = 0;

            for (double[] slab : slabs) {
                double slabLimit = slab[0];  // how many units allowed in this slab
                double rate = slab[1];       // cost per unit

                if (units > slabLimit) {
                    amount += slabLimit * rate;
                    units -= slabLimit;
                } else {
                    amount += units * rate;
                    break;  // no more units left
                }
            }

            return amount;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter units consumed: ");
            int units = sc.nextInt();

            ElectricityslabBill obj = new ElectricityslabBill();

            double bill = obj.calculateBill(units);

            System.out.println("Bill Amount: ₹" + bill);
        }
    }


