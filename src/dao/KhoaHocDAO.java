
package dao;

import entity.KhoaHoc;
import utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoaHocDAO extends DAO<KhoaHoc, String>{
    String insert = "INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (?,?,?,?,?,?,?) ";
    String update = "UPDATE KhoaHoc SET MaCD = ?, HocPhi = ?, ThoiLuong = ?, NgayKG = ?, GhiChu = ?, MaNV = ?, NgayTao = ? WHERE MaKH = ? ";
    String delete = "DELETE FROM KhoaHoc WHERE MaKH = ? ";
    String selectAll = "SELECT * FROM KhoaHoc ";
    String selectById = "SELECT * FROM KhoaHoc WHERE MaKH = ? ";
    
    @Override
    public void insert(KhoaHoc entity) {
        XJdbc.update(insert, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), 
                                                      entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao());
    }

    @Override
    public void update(KhoaHoc entity) {
        XJdbc.update(update, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), 
                                                      entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao(), entity.getMaKH());
    }

    @Override
    public void delete(String id) {
        XJdbc.update(delete, id);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return this.selectBySql(selectAll);
    }

    @Override
    public KhoaHoc selectById(String id) {
        List<KhoaHoc> list = this.selectBySql(selectById, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<KhoaHoc>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {                
                KhoaHoc entity = new KhoaHoc();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaCD(rs.getString("MaCD"));
                entity.setHocPhi(rs.getDouble("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setNgayKG(rs.getDate("NgayKG"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<KhoaHoc> selectByChuyenDe(String macd){
        String sql = "SELECT * FROM KhoaHoc WHERE MaCD = ? ";
        return this.selectBySql(sql, macd);
    }
    
    public List<Integer> selectYears(){
        String sql = "SELECT DISTINCT year(NgayKG) FROM KhoaHoc ORDER BY year(NgayKG) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
}
