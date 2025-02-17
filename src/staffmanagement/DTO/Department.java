/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.DTO;

import exception.InvalidDepartmentIDException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Department implements Serializable {

    private String id;
    private String name;
    private List<Employee> empList;

    public Department() {
        id = "";
        name = "";
        empList = new ArrayList<>();
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
        this.empList = new ArrayList<>();
    }

    public Department(String id, String name, List<Employee> empList)
            throws InvalidDepartmentIDException {
        setId(id);
        this.name = name;
        this.empList = empList;
    }

    public List<Employee> getEmpList() {
        if (empList == null) {
            empList = new ArrayList<>();
        }
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        if (empList == null) {
            empList = new ArrayList<>();
        }
        this.empList = empList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidDepartmentIDException {
        id = id.toLowerCase();
        var regex = "^f[0-9]{5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        if (matcher.matches()) {
            this.id = id;
        } else {
            var msg = "Invalid Id";
            throw new InvalidDepartmentIDException(msg, id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
