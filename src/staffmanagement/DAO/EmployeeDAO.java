/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.DAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import staffmanagement.DTO.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeDAO implements DAO<Employee> {

    @Override
    public boolean save(List<Employee> data, File file) {
        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(fileWriter)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Employee emp : data) {
                writer.write(emp.getId() + " - " + emp.getFullName() + " - "
                        + emp.getCccd() + " - "
                        + (emp.getSex() ? "Nam" : "Nữ") + " - "
                        + sdf.format(emp.getDob()) + " - "
                        + emp.getEmail() + " - "
                        + emp.getAddress() + " - "
                        + (emp.getDepartment() != null
                        ? emp.getDepartment().getId() : "null")
                        + " - " + emp.getPosition() + " - "
                        + emp.getBaseSalary());
                writer.newLine();
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Employee> getAll(File file) {
        throw new UnsupportedOperationException(
                "Object Employee not supports reading file Department"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
