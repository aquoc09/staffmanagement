/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package staffmanagement.BUS;

/**
 *
 * @author Admin
 */
public enum EntityType {
    EMP("Employee"), DEP("Department");
    private final String value;

    private EntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
