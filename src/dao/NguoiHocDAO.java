
package dao;

import entity.NguoiHoc;
import utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NguoiHocDAO extends DAO<NguoiHoc, String>{
    String insert = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (?,?,?,?,?,?,?,?,?) ";
    String update = "UPDATE NguoiHoc SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, DienThoai = ?, Email = ?, GhiChu = ?, MaNV = ?, NgayDK = ? WHERE MaNH = ? ";
    String delete = "DELETE FROM NguoiHoc WHERE MaNH = ? ";
    String selectAll = "SELECT * FROM NguoiHoc ";
    String selectById = "SELECT * FROM NguoiHoc WHERE MaNH = ? ";
    
    @Override
    public void insert(NguoiHoc entity) {
        XJdbc.update(insert, entity.getMaNH(), entity.getHoTen(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getDienThoai(),
                                                      entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK());
    }

    @Override
    public void update(NguoiHoc entity) {
        XJdbc.update(update, entity.getHoTen(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getDienThoai(), 
                                                        entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK(), entity.getMaNH());
    }

    @Override
    public void delete(String id) {
        XJdbc.update(delete, id);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return this.selectBySql(selectAll);
    }

    @Override
    public NguoiHoc selectById(String id) {
        List<NguoiHoc> list = this.selectBySql(selectById, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<NguoiHoc>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {                
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("MaNH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setEmail(rs.getString("Email"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayDK(rs.getDate("NgayDK"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<NguoiHoc> selectByKeyword(String keyword){
        String sql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ? OR MaNH LIKE ? OR DienThoai LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }
    
    public List<NguoiHoc> selectNotInCourse( String keyword, int makh){
        String sql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ? AND MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH = ?)";
        return this.selectBySql(sql, "%" + keyword + "%", makh);
    }

}
