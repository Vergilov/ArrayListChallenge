package com.vergilov;

import java.util.ArrayList;

public class Mobilephone {
    private ArrayList<Contact> myContacts;
    private String number;

    public Mobilephone(String number) {
        this.myContacts = new ArrayList<Contact>();
        this.number = number;
    }

    public void printContact() {
        if (myContacts.size()>=0) {
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println((i + 1) + ". " + myContacts.get(i).getContactName()+" "
                        + myContacts.get(i).getContactNumber());
            }
        } else {
            System.out.println("You have no contacts!");
        }
    }

    public boolean addContact(Contact contact) {
        if(findContact(contact.getContactName()) >=0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getContactName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if (index >= 0) {
            myContacts.set(index, newContact);
            System.out.println("New Name: "+newContact.getContactName()+" number"+newContact.getContactNumber());
        } else {
            System.out.println("Cant Replace contact!");
        }
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getContactName();
        }
        return null;
    }

    public Contact queryContact(String contactName) {
        int position = findContact(contactName);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void removeContact(String nameContact) {
        int index = findContact(nameContact);
        if (index >= 0) {
            myContacts.remove(index);
        } else {
            System.out.println("Contact not found!");
        }
    }
}
