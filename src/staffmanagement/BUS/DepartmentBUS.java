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
import staffmanagement.BUS.comparator.department.SortByMemberSizeASC;
import staffmanagement.BUS.comparator.department.SortByMemberSizeDESC;
import staffmanagement.BUS.comparator.department.SortByNameDepartmentASC;
import staffmanagement.DAO.DAO;
import staffmanagement.DAO.DepartmentDAO;
import staffmanagement.DTO.Department;

/**
 *
 * @author Admin
 */
public class DepartmentBUS implements BUS<Department> {

    private List<Department> departments;
    private DAO departmentDAO;

    public DepartmentBUS() {
        departments = new ArrayList<>();
        departmentDAO = new DepartmentDAO();
    }

    @Override
    public boolean add(Department dep) {
        if (dep != null) {
            if (departments.contains(dep)) {
                return false;
            }
            return departments.add(dep);
        }
        return false;
    }

    @Override
    public List<Department> getList() {
        List<Department> depTmp = departments;
        return depTmp;
    }

    @Override
    public boolean remove(Department dep) {
        if (dep != null && departments.contains(dep)) {
            return departments.remove(dep);
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (departments == null) {
            return false;
        }
        return departments.isEmpty();
    }

    @Override
    public Department findById(String id) {
        for (Department dep : departments) {
            if (dep.getId().compareToIgnoreCase(id) == 0) {
                return dep;
            }
        }
        return null;
    }

    @Override
    public boolean readData(File file) {
        departments.clear();
        departments = departmentDAO.getAll(file);
        return !departments.isEmpty();
    }

    @Override
    public boolean saveData(File file) {
        return departmentDAO.save(departments, file);

    }

    @Override
    public List<Department> findByName(String s) {
        List<Department> resultList = new ArrayList<>();
        var name = ".*" + s + ".*";
        Pattern pattern = Pattern.compile(name);
        Matcher matcher;
        for (var obj : departments) {
            matcher = pattern.matcher(obj.getName());
            if (matcher.matches()) {
                resultList.add(obj);
            }
        }
        return resultList;
    }

    @Override
    public List<Department> sortByName() {
        Collections.sort(departments, new SortByNameDepartmentASC());
        return departments;
    }
    
    public List<Department> sortByMemberSizeASC(){
        System.out.println("size asc");
        Collections.sort(departments, new SortByMemberSizeASC());
        return departments;
    }
    
    public List<Department> sortByMemberSizeDESC(){
        System.out.println("size desc");
        Collections.sort(departments, new SortByMemberSizeDESC());
        return departments;
    }

    @Override
    public boolean addAll(List<Department> list) {
        departments.addAll(list);
        return !departments.isEmpty();
    }

    @Override
    public boolean removeAll() {
        return departments.removeAll(departments);
    }

}

//gui->service->dao->data
