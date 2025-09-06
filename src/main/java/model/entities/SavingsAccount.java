/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.exceptions.InvalidDepositException;
import model.exceptions.InvalidWithdrawException;

/**
 *
 * @author dg
 */
public class SavingsAccount extends Account{
    private final double interestRate;

    public SavingsAccount(double interestRate, String name, int id, Double balance) {
        super(name, id, balance);
        this.interestRate= 0.005;
    }

   
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(double amount) {
        if(amount < 0) {
            throw new InvalidDepositException("deposit cannot be negative");
        } 
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if(amount > balance) {
            throw new InvalidWithdrawException("withdraw value cannot be higher than balance");
        }
        if(amount > (balance * 0.5)) {
            throw new InvalidWithdrawException("only 50% is withdrawable");
        }
        this.balance -= amount;
    }
    @Override
    public String companyRelatory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account (Savings), ");
        sb.append("name: ");
        sb.append(name);
        sb.append(", ID: ");
        sb.append(id);
        sb.append(". Balance: ");
        sb.append(balance);
        sb.append("$");
        
        return sb.toString();
    }
    
     public void applyInterest() {
        this.balance += (this.balance * interestRate);
    }
     
    
    
    
    
    
}
