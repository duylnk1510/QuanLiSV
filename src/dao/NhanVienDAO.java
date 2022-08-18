package dao;

import java.util.List;

import entity.NhanVien;
import utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhanVienDAO extends DAO<NhanVien, String> {
    String insert = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, Email, VaiTro) VALUES (?,?,?,?,?) ";
    String update = "UPDATE NhanVien SET MatKhau = ?, HoTen = ?, Email = ?, VaiTro = ? WHERE MaNV = ? ";
    String delete = "DELETE FROM NhanVien WHERE MaNV = ? ";
    String selectAll = "SELECT * FROM NhanVien ";
    String selectById = "SELECT * FROM NhanVien WHERE MaNV = ? ";

    @Override
    public void insert(NhanVien entity) {
        XJdbc.update(insert, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.getEmail(), entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        XJdbc.update(update, entity.getMatKhau(), entity.getHoTen(), entity.getEmail(), entity.isVaiTro(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        XJdbc.update(delete, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(selectAll);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(selectById, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {                
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setEmail(rs.getString("Email"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
