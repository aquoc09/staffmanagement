/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package staffmanagement.DAO;

import java.io.File;
import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface DAO<T> {
    
    //public <T> List<T> getAll(File file);
    
    boolean save(List<T> data, File file);

    List<T> getAll(File file);
    
}
