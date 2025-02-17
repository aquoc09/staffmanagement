/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.BUS.comparator.department;

import staffmanagement.DTO.Department;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class SortByNameDepartmentASC implements Comparator<Department>{

    @Override
    public int compare(Department o1, Department o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

}
