/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exceptions;

/**
 *
 * @author dg
 */
public class InvalidDepositException extends RuntimeException {
    public InvalidDepositException(String msg) {
        super(msg);
    }
}
