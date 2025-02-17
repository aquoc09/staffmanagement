/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.DTO;

import exception.InvalidEmailException;
import exception.InvalidEmployeeIDException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Employee implements Serializable{

    private String id;
    private String cccd;
    private String fullName;
    private boolean sex;
    private Date dob;
    private String email;
    private String address;
    private Department department;
    private String position;
    private long baseSalary;
    
    public Employee() {
    }

    public Employee(String id, String cccd, String fullName, boolean sex,
             Date dob, String email, String address,
             Department department, String position, long baseSalary)
            throws InvalidEmployeeIDException, InvalidEmailException {
        setId(id);
        this.cccd = cccd;
        this.fullName = fullName;
        this.sex = sex;
        this.dob = dob;
        setEmail(email);
        this.address = address;
        this.department = department;
        this.position = position;
        this.baseSalary = baseSalary;
    }
    


    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public void setDobString(String dob){
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dateFormat.parse(dob);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        setDob(date);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        var regex = "^[a-zA-Z0-9_.]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            var msg = "Invalid id: " + email;
            throw new InvalidEmailException(msg, email);
        }
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidEmployeeIDException {
        id = id.toLowerCase();
        var regex = "^c[0-9]{5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        if (matcher.matches()) {
            this.id = id;
        } else {
            var msg = "Invalid id: " + id;
            throw new InvalidEmployeeIDException(msg, id);
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(long baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.id, other.getId());
    }

}
