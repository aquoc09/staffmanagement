/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package staffmanagement.BUS;

import java.io.File;
import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface BUS<T> {
    //trả về danh danh sách
    List<T> getList();
    
    //thêm 1 obj vào list
    boolean add(T t);
    
    //thêm nhiều obj vào list
    boolean addAll(List<T> list);
    
    //xóa 1 obj khỏi list
    boolean remove(T t);
    
    //xóa nhiều obj khỏi list
    boolean removeAll();
    
    //tìm 1 obj bằng id
    T findById(String s);
    
    //tìm 1 obj bằng tên
    List<T> findByName(String s);
    
    //kiểm tra list có rỗng không
    boolean isEmpty();
    
    //đọc list từ DAO
    boolean readData(File file);
    
    //ghi dữ liệu vào file
    boolean saveData(File file);
    
    List<T> sortByName();
}
