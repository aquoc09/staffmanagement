/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exception;

/**
 *
 * @author Admin
 */
public class InvalidEmailException extends Exception {
    
    private String invalidEmail;

    /**
     * Creates a new instance of <code>InvalidEmailException</code> without
     * detail message.
     */
    public InvalidEmailException() {
    }

    /**
     * Constructs an instance of <code>InvalidEmailException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     * @param invalidEmail
     */
    public InvalidEmailException(String msg, String invalidEmail) {
        super(msg);
        this.invalidEmail = invalidEmail;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }
    
    
    
    
}
