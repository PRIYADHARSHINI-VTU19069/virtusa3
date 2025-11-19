package main;

import bal.LeaveBal;
import bal.LeaveBalImp;
import exception.LeaveException;
import model.LeaveDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class LeaveMain {

    static LeaveBal leaveBal = new LeaveBalImp();
    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- LEAVE MANAGEMENT MENU ---");
            System.out.println("1. Add Leave");
            System.out.println("2. Show Leave");
            System.out.println("3. Search Leave");
            System.out.println("4. Update Leave");
            System.out.println("5. Delete Leave");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    try {
                        addLeave();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    showLeave();
                    break;

                case 3:
                    searchLeave();
                    break;

                case 4:
                    try {
                        updateLeave();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 5:
                    deleteLeave();
                    break;

                case 6:
                    System.out.println("Exiting... Bye!");
                    System.exit(0);
            }

        } while (choice != 6);
    }

    // Add Leave
    private static void addLeave() throws ParseException, LeaveException {
        LeaveDetails leave = new LeaveDetails();

        System.out.print("Enter Leave ID: ");
        leave.setLeaveId(sc.nextInt());

        System.out.print("Enter Employee ID: ");
        leave.setEmpId(sc.nextInt());

        System.out.print("Enter Start Date (dd-MM-yyyy): ");
        leave.setLeaveStartDate(sdf.parse(sc.next()));

        System.out.print("Enter End Date (dd-MM-yyyy): ");
        leave.setLeaveEndDate(sdf.parse(sc.next()));

        System.out.print("Enter Leave Reason: ");
        leave.setLeaveReason(sc.next());

        System.out.println(leaveBal.addLeaveBal(leave));
    }

    // Show Leaves
    private static void showLeave() {
        List<LeaveDetails> list = leaveBal.showLeaveBal();
        list.forEach(System.out::println);
    }

    // Search Leave
    private static void searchLeave() {
        System.out.print("Enter Leave ID to Search: ");
        int id = sc.nextInt();

        LeaveDetails leave = leaveBal.searchLeaveBal(id);

        if (leave != null) {
            System.out.println(leave);
        } else {
            System.out.println("Leave Not Found");
        }
    }

    // Update Leave
    private static void updateLeave() throws ParseException, LeaveException {
        LeaveDetails leave = new LeaveDetails();

        System.out.print("Enter Leave ID to Update: ");
        leave.setLeaveId(sc.nextInt());

        System.out.print("Enter Employee ID: ");
        leave.setEmpId(sc.nextInt());

        System.out.print("Enter New Start Date (dd-MM-yyyy): ");
        leave.setLeaveStartDate(sdf.parse(sc.next()));

        System.out.print("Enter New End Date (dd-MM-yyyy): ");
        leave.setLeaveEndDate(sdf.parse(sc.next()));

        System.out.print("Enter Reason: ");
        leave.setLeaveReason(sc.next());

        System.out.println(leaveBal.updateLeaveBal(leave));
    }

    // Delete Leave
    private static void deleteLeave() {
        System.out.print("Enter Leave ID to Delete: ");
        int id = sc.nextInt();
        System.out.println(leaveBal.deleteLeaveBal(id));
    }
}