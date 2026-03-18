package com.sms;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Email: ");
                    String email = sc.next();

                    System.out.print("Enter Course: ");
                    String course = sc.next();

                    StudentDAO.addStudent(name, email, course);
                    break;

                case 2:
                    StudentDAO.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new name: ");
                    String newName = sc.next();

                    StudentDAO.updateStudent(uid, newName);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    StudentDAO.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}



