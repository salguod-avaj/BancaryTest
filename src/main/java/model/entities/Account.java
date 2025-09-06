/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.exceptions.InvalidBalanceException;

/**
 *
 * @author dg
 */
public abstract class Account {
    protected String name;
    protected int id;
    protected Double balance;
    
    public Account(String name, int id, Double initialDeposit)  {
        this.name = name;
        this.id = id;
        this.balance = 0.0;
        if(initialDeposit < 0) {
            throw new InvalidBalanceException("Balance cannot be negative");
        }
        deposit(initialDeposit);
    }

    
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }

   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    public Double getBalance() {
        return balance;
    }

   
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public abstract void deposit(double amount);
    
    public abstract void withdraw(double amount);
    
    public abstract String companyRelatory();
    
}
