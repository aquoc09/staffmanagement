/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.BUS.comparator.employee;

import staffmanagement.DTO.Employee;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class SortByBaseSalaryDESC implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getBaseSalary()-o2.getBaseSalary());
    }
    
}
