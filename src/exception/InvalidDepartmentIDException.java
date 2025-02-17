/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exception;

/**
 *
 * @author Admin
 */
public class InvalidDepartmentIDException extends Exception {
    
    private String invalidId;

    /**
     * Creates a new instance of <code>InvalidDepartmentIdException</code>
     * without detail message.
     */
    public InvalidDepartmentIDException() {
    }

    /**
     * Constructs an instance of <code>InvalidDepartmentIdException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     * @param invalidId
     */
    public InvalidDepartmentIDException(String msg, String invalidId) {
        super(msg);
        this.invalidId = invalidId;
    }

    public String getInvalidId() {
        return invalidId;
    }
    
    
}
