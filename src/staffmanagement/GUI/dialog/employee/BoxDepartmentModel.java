/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.GUI.dialog.employee;

import staffmanagement.DTO.Department;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Admin
 */
public class BoxDepartmentModel implements ComboBoxModel<String>{
    private final List<Department> departments;
    private Object selectedItem;

    public BoxDepartmentModel(List<Department> deps) {
        this.departments = deps;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return departments.size();
    }

    @Override
    public String getElementAt(int index) {
        return departments.get(index).getName();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
