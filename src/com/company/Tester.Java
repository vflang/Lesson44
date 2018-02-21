package com.company;
import java.io.*;
import java.util.*;
import java.text.*; //for NumberFormat
/*Mr P's instructions:
So here we go...
Ex 44 - Google Doc
Three projects in the Lesson. Do them.
They will be submitted all one GitHub repository that you'll create.
Then, since there is 3, put them all in the same class and just comment out the differences.
You are essentially just modifying each to perform a new comparison.
 */
public class Tester {

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        String name;
        int j;
        bankAccount ba[] = new bankAccount[5];
        for(j = 0; j < ba.length; j++){
            Scanner kbReader = new Scanner(System.in);
            System.out.print("Please enter the name to whom" +
                    "the account belongs.");
            name = kbReader.nextLine();

            System.out.print("Please enter the amount of the deposit.");
            double amount = kbReader.nextDouble();
            System.out.println(""); //gives a blank line between accounts
            ba[j] = new bankAccount(name, amount);
        }
        Comparator comp = new BA_comparator();  //why doesn't this work
        //also why does food taste so good help
        Arrays.sort(ba, comp); //i dunno how to get rid of this error but okie
        //^^^also this is the first part of the project
        for(j=0; j<ba.length; j++){
            System.out.println(ba[j].name+">>>"+ba[j].balance);
        }
    }
}
