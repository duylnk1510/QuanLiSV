
package utils;

import entity.NhanVien;

public class Auth {
    public static NhanVien user = null;

    public static void clear(){                                                             // clear user
        Auth.user = null;
    }
    
    public static boolean isLogin(){                                                //đã đăng nhập đc tài khoản
        return Auth.user != null;
    }
    
    public static boolean isManager(){                                              //đã đăng nhập đc tài khoản và vai trò
        return Auth.isLogin() && user.isVaiTro();// mặc định này là true : trưởng phòng
    }
    
}
