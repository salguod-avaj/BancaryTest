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
public class CurrentAccount extends Account{
    private double mensalTax;
    private final double withdrawTax;

    public CurrentAccount(double mensalTax, double withdrawTax, String name, int id, Double balance) {
        super(name, id, balance);
        this.mensalTax = 5;
        this.withdrawTax = 0.01;
    }

    
    public double getMensalTax() {
        return mensalTax;
    }

    
    public void setMensalTax(double mensalTax) {
        this.mensalTax = mensalTax;
    }

    
    public double getWithdrawTax() {
        return withdrawTax;
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
        this.balance -= amount + (amount * withdrawTax);
    }
    
    
    @Override
    public String companyRelatory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account (current), ");
        sb.append("name: ");
        sb.append(name);
        sb.append(", ID: ");
        sb.append(id);
        sb.append(". Balance: ");
        sb.append(balance);
        sb.append("$");
        
        return sb.toString();
    }
    public void mensalTax() {
        this.balance -= mensalTax;
    }
    
    
    
   
    
    
    
    
    
}
