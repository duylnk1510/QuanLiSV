/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.HocVien;
import utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dy
 */
public class HocVienDAO extends DAO<HocVien, Integer>{
    String insert = "INSERT INTO HocVien (MaKH, MaNH, Diem) VALUES (?,?,?) ";
    String update = "UPDATE HocVien SET MaKH = ?, MaNH = ?, Diem = ? WHERE MaHV = ? ";
    String delete = "DELETE FROM HocVien WHERE MaHV = ? ";
    String selectAll = "SELECT * FROM HocVien ";
    String selectById = "SELECT * FROM HocVien WHERE MaHV = ? ";
    
    @Override
    public void insert(HocVien entity) {
        XJdbc.update(insert, entity.getMaKH(), entity.getMaNH(), entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        XJdbc.update(update, entity.getMaKH(), entity.getMaNH(), entity.getDiem(), entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(delete, id);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectBySql(selectAll);
    }

    @Override
    public HocVien selectById(Integer id) {
        List<HocVien> list = this.selectBySql(selectById, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<HocVien>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {                
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("MaHV"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNH(rs.getString("MaNH"));
                entity.setDiem(rs.getDouble("Diem"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public  List<HocVien> selectByKhoaHoc(int maKH){
        String sql = "SELECT * FROM HocVien WHERE MaKH = ?";
        return this.selectBySql(sql, maKH);
    }
}
