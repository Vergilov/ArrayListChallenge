package com.vergilov;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Mobilephone mobilephone = new Mobilephone("38283212");

    public static void main(String[] args) {


        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.println("Choose Option");
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 1:
                    printContact();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Shutting Down...");
                    break;
            }
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println(" 1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.\n" +
                "7 - Shutdown Phone");
        System.out.println("Choose your action: ");
    }

    public static void printContact() {
        mobilephone.printContact();
    }

    public static void addContact() {
        System.out.println("Enter new contact name: ");
        String contactName = sc.nextLine();
        System.out.println("Enter phone number: ");
        String contactNumber = sc.nextLine();
        Contact contact = Contact.createContact(contactName, contactNumber);
        if (mobilephone.addContact(contact)) {
            System.out.println("New Contact added:" + contactName +
                    " Number: " + contactNumber);
        }else {
            System.out.println("Cannot add, " + contactName + " already on file");
        }
    }

    public static void updateContact() {
        System.out.println("Type Contact Name: ");
        String contactName = sc.nextLine();
        Contact oldContact =mobilephone.queryContact(contactName);
        System.out.println("Type new Contact Name: ");
        String newContactName = sc.nextLine();
        System.out.println("Type new Contact Phone Number: ");
        String newContactNumber = sc.nextLine();
        Contact newContact=Contact.createContact(newContactName,newContactNumber);
        mobilephone.updateContact(oldContact,newContact);
    }

    public static void removeContact() {
        System.out.println("Type Number of Contact to remove: ");
        int noToRemove = sc.nextInt();
    }

    public static void queryContact() {
        System.out.println("Type contact to find: ");
        String contactName = sc.nextLine();
    }
}
