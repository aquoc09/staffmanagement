/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exception;

/**
 *
 * @author Admin
 */
public class InvalidEmployeeIDException extends Exception {
    
    private String invalidId;

    /**
     * Creates a new instance of <code>InvalidEmployeeIdException</code> without
     * detail message.
     */
    public InvalidEmployeeIDException() {
    }

    /**
     * Constructs an instance of <code>InvalidEmployeeIdException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     * @param invalidId
     */
    public InvalidEmployeeIDException(String msg, String invalidId) {
        super(msg);
        this.invalidId = invalidId;
    }

    public String getInvalidId() {
        return invalidId;
    }
    
    
}
