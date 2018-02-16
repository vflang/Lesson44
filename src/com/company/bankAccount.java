package com.company;

/**
 * Created by dpennebacker on 2/13/17.
 * https://stackoverflow.com/questions/30413227/how-to-read-and-write-an-object-to-a-text-file-in-java
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class bankAccount implements Comparable {

    public bankAccount(String nm, double amt) {
        name = nm;
        balance = amt;
    }
    public static void writeToFile(String fileName, bankAccount[] bankAccounts) throws IOException {
            File allBankAccounts = new File(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(allBankAccounts));
            oos.writeObject(bankAccounts);
            oos.flush();
            oos.close();
            //First, let’s modify this puppy so it saves the bankAccount objects (name, deposit) to a .txt file.
            //When more items are added, ammend to that file.
        }

    public int compareTo(Object otherObject) {
        bankAccount otherAccount = (bankAccount) otherObject;
        int retValue;
        if (balance < otherAccount.balance) {
            retValue = -1;
        } else {
            if (balance > otherAccount.balance) {
                retValue = 1;
            } else {
                retValue = 0;
            }
        }
        return retValue;
    }

    public void deposit(double dp) {
        balance = balance + dp;
    }

    public void withdraw(double wd) {
        balance = balance - wd;
    }

    public String name;
    public double balance;

}
