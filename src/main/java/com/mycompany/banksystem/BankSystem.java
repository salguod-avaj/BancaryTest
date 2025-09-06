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
            
            
            
            System.out.println("After one month"); // test
            for(Account x : list) {
                if(x instanceof CurrentAccount) {
                    CurrentAccount z = (CurrentAccount) x;
                    z.mensalTax();
                    x.deposit(600);
                    x.withdraw(500);
                }
            }
            
            for(Account x : list) {
                System.out.println("\n" + x.companyRelatory());
            }
            
            sc.close();
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
        
    }
}
