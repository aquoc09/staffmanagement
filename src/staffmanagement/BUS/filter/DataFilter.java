/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.BUS.filter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Admin
 */
public class DataFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        var ex = FileFilterUtils.getExtenstion(f).toLowerCase();
        if (ex != null) {
            if (ex.equals(FileFilterUtils.TXT)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "file (*.txt)";
    }

}
