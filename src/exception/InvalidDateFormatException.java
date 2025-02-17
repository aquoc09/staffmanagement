/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exception;

/**
 *
 * @author Admin
 */
public class InvalidDateFormatException extends Exception {
    
    private String invalidDate;

    /**
     * Creates a new instance of <code>InvalidDateFormatException</code> without
     * detail message.
     */
    public InvalidDateFormatException() {
    }

    /**
     * Constructs an instance of <code>InvalidDateFormatException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDateFormatException(String msg, String invalidDate) {
        super(msg);
        this.invalidDate = invalidDate;
    }

    public String getInvalidDate() {
        return invalidDate;
    }
    
    
}
