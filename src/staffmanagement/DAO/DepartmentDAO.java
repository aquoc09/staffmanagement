/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.DAO;

import exception.InvalidEmailException;
import exception.InvalidEmployeeIDException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import staffmanagement.DTO.Department;
import staffmanagement.DTO.Employee;

/**
 *
 * @author Admin
 */
public class DepartmentDAO implements DAO<Department> {

    @Override
    public boolean save(List<Department> data, File file) {
        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (Department dept : data) {
                writer.write("- Department: " + dept.getId() + " - "
                        + dept.getName() + " - " + dept.getEmpList().size());
                writer.newLine();
                if (!dept.getEmpList().isEmpty()) {
                    writer.write("+ Employee of " + dept.getId() + ":");
                    writer.newLine();
                    writer.newLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    for (Employee emp : dept.getEmpList()) {
                        writer.write(emp.getId() + " - " + emp.getCccd() + " - "
                                + emp.getFullName() + " - "
                                + (emp.getSex() ? "Nam" : "Nữ") + " - "
                                + sdf.format(emp.getDob()) + " - "
                                + emp.getEmail() + " - "
                                + emp.getAddress() + " - "
                                + (emp.getDepartment() != null
                                ? emp.getDepartment().getId() : "null")
                                + " - " + emp.getPosition() + " - "
                                + emp.getBaseSalary());
                        writer.newLine();
                        writer.newLine();
                    }
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Department> getAll(File file) {
        List<Department> departments = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            Department currentDept = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("- Department: ")) {
                    //đọc dữ liệu
                    String[] parts = line.substring(14).split(" - ");
                    String id = parts[0];
                    String name = parts[1];
                    int empCount = Integer.parseInt(parts[2]);
                    //init dept
                    currentDept = new Department(id, name); //khởi tạo dept hiện tại
                    while (empCount > 0) {
                        line = reader.readLine(); // xuống dòng để check thông tin khi dsach nhân viên >0
                        if (line.startsWith("+ Employee of "
                                + currentDept.getId() + ":")) {
                            line = reader.readLine();
                            line = reader.readLine();
                        } else {
                            line = reader.readLine();
                        }
                        String[] partsEmp = line.split(" - ");
                        //System.out.println(partsEmp.length);
                        Employee emp = new Employee();
                        emp.setId(partsEmp[0].trim());
                        emp.setFullName(partsEmp[1].trim());
                        emp.setCccd(partsEmp[2].trim());
                        emp.setSex("Nam".equals(partsEmp[3].trim()));
                        emp.setDobString(partsEmp[4].trim());
                        emp.setEmail(partsEmp[5].trim());
                        emp.setAddress(partsEmp[6].trim());
                        emp.setDepartment(currentDept); // Tìm phòng ban theo ID
                        emp.setPosition(partsEmp[8].trim());
                        emp.setBaseSalary(Long.parseLong(partsEmp[9].trim()));

                        currentDept.getEmpList().add(emp); //thêm nv vào dept hiện tại
                        empCount--;
                    }
                    departments.add(currentDept);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InvalidEmployeeIDException | InvalidEmailException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
    }

}
