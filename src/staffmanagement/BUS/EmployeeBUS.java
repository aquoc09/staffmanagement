/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.BUS;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import staffmanagement.BUS.comparator.employee.SortByBaseSalaryASC;
import staffmanagement.BUS.comparator.employee.SortByBaseSalaryDESC;
import staffmanagement.BUS.comparator.employee.SortByNameEmployeeASC;
import staffmanagement.DAO.DAO;
import staffmanagement.DAO.EmployeeDAO;
import staffmanagement.DTO.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeBUS implements BUS<Employee> {

    private List<Employee> employees;
    private DAO employeeDAO;

    public EmployeeBUS() {
        employees = new ArrayList<>();
        employeeDAO = new EmployeeDAO();
    }

    @Override
    public List<Employee> getList() {
        List<Employee> empTmp = employees;
        return empTmp;
    }

    @Override
    public boolean add(Employee t) {
        if (t == null && employees.contains(t)) {
            return false;
        }
        return employees.add(t);
    }

    @Override
    public boolean remove(Employee t) {
        if (t == null && employees.contains(t)) {
            return false;
        }
        return employees.remove(t);
    }

    @Override
    public Employee findById(String s) {
        for (var emp : employees) {
            if (emp.getId().compareToIgnoreCase(s) == 0) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return employees.isEmpty();
    }

    @Override
    public boolean saveData(File file) {
        return employeeDAO.save(employees, file);
    }

    @Override
    public List<Employee> findByName(String s) {
        List<Employee> resultList = new ArrayList<>();
        var name = ".*" + s + ".*";
        Pattern pattern = Pattern.compile(name);
        Matcher matcher;
        for (var obj : employees) {
            matcher = pattern.matcher(obj.getFullName());
            if (matcher.matches()) {
                resultList.add(obj);
            }
        }
        return resultList;
    }

    @Override
    public List<Employee> sortByName() {
        Collections.sort(employees, new SortByNameEmployeeASC());
        return employees;
    }

    public List<Employee> sortBySalaryASC() {
        Collections.sort(employees, new SortByBaseSalaryASC());
        return employees;
    }

    public List<Employee> sortBySalaryDESC() {
        Collections.sort(employees, new SortByBaseSalaryDESC());
        return employees;
    }

    @Override
    public boolean addAll(List<Employee> list) {
        employees.addAll(list);
        return !employees.isEmpty();
    }

    @Override
    public boolean removeAll() {
        return employees.removeAll(employees);
    }

    @Override
    public boolean readData(File file) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
