/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanagement.BUS.filter;

import java.io.File;

/**
 *
 * @author Admin
 */
public class FileFilterUtils {

    public static final String TXT = ".txt";
    

    public static String getExtenstion(File file) {
        String ex = "";
        var fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        if (index > 0) {
            ex = fileName.substring(index);
        }
        return ex;
    }
}
