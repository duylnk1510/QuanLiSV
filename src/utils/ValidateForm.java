package utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;

public class ValidateForm {

    public static boolean Rong(JTextField txt, Component parent, String msg) {
        if (!chung(txt.getText().trim().length() == 0, txt, parent, msg)) {
            return true;
        }
        return false;
    }

    public static void mauTrang(JTextField txt) {
        txt.setBackground(Color.white);
    }

    public static void mauDo(JTextField txt) {
        txt.setBackground(Color.red);
    }

    public static boolean soSanh2MatKhau(JTextField txt1, JTextField txt2, Component parent,
            String msg1, String msg2, String msg3) {
        if (Rong(txt1, parent, msg1)) {
            return false;
        }
        if (Rong(txt2, parent, msg2)) {
            return false;
        }
        if (!chung(!txt1.getText().equals(txt2.getText()), txt2, parent, msg3)) {
            return false;
        }
        return true;
    }

    public static boolean motRongMotSai(JTextField txtRong, Component parent, String txtSai, String msg1, String msg2) {
        if (Rong(txtRong, parent, msg1)) {
            return false;
        }

        if (!chung(!txtRong.getText().equals(txtSai), txtRong, parent, msg2)) {
            return false;
        }
        return true;
    }
    
    public final static String regEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public final static String regSĐT = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
    public final static String regMa = "^(PS|ps)[0-9]{5}";
        
    public static boolean rongVoiDinhDang(JTextField txt, Component parent, String msg1, String msg2, String reg) {  
        if (Rong(txt, parent, msg1)) {
            return false;
        }
        if (!chung(!txt.getText().matches(reg), txt, parent, msg2)) {
            return false;
        }
        return true;
    }
    
    public static boolean rongNgay(JDateChooser calendar){
        if (calendar.getDate() == null) {
            MsgBox.alert(null, "Vui lòng chọn ngày và đúng định dạng cảm ơn!");
            return false;
        }
        return true;
    }
    

    public static boolean chung(boolean dk, JTextField txt, Component parent, String msg) {
        if (dk) {
            MsgBox.alert(parent, msg);
            mauDo(txt);
            txt.requestFocus();
            return false;
        }
        return true;
    }

}
