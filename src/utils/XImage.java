
package utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class XImage {
    public static Image getAppIcon(){
        URL url  = XImage.class.getResource("/Hinh/fpt.png");  // nhân về url vì nó chỉ là đường dẫn
        return new ImageIcon(url).getImage();                             // cái này là tới đường dẫn đó r lấy ra cái hình
    }
    
    public static void save(File src){
        File dst = new File("logos", src.getName());//trả về tên đường dẫn file
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();                                             //tạo thự mục logo nếu ch tồn tại
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getCanonicalPath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);//copy vào thư mục logo
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
//    public static ImageIcon read(String fileName){
//        File path = new File("logos", fileName);
//        return new ImageIcon(path.getAbsolutePath());
//    }
    
    public static ImageIcon read(String file){
        File f = new File("logos", file);
        ImageIcon icon = new ImageIcon(f.getAbsolutePath());
        ImageIcon nIcon = chinhAnh(icon);
        return icon;
    }
    
    
     private static ImageIcon chinhAnh(ImageIcon icon){
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(128, 158,  Image.SCALE_SMOOTH); 
            icon = new ImageIcon(newImg);
            return icon;
    }
}
