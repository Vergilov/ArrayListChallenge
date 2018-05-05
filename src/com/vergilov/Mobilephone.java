package com.vergilov;

import java.util.ArrayList;

public class Mobilephone {
    private ArrayList<Contact> myContacts;

    public void printContact() {
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i));
        }
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact) >= 0) {
            System.out.println(contact.getContactName() + " Contact exist! ");
            System.out.println("Position: " + myContacts.indexOf(contact));
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }


    public int findContact(String nameContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getContactName().equals(nameContact)) {
                return i;
            }
        }
        return -1;
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        int index=findContact(oldContact);
        if(index>=0){
            myContacts.set(index,newContact);
        }else {
            System.out.println("Cant Replace contact!");
        }
    }

    public String queryContact(Contact contact) {
        if(findContact(contact)>=0){
        return contact.getContactName();
    }
    return null;
}

    public Contact queryContact(String contactName){
        int position = findContact(contactName);
        if(position>=0){
            return this.myContacts.get(position);
        }
        return null;
    }
    public void removeContact(String nameContact){
        int index=findContact(nameContact);
        if(index>=0) {
            myContacts.remove(index);
        } else{
            System.out.println("Contact not found!");
        }
    }
}
