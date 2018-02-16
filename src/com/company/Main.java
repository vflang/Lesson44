package com.company;
/*
i don't know what im doing
First, let’s modify this puppy so it saves the bankAccount objects (name, deposit) to a .txt file.
When more items are added, amend to that file.
--> writeToFile method in bankAccount class


Next, let’s add a debug mode in the tester so that if the user types debug, you can access a menu:
- debug mode like in the main class? what do i put in the menu??

Finally, modify the program that incorporates a log. This log will record ALL transactions to a .txt file.
Anytime a user is added or deposited, it will store the information. I do mean ALL so any calls to methods should be logged.

Debug mode allows the user to retrieve a listing of all deposits sorted by using comparables from largest to smallest.

Debug mode allows the user to retrieve a listing of account balances sorted using comparables from largest to smallest.

Debug mode allows the user to “drain” an account and place it Mr. Pennebacker’s account.
Once drained, the user from which the account was drained is there but the deposits were of no value.

 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here

        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String name;
        ArrayList aryLst = new ArrayList();
        ListIterator iter = aryLst.listIterator();
        do {
            Scanner kbReader = new Scanner(System.in);
            System.out
                    .print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = kbReader.nextLine();
            if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" "); // gives an eye pleasing blank line
                // between accounts
                bankAccount theAccount = new bankAccount(name, amount);
                iter.add(theAccount);

                //add this to a txt file
                File bankTransactions = new File(name);
                ObjectOutputStream thisbank = new ObjectOutputStream(new FileOutputStream(name + "'s Transactions"));
                thisbank.writeObject(amount);
                thisbank.flush();
                thisbank.close();
                //well it's supposed to sort the txt file somehow mmmmmm somehow indeed



            } else if (name.equalsIgnoreCase("debug")){ //IF USER PUTS IN DEBUG

                System.out.println("You are now in debug mode! Your options are: \n\"Get List\"\n\"Get Balance\"\n+" +
                        "\"Drain\"");
                Scanner userChoice = new Scanner(System.in);
                String debugSelection = userChoice.nextLine();
                if (debugSelection.equalsIgnoreCase("get list")){
                    BufferedReader in = new BufferedReader(new FileReader("bankTransactions"));
                    String line;
                    while((line = in.readLine()) != null)
                    {
                        System.out.println(line);
                    }
                    in.close();
                    //taken from https://stackoverflow.com/questions/731365/reading-and-displaying-data-from-a-txt-file
                    //b/c man what do

                }else if (debugSelection.equalsIgnoreCase("get balance")){
                    System.out.println("eEK");
                    BufferedReader tm = new BufferedReader(new FileReader("allBankAccounts"));
                    String line;
                    while((line = tm.readLine()) != null)
                    {
                        System.out.println(line);
                    }
                    tm.close();

                }else if (debugSelection.equalsIgnoreCase("drain")){
                    //why just drain one when you can drain all
                    ArrayList<Integer> banks = new ArrayList<Integer>();
                    //banks.addAll stuff inside of txt file
                    int MrPBankAccount = 0;
                    int sum = 0;
                    for (int i=0; i<banks.size();i++){ //i kinda didn't put the balues of the bank account into an arraylist so
                        //banks should be replaced with an arraylist of the values
                        //im going to go study for ap friday now heck
                        if (i!=1-banks.size()){
                            sum = banks.get(i) + sum;
                            banks.set(i, 0);
                        }else{
                            MrPBankAccount = sum;
                        }
                    }
                    System.out.println("Mr P's bank account now contains $" + MrPBankAccount);


                }else{
                    System.out.println("That is not an option, but to be honest, even if you did input a correct option," +
                            "it doesn't even work.");
                }
            }


        } while (!name.equalsIgnoreCase("EXIT"));

        // Search aryLst and print out the name and amount of the largest bank
        // account
        bankAccount ba = (bankAccount) iter.previous();
        double maxBalance = ba.balance; // set last account as the winner so far
        String maxName = ba.name;
        while (iter.hasPrevious()) {
            ba = (bankAccount) iter.previous();
            if (ba.balance > maxBalance) {
                // We have a new winner, chicken dinner
                maxBalance = ba.balance;
                maxName = ba.name;
            }
        }
        System.out.println(" ");
        System.out.println("The account with the largest balance belongs to "
                + maxName + ".");
        System.out.println("The amount is $" + fmt.format(maxBalance) + ".");

    }
}
