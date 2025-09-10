/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banksystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.entities.CurrentAccount;
import model.entities.SavingsAccount;
import model.exceptions.InvalidBalanceException;
import model.exceptions.InvalidDepositException;
import model.exceptions.InvalidWithdrawException;

/**
 *
 * @author dg
 */
public class BankSystem {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Account> list = new ArrayList<>();
        try {
            System.out.println("How many employeers will be: ");
            int n = sc.nextInt();
            
            for(int i = 0; i < n; i++) {
                sc.nextLine();
                System.out.println("Employee #" + (i + 1));
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("ID: ");
                int id = sc.nextInt();
                System.out.println("Enter you inicial deposit: ");
                Double initialDeposit = sc.nextDouble();
                System.out.println("Enter your account type(Current or Savings)  C/S: ");
                char choice = sc.next().toLowerCase().charAt(0);
                if(choice == 'c') {
                    list.add(new CurrentAccount(5, 0.01, name, id, initialDeposit));
                }
                else if(choice == 's') {
                    list.add(new SavingsAccount(0.005, name, id, initialDeposit));
                }  
            }
            
            for(Account x : list) {
                System.out.println(x.companyRelatory());
            }
            
            optionsMenu(list, sc);
            
            
            
        }
        catch(InputMismatchException e) {
            System.out.println("Invalid Type");
        }
        catch(InvalidWithdrawException e) {
            System.out.println(e.getMessage());
        }
        catch(InvalidDepositException e) {
            System.out.println(e.getMessage());
        }
        catch(InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
        
    }
    
    public static void optionsMenu(List<Account> list, Scanner sc) {
        int newChoice;
        do {
           
                System.out.println("[1] withdraw");
                System.out.println("[2] deposit");
                System.out.println("[3] create a new account");
                System.out.println("[4] delete a created account");
                System.out.println("[5] show relatory");
                System.out.println("[6] quit");
                
                newChoice = sc.nextInt();
                switch(newChoice) {
                    case 1:
                        System.out.println("Insert the id");
                        int newId = sc.nextInt();
                        for(Account x : list) {
                            if(newId == x.getId()) {
                                System.out.println("Enter the amount to withdraw: ");
                                double withdraw = sc.nextDouble();
                                x.withdraw(withdraw);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Insert the id: ");
                        newId = sc.nextInt();
                        for(Account x : list) {
                            if(newId == x.getId()) {
                                System.out.println("Enter the amount to deposit: ");
                                double deposit = sc.nextDouble();
                                x.deposit(deposit);
                            }
                        }
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Enter your name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter a id: ");
                        newId = sc.nextInt();
                        System.out.println("Enter a initial deposit: ");
                        Double newInitialDeposit = sc.nextDouble();
                        System.out.println("Enter your account type [C/S]");
                        char typeChoice = sc.next().toLowerCase().charAt(0);
                        if(typeChoice == 'c') {
                            list.add(new CurrentAccount(5,0.01, name, newId, newInitialDeposit));
                        }
                        else if(typeChoice == 's') {
                            list.add(new SavingsAccount(0.005, name, newId, newInitialDeposit));
                        }
                        break;
                    case 4:
                        System.out.println("Enter the id of the account to delete: ");
                        int idToDelete = sc.nextInt();
                        boolean removed = list.removeIf(acc -> acc.getId() == idToDelete);
                        if(removed) {
                            System.out.println("Account successfully removed;");
                        }
                        else {
                            System.out.println("This id does not exist");
                        }
                        break;
                    case 5:
                        for(Account x : list) {
                            System.out.println(x.companyRelatory());
                        }
                        break;
                    case 6:
                        System.out.println("System has quit");
                        
                }
            } while(newChoice != 6);  
    }
}
